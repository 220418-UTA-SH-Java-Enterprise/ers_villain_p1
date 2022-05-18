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
        final String URI = req.getRequestURI().replace("/ers_villain_p1/", "");
        log.info("URI: " + URI);

        switch (URI) {
            case "users": // query the DB and return a list of all users
                log.info("getting user list...");
                UserHelper.processFindAllUsers(req, resp);
                break;
            case "user":
                log.info("search user by name or id. URI: " + URI);
                UserHelper.processFindUserbyId(req, resp);
                break;
            case "userreimbresolved":
                log.info("search resolved reimb by user id. URI: " + URI);
                ReimbHelper.processFindResolvedByUserId(req, resp);
                break;
            case "userreimbpending":
                ReimbHelper.processFindPendingByUserId(req, resp);
                break;
            case "reimbs": // query the DB and return a list of all reimbursement requests
                log.info("getting user list...");
                ReimbHelper.processFindAllReimbs(req, resp);
                break;
            case "pendingreimbs":
                ReimbHelper.processPendingReimbs(req, resp);
                break;
            case "resolvedreimbs":
                ReimbHelper.processResolvedReimbs(req, resp);
                break;
            case "resolved":
                ReimbHelper.processFindAllResolvedReimbs(req, resp);
                break;
            case "userupdate":
                UserHelper.processUpdateUser(req, resp);
                break;
            case "employees":
                log.info("Get all employees by role Id...");
                UserHelper.processFindAllEmployees(req, resp);
                break;
            case "login":
                log.info("Login user with username and password...");
                UserHelper.processLogin(req, resp);
                break;  
            default:
                log.info("showing error message...");
                UserHelper.processError(req, resp);
                break;
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String URI = req.getRequestURI().replace("/ers_villain_p1/", "");
        log.info("URI: " + URI);

        switch (URI) {
            case "register": // query the DB and return a list of all users
                log.info("getting user list...");
                UserHelper.processRegistration(req, resp);
                break;
            case "login": // login
                UserHelper.processLogin(req, resp);
                break;
            case "createreimbrequest":
                ReimbHelper.processNewReimbRequest(req, resp);
                break;
            default:
                log.info("showing error message...");
                UserHelper.processError(req, resp);
                break;
        }
    }
}