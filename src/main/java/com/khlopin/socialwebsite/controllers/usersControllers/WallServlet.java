package com.khlopin.socialwebsite.controllers.usersControllers;


import com.khlopin.socialwebsite.entity.user.User;
import com.khlopin.socialwebsite.utills.DB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "WallRepositoryServlet", value = "/wall")
public class WallServlet extends HttpServlet {
// if user == null, то не выполнять код, чтобы нельзя было сделать пост
    private User user;
    private Long idOfOwnerWall;
//    @Override
//    public void init() throws ServletException {
//        DB.initWallsForMap();
//        super.init();
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        idOfOwnerWall = Long.parseLong(request.getParameter("id"));
        continuePosting(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        User userFromSession = (User) request.getSession().getAttribute("user"); // юзер который залогинин
        String postInput = parameterMap.get("postInput")[0];
        DB.postDataBase.addPostInListOfPostsInWall(this.user.getWall().getId(), userFromSession, postInput);
        continuePosting(request,response);
    }

    protected void continuePosting(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        user = DB.userDataBase.get(idOfOwnerWall); // Owner of Wall
        request.setAttribute("user",user);
        request.setAttribute("userWall", user.getWall()); // his wall
        request.getRequestDispatcher("WEB-INF/wallThings/wall.jsp").forward(request, response);
    }
}
