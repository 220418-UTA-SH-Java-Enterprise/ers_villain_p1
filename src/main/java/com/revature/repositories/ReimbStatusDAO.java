package com.revature.repositories;

import com.revature.models.ReimbStatus;

public interface ReimbStatusDAO {
  public boolean insert(ReimbStatus reimbStatus);
  public boolean update(ReimbStatus reimbStatus);
  public boolean delete(ReimbStatus reimbStatus);
  public ReimbStatus findStatusById(int id);
}
