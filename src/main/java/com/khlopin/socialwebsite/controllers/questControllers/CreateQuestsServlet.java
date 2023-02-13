package com.khlopin.socialwebsite.controllers.questControllers;


import com.khlopin.socialwebsite.utills.RedirectPaths;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "CreateQuestsServlet", value = "/createQuests")
public class CreateQuestsServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(RedirectPaths.TO_CREATE_QUEST).forward(request,response);

    }

}
