package com.revature.services;

import com.revature.models.ReimbStatus;
import com.revature.repositories.ReimbStatusDAOImpl;

import org.apache.log4j.Logger;

public class ReimbStatusServiceImpl implements ReimbStatusService {
  private static Logger logger = Logger.getLogger(ReimbStatusServiceImpl.class);
  private static ReimbStatusDAOImpl reimbStatusDAO = new ReimbStatusDAOImpl();

  public ReimbStatusServiceImpl(ReimbStatusDAOImpl dao) {
    super();
    this.reimbStatusDAO = dao;
  }

  @Override
  public ReimbStatus getReimbStatusById(int id) {
    logger.info("In Service Layer: ReimbStatuServiceImpl.getReimbStatusById()");
    return reimbStatusDAO.findReimbStatusById(id);
  }

}
