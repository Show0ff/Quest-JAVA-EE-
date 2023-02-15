package com.khlopin.socialwebsite.controllers.usersControllers;


import com.khlopin.socialwebsite.entity.user.User;
import com.khlopin.socialwebsite.services.CheckAdminService;
import com.khlopin.socialwebsite.utills.Constants;
import com.khlopin.socialwebsite.utills.DB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileServlet extends HttpServlet {

    //TODO Изменить на константы
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CheckAdminService.checkAdmin(request.getSession());
        User user = (User) request.getSession().getAttribute(Constants.USER);
        request.setAttribute(Constants.USER, user);
        request.setAttribute("userWall", user.getWall()); // his wall
        request.getRequestDispatcher("WEB-INF/myProfile.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        User userFromSession = (User) request.getSession().getAttribute(Constants.USER); // юзер который залогинин
        String postInput = parameterMap.get("postInput")[0];
        DB.postDataBase.addPostInListOfPostsInWall(userFromSession.getWall().getId(), userFromSession, postInput);
        doGet(request,response);
    }
}
