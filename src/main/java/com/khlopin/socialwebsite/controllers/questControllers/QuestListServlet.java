package com.khlopin.socialwebsite.controllers.questControllers;


import com.khlopin.socialwebsite.utills.Constants;
import com.khlopin.socialwebsite.utills.DB;
import com.khlopin.socialwebsite.utills.RedirectPaths;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "QuestListServlet", value = "/questList")
public class QuestListServlet extends HttpServlet {



    @Override
    public void init(ServletConfig config) throws ServletException {
        config.getServletContext().setAttribute(Constants.QUESTS, DB.questDataBase.getAll());
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute(Constants.USER) != null) {
            request.getRequestDispatcher(RedirectPaths.TO_QUEST_LIST).forward(request, response);
        }

    }
}
