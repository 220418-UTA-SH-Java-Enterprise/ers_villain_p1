package com.revature.services;

import com.revature.models.ReimbStatus;
import com.revature.repositories.ReimbStatusDAOImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReimbStatusServiceImpl implements ReimbStatusService {
  private static Logger logger = LogManager.getLogger(ReimbStatusServiceImpl.class);
  private static ReimbStatusDAOImpl reimbStatus = new ReimbStatusDAOImpl();

  @Override
  public boolean addNewReimbStatus(ReimbStatus status) {
    return reimbStatus.insert(status);
  }

  @Override
  public boolean updateReimbStatus(ReimbStatus status) {
    return reimbStatus.update(status);
  }

  @Override
  public boolean deleteReimbStatus(ReimbStatus status) {
    return reimbStatus.delete(status);
  }

  @Override
  public ReimbStatus getReimbStatusById(int id) {
    return reimbStatus.findStatusById(id);
  }

}
