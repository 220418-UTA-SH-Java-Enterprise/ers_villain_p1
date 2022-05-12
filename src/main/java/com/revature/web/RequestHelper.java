package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RequestHelper {

    private static UserService userService = new UserServiceImpl();
    private static Logger logger = LogManager.getLogger(RequestHelper.class);
    private static ObjectMapper om = new ObjectMapper();

    public static void processRegistration(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        logger.info("inside of request helper...processRegistration...");
        BufferedReader reader = request.getReader();
        StringBuilder s = new StringBuilder();

        // we are just transferring our Reader data to our StringBuilder, line by line
        String line = reader.readLine();
        while (line != null) {
            s.append(line);
            line = reader.readLine();
        }

        String body = s.toString();
        String[] sepByAmp = body.split("&"); // separate username=bob&password=pass -> [username=bob, password=pass]

        List<String> values = new ArrayList<String>();

        for (String pair : sepByAmp) { // each element in array looks like this
            values.add(pair.substring(pair.indexOf("=") + 1)); // trim each String element in the array to just value ->
                                                               // [bob, pass]
        }
        logger.info("User attempted to register with information:\n " + body);
        // capture the actual username and password values
        String userName = values.get(0);
        String password = values.get(1);
        String firstName = values.get(2);
        String lastName = values.get(3);
        String email = values.get(4);
        int roleId = Integer.parseInt(values.get(5));

        User user = new User(userName, password, firstName, lastName, email, roleId);
        try {
            if (userService.addNewUser(user)) {
                PrintWriter pw = response.getWriter();
                // user.setUserId(targetId);
                logger.info("New user: " + user);
                String json = om.writeValueAsString(user);
                pw.println(json);
                System.out.println("JSON:\n" + json);

                response.setContentType("application/json");
                response.setStatus(200); // SUCCESSFUL!
                logger.info("User has successfully been created.");
            } else {
                response.setContentType("application/json");
                response.setStatus(204); // this means that the connection was successful but no user created!
            }
        } catch (Exception e) {
            logger.warn("Yeah, something went wrong creating a user.");
        }
        logger.info("leaving request helper now...");
    }

    public static void processError(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // if something goes wrong, redirect the user to a custom 404 error page
        req.getRequestDispatcher("error.html").forward(req, resp);
        /*
         * Remember that the forward() method does NOT produce a new request,
         * it just forwards it to a new resource, and we also maintain the URL
         */
    }
}