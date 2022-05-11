package com.revature.services;

public interface ReimbStatusService {
  public boolean addNewStatus(ReimbStatus status);
  public boolean updateStatus(ReimbStatus status);
  public boolean deleteStatus(ReimbStatus status);
  public ReimbStatus getStatusById(int id);
}
