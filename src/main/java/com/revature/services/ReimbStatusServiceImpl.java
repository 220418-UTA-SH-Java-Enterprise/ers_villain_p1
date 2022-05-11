package com.revature.services;

public class ReimbStatusServiceImpl implements ReimbStatusService {
  private static Logger logger = LogManager.getLogger(ReimbStatusImpl.class);
  private static ReimbStatusImpl reimbStatus = new ReimbStatusServiceImpl();

  @Override
  public boolean addNewReimbStatus(ReimbStatus status) {
    return reimbStatus.insert(status);
  }

  @Override
  public boolean updateStatus(ReimbStatus status) {
    return reimbStatus.update(status);
  }

  @Override
  public boolean deleteStatus(ReimbStatus status) {
    return reimbStatus.delele(status);
  }

  @Override
  public ReimbStatus getStatusById(int id) {
    return findStatusById(int id);
  }
  
}
