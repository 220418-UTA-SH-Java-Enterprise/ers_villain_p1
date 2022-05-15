package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimb;
import com.revature.services.ReimbService;
import com.revature.services.ReimbServiceImpl;

import org.apache.log4j.Logger;

public class ReimbHelper {

    private static ReimbService reimbService = new ReimbServiceImpl();
    private static Logger logger = Logger.getLogger(UserHelper.class);
    private static ObjectMapper om = new ObjectMapper();

    public static void processFindAllReimbs(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        logger.info("inside of request helper...processfindAllreimbs...");
        response.setContentType("application/json");

        List<Reimb> allReimbs = reimbService.getAllReimbs();

        String json = om.writeValueAsString(allReimbs);

        PrintWriter out = response.getWriter();

        out.println(json);
    }
}