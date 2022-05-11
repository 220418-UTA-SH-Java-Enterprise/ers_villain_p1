package com.revature.services;

import com.revature.models.ReimbStatus;

public interface ReimbStatusService {
  boolean addNewReimbStatus(ReimbStatus status);

  boolean updateReimbStatus(ReimbStatus status);

  boolean deleteReimbStatus(ReimbStatus status);

  ReimbStatus getReimbStatusById(int id);
}
