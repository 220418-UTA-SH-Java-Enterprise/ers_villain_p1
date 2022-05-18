package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.User;
import com.revature.services.ReimbServiceImpl;
import com.revature.services.UserServiceImpl;

import org.apache.log4j.Logger;

public class ReimbHelper {

    private static ReimbServiceImpl reimbService = new ReimbServiceImpl();
    private static UserServiceImpl userService = new UserServiceImpl();
    private static Logger logger = Logger.getLogger(UserHelper.class);
    private static ObjectMapper om = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();

    public static void processFindAllReimbs(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        logger.info("inside of request helper...processfindAllreimbs...");
        response.setContentType("application/json");

        List<Reimb> allReimbs = reimbService.getAllReimbs();

        String json = om.writeValueAsString(allReimbs);

        PrintWriter out = response.getWriter();

        out.println(json);
    }

    public static void processNewReimbRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        logger.info("Inside reimb request helper...processNewReimbRequest...");
        BufferedReader reader = request.getReader();
        StringBuilder s = new StringBuilder();

        // We are just transferring out Reader data to our StirngBuilder
        String line = reader.readLine();
        while (line != null) {
            // add a new line
            s.append(line);
            // move to next line
            line = reader.readLine();
        }

        String body = s.toString();

        /**
         * Separate out:
         * amount, submitted, description, receipt, author, type
         * Everything else should be set automatically since this is a new request
         */
        String[] sepByAmp = body.split("&");

        List<String> values = new ArrayList<String>();

        for (String pair : sepByAmp) {
            values.add(pair.substring(pair.indexOf("=") + 1));
        }

        logger.info("reimbursement information provided: " + body);

        /**
         * Set the values to variables. These need to be in the same order they come in.
         * Usually there is a form involved and you control the order. We will control
         * the order with Postman.
         */

        // Amount is a double and needs to be converted.
        double amount = Double.parseDouble(values.get(0));

        // Dates are fun
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String date = values.get(1);
        LocalDate submitted = LocalDate.parse(date, formatter);

        // Description is easy
        String description = values.get(2);

        // Receipts ez
        String receipts = values.get(3);

        // Author - needs to be an user object
        int authorId = Integer.parseInt(values.get(4));
        User author = getUser(authorId);

        // Status - needs to be an Reimb_Status object
        int statusId = Integer.parseInt(values.get(5));
        ReimbStatus status = getStatus(statusId);

        // Type - needs to be a Reimb_Type object
        int typeId = Integer.parseInt(values.get(6));
        ReimbType type = getType(typeId);

    }

    private static User getUser(int userId) {
        User user = new User();

        return user;
    }

    private static ReimbStatus getStatus(int statusId) {
        ReimbStatus status = new ReimbStatus();

        return status;
    }

    private static ReimbType getType(int typeId) {
        ReimbType type = new ReimbType();

        return type;
    }

    public static void processFindResolvedByUserId(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        logger.info("inside of request helper...processfindAllreimbs...");
        BufferedReader reader = request.getReader();
        StringBuilder s = new StringBuilder();

        String line = reader.readLine();
        while (line != null) {
            s.append(line);
            line = reader.readLine();
        }

        List<String> values = new ArrayList<String>();

        String body = s.toString();
        String[] sepByAmp = body.split("&");

        for (String pair : sepByAmp) {
            values.add(pair.substring(pair.indexOf("=") + 1));
        }

        logger.info("Reimbursements requested for user with information: " + body);
        // 1. Set the content type to return text to the browser
        response.setContentType("application/json");

        // 2. Get the user in the Databse by id
        int id = Integer.parseInt(values.get(0));
        User user = userService.getUserById(id);
        List<Reimb> allReimbs = reimbService.getResolvedReimbsByUserId(user);

        // 3. Turn the list of Java objects into a JSON string
        String json = om.writeValueAsString(allReimbs);

        // 4. Use a Print Writer to write the objects to the reponse body
        PrintWriter out = response.getWriter();

        out.println(json);
    }
}