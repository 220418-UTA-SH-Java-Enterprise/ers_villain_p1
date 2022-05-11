package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.revature.models.Reimb;

import org.junit.jupiter.api.Test;

public class ReimbServiceTest {
    Reimb reimb = new Reimb();
    ReimbServiceImpl reimbService = new ReimbServiceImpl();

    // Positive test case
    @Test
    public void testReimb() {
        assertTrue(reimbService.addNewReimbRequest(reimb));
    }
}
