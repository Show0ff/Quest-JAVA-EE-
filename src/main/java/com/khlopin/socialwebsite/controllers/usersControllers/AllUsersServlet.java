package com.khlopin.socialwebsite.controllers.usersControllers;

import com.khlopin.socialwebsite.entity.user.User;
import com.khlopin.socialwebsite.utills.DB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "AllUsersServlet", value = "/allUsers")
public class AllUsersServlet extends HttpServlet {
//    @Override
//    public void init() throws ServletException {
//        DB.initWallsForMap();
//        super.init();
//    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<User> allUsers = DB.userDataBase.getAll();
        request.setAttribute("users", allUsers);
        request.getRequestDispatcher("WEB-INF/topBarPages/allUsers.jsp").forward(request, response);
    }
}
