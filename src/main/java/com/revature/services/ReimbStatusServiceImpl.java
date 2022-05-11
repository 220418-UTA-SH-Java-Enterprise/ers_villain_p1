package com.revature.services;

import com.revature.models.ReimbStatus;
import com.revature.repositories.ReimbStatusDAOImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReimbStatusServiceImpl implements ReimbStatusService {
  private static Logger logger = LogManager.getLogger(ReimbStatusServiceImpl.class);
  private static ReimbStatusDAOImpl reimbStatusDAO = new ReimbStatusDAOImpl();

  @Override
  public ReimbStatus getReimbStatusById(int id) {
    return reimbStatusDAO.findReimbStatusById(id);
  }
  
}
