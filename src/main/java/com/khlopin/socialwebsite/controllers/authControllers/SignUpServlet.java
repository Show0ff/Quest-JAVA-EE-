package com.khlopin.socialwebsite.controllers.authControllers;


import com.khlopin.socialwebsite.entity.user.Role;
import com.khlopin.socialwebsite.entity.user.User;
import com.khlopin.socialwebsite.utills.Constants;
import com.khlopin.socialwebsite.utills.DB;
import com.khlopin.socialwebsite.utills.RedirectPaths;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@WebServlet(name = "SignUpServlet", value = "/signup")
public class SignUpServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(RedirectPaths.TO_SIGN_UP).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            DB.userDataBase.create(parameterMap.get(Constants.LOGIN)[0],
                    parameterMap.get(Constants.PASSWORD)[0],
                    Role.USER);
            Optional<User> user = DB.userDataBase.find(parameterMap.get(Constants.LOGIN)[0]);
            user.ifPresent(value -> DB.wallDataBase.createWallWithPostListForUser(value));
        } catch (RuntimeException e) {
            request.getRequestDispatcher(RedirectPaths.ALREADY_CREATED).forward(request,response);
        }

        request.getRequestDispatcher(RedirectPaths.COMPLETE).forward(request,response);
    }
}
