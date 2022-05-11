package com.revature.models;

public class ReimbStatus {
  private int reimbStatusId;
  private String reimbStatus;

  public ReimbStatus() {
  }

  public ReimbStatus(String reimbStatus) {
    this.reimbStatus = reimbStatus;
  }

  public ReimbStatus(int reimbStatusId, String reimbStatus) {
    this.reimbStatusId = reimbStatusId;
    this.reimbStatus = reimbStatus;
  }

  public int getReimbStatusId() {
    return reimbStatusId;
  }

  public void setReimbStatusId(int reimbStatusId) {
    this.reimbStatusId = reimbStatusId;
  }

  public String getReimbStatus() {
    return reimbStatus;
  }

  public void setReimbStatus(String reimbStatus) {
    this.reimbStatus = reimbStatus;
  }

  @Override
  public String toString() {
    return "ReimbStatus [reimbStatus=" + reimbStatus + ", reimbStatusId=" + reimbStatusId + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((reimbStatus == null) ? 0 : reimbStatus.hashCode());
    result = prime * result + reimbStatusId;
    return result;
  }
}
