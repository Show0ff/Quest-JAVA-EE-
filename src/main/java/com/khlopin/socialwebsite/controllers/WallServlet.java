package com.khlopin.socialwebsite.controllers;


import com.khlopin.socialwebsite.entity.user.User;
import com.khlopin.socialwebsite.utills.DB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "WallRepositoryServlet", value = "/wall")
public class WallServlet extends HttpServlet {

    private User user;
    @Override
    public void init() throws ServletException {
        DB.initWallsForMap();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        user = (User) request.getSession().getAttribute("user");
        request.setAttribute("userWall",user.getWall());
        request.getRequestDispatcher("WEB-INF/wallThings/wall.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();

        String postInput = parameterMap.get("postInput")[0];
        DB.postRepository.addPostInListOfPostsInWall(user.getWall().getId(),user,postInput);
        doGet(request,response);
    }
}
