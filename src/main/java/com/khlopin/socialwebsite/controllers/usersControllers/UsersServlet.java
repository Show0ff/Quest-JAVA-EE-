package com.khlopin.socialwebsite.controllers.usersControllers;


import com.khlopin.socialwebsite.entity.user.User;
import com.khlopin.socialwebsite.services.CheckAdminService;
import com.khlopin.socialwebsite.utills.DB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "UsersServlet", value = "/users")
public class UsersServlet extends HttpServlet {

    //TODO исправить String на константы


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (CheckAdminService.checkAdmin(request.getSession())) {
            Collection<User> allUsers = DB.userDataBase.getAll();
            request.setAttribute("users", allUsers);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/adminMenu/users.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
