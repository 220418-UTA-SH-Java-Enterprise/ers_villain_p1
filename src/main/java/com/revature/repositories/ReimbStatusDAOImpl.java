package com.revature.repositories;

import com.revature.models.ReimbStatus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReimbStatusDAOImpl implements ReimbStatusDAO {
  private static Logger logger = LogManager.getLogger(ReimbStatusDAOImpl.class);
  ReimbStatus reimbStatus = new ReimbStatus();

  @Override
  public ReimbStatus findReimbStatusById(int id) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
