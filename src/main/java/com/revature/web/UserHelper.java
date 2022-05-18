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
import com.revature.models.UserRole;
import com.revature.services.UserServiceImpl;

import org.apache.log4j.Logger;

public class UserHelper {

    private static UserServiceImpl userService = new UserServiceImpl();
    private static Logger logger = Logger.getLogger(UserHelper.class);
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
            values.add(pair.substring(pair.indexOf("=") + 1));
        }
        logger.info("User attempted to register with information:\n " + body);
        // capture the actual username and password values
        String username = values.get(0);
        String password = values.get(1);
        String firstName = values.get(2);
        String lastName = values.get(3);
        String email = values.get(4);
        int roleId = 1;

        UserRole role = new UserRole();
        role.setRoleId(roleId);

        User user = new User(username, password, firstName, lastName, email, role);
        try {
            user.setId(userService.addNewUser(user));

            PrintWriter pw = response.getWriter();
            // user.setUserId(targetId);
            logger.info("New user: " + user);
            String json = om.writeValueAsString(user);
            pw.println(json);
            System.out.println("JSON:\n" + json);

            response.setContentType("application/json");
            response.setStatus(200); // SUCCESSFUL!
            logger.info("User has successfully been created.");

        } catch (Exception e) {
            logger.warn("Yeah, something went wrong creating a user.");
        }
        logger.info("leaving request helper now...");
    }

    public static void processFindAllUsers(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        logger.info("inside of request helper...processfindAllUsers...");
        response.setContentType("application/json");

        List<User> allUsers = userService.getAllUsers();

        String json = om.writeValueAsString(allUsers);

        PrintWriter out = response.getWriter();

        out.println(json);

    }

    public static void processFindUserbyId(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        logger.info("In UserHelper, searching for user.");

        BufferedReader reader = request.getReader();
        StringBuilder s = new StringBuilder();

        String line = reader.readLine();
        while (line != null) {
            s.append(line);
            line = reader.readLine();
        }

        // username=charlie&password=alhaejklf&firstname=John&lastname=Smith
        String body = s.toString();
        logger.info(body);
        /**
         * Turns the string into an array
         * [0] username=charlie
         * [1] password=alhaejklf
         * [2] firstname=John
         * [3] lastname=Smith
         */
        String[] setByAmp = body.split("&");

        List<String> values = new ArrayList<String>();

        for (String pair : setByAmp) {
            values.add(pair.substring(pair.indexOf("=") + 1));
        }
        logger.info("User attempting to locate user with id" + body);

        if (body.startsWith("id")) {
            logger.info("Id prefix was found.");
            // 1. Set the content type to return text to the browser
            response.setContentType("application/json");

            // 2. Get the user in the Databse by id
            int id = Integer.parseInt(values.get(0));
            User user = userService.getUserById(id);

            // 3. Turn the list of Java objects into a JSON string (Jackson Databind)
            String json = om.writeValueAsString(user);

            // 4. Use a Print Writer to write the objects to the reponse body
            PrintWriter out = response.getWriter();
            out.println(json);
        }

    }

    public static void processUpdateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Update user stuff goes here...
    }

    public static void processFindAllEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
                logger.info("Inside of request helper...processfindAllEmployees...");
                response.setContentType("application/json");
        
                List<User> allEmployees = userService.getAllEmpById();
        
                String json = om.writeValueAsString(allEmployees);
        
                PrintWriter out = response.getWriter();
        
                out.println(json);
    }

    public static void processLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("Inside of request helper...processLogin...");
        response.setContentType("application/json");

        BufferedReader reader = request.getReader();
        StringBuilder s = new StringBuilder();

        String line = reader.readLine();
        while (line != null) {
            s.append(line);
            line = reader.readLine();
        }

        String body = s.toString();
        logger.info(body);

        String[] setByAmp = body.split("&");

        List<String> values = new ArrayList<String>();

        for (String pair : setByAmp) {
            values.add(pair.substring(pair.indexOf("=") + 1));
        }
        logger.info("User attempting to locate user with id and password" + body);

        String username = values.get(0);
        String password = values.get(1); 

        // 1. Set the content type to return text to the browser
        response.setContentType("application/json");

            // 2. Get the user in the Databse by name and password. 
            User user = null;
            try {
                user = userService.loginUser(username, password);
                if (user.getUserId()== 0) {
                    response.setStatus(401);
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid username and password.");
                }
            } catch (Exception e) {
                response.setStatus(401);
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            }

            // 3. Turn the list of Java objects into a JSON string (Jackson Databind)
            String json = om.writeValueAsString(user);

            // 4. Use a Print Writer to write the objects to the reponse body
            PrintWriter out = response.getWriter();
            out.println(json);
        
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
