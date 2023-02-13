package com.khlopin.socialwebsite.services;


import com.khlopin.socialwebsite.entity.user.Role;
import com.khlopin.socialwebsite.entity.user.User;
import com.khlopin.socialwebsite.utills.Constants;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CheckAdminService {

    @Getter
    private static boolean isAdmin = false;
    private static final Logger log = LogManager.getLogger(CheckAdminService.class);

    public static boolean checkAdmin(HttpSession session) {
        User user = (User) session.getAttribute(Constants.USER);
        if (user.getRole() == Role.ADMIN) {
            isAdmin = true;
            session.setAttribute(Constants.IS_ADMIN, isAdmin);
            log.warn(user + " авторизовался как администратор");
            return true;
        } else {
            isAdmin = false;
        }
        return false;
    }

    public static void offAdmin(HttpSession session) {
        isAdmin = false;
        session.setAttribute(Constants.IS_ADMIN,isAdmin);
    }



}
