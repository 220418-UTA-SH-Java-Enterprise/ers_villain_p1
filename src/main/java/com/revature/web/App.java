package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class App extends HttpServlet {

    private static final long serialVersionUID = 8339100247721381693L;

    private static Logger log = Logger.getLogger(App.class);

    // GET methods are used to retrieve resources from an API
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // save the URI and rewrite it to determine what functionality the user is
        // requesting based on that endpoint
        final String URI = req.getRequestURI().replace("/HelloFrontController/", "");
        log.info("URI: " + URI);

        switch (URI) {
            case "users": // query the DB and return a list of all users
                log.info("getting user list...");
                RequestHelper.processAllUsers(req, resp);
                break;
            case "user":
                log.info("search user by name or id. URI: " + URI);
                RequestHelper.processUserBySearchParam(req, resp);
                break;
            default:
                log.info("showing error message...");
                RequestHelper.processError(req, resp);
                break;
        }
    }
}