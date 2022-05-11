package com.revature.services;

import com.revature.models.ReimbStatus;

public interface ReimbStatusService {
  public boolean addNewReimbStatus(ReimbStatus status);
  public boolean updateReimbStatus(ReimbStatus status);
  public boolean deleteReimbStatus(ReimbStatus status);
  public ReimbStatus getReimbStatusById(int id);
}
