package com.khlopin.socialwebsite.controllers.authControllers;


import com.khlopin.socialwebsite.entity.user.User;
import com.khlopin.socialwebsite.services.CheckAdminService;
import com.khlopin.socialwebsite.utills.Constants;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebServlet(name = "logOutServlet", value = "/logOut")
public class logOutServlet extends HttpServlet {
    private static final Logger log = LogManager.getLogger(logOutServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.USER);
        CheckAdminService.offAdmin(session);
        session.invalidate();
        log.info(user + " разлогинился");
        request.getRequestDispatcher("").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
