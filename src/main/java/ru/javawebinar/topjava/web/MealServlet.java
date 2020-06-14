package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.InMemoryMealDaoImpl;
import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;
import static ru.javawebinar.topjava.util.MealsUtil.filteredByStreams;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private MealDao dao = new InMemoryMealDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");

        String action = request.getParameter("action");

        if (action != null && action.equalsIgnoreCase("delete")) {
            int mealId = Integer.parseInt(request.getParameter("mealId"));
            dao.delete(mealId);
            response.sendRedirect("meals");
            return;
        } else if (action != null && action.equalsIgnoreCase("edit")) {
            int mealId = Integer.parseInt(request.getParameter("mealId"));
            Meal editMeal = dao.getById(mealId);
            request.setAttribute("editMeal", editMeal);
            request.getRequestDispatcher("mealsEdit.jsp").forward(request, response);
        } else if (action != null && action.equalsIgnoreCase("insert")) {
//            int mealId = Integer.parseInt(request.getParameter("mealId"));
            Meal editMeal = new Meal();
            request.setAttribute("editMeal", editMeal);
            request.getRequestDispatcher("mealsEdit.jsp").forward(request, response);
        }


        List<MealTo> mealsTo = filteredByStreams(dao.getAllMeal(), LocalTime.of(7, 0), LocalTime.of(23, 0), 2000);
        request.setAttribute("mealsTo", mealsTo);
        request.getRequestDispatcher("meals.jsp").forward(request, response);
        // response.sendRedirect("meals.jsp");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equalsIgnoreCase("edit")) {

            int mealId = Integer.parseInt(request.getParameter("mealId"));
            if (mealId != 0) {
                Meal editMeal = dao.getById(mealId);
                editMeal.setDescription(request.getParameter("description"));
                editMeal.setCalories(Integer.parseInt(request.getParameter("calories")));
                dao.save(editMeal);
                response.sendRedirect("meals");
            } else {
                Meal newMeal = new Meal();
                newMeal.setDescription(request.getParameter("description"));
                newMeal.setCalories(Integer.parseInt(request.getParameter("calories")));
                newMeal.setDateTime(LocalDateTime.now());
                dao.save(newMeal);
                response.sendRedirect("meals");
            }
        }
    }
}
