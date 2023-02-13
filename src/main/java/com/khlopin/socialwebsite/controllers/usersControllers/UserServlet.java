package com.khlopin.socialwebsite.controllers.usersControllers;


import com.khlopin.socialwebsite.entity.user.Role;
import com.khlopin.socialwebsite.entity.user.User;
import com.khlopin.socialwebsite.utills.Constants;
import com.khlopin.socialwebsite.utills.DB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {

    //TODO исправить String на константы

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        User user = DB.userDataBase.get(id);
        request.setAttribute(Constants.USER, user);
        request.getRequestDispatcher("WEB-INF/adminMenu/user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        User currentUser = DB.userDataBase.get(Long.parseLong(parameterMap.get("id")[0]));

        if (request.getParameter("delete") != null) {
            DB.userDataBase.delete(currentUser.getId());
        } else if (request.getParameter("update") != null) {
            User updatedUser = User.builder()
                    .id(Long.parseLong(parameterMap.get("id")[0]))
                    .userName(parameterMap.get("login")[0])
                    .password(parameterMap.get("password")[0])
                    .role(Role.valueOf(parameterMap.get("role")[0]))
                    .gameList(new ArrayList<>())
                    .build();
            DB.userDataBase.update(currentUser.getId(), updatedUser);
        }

        request.getRequestDispatcher("WEB-INF/adminMenu/complete.jsp").forward(request, response);
    }
}
