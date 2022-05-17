package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ers_reimbursement_status")
public class ReimbStatus {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "status_id")
  private int reimbStatusId;

  @Column(name = "reimb_status")
  private String reimbStatusStatus;

  public ReimbStatus() {
  }

  public ReimbStatus(String reimbStatusStatus) {
    this.reimbStatusStatus = reimbStatusStatus;
  }

  public ReimbStatus(int reimbStatusId, String reimbStatusStatus) {
    this.reimbStatusId = reimbStatusId;
    this.reimbStatusStatus = reimbStatusStatus;
  }

  public int getReimbStatusId() {
    return reimbStatusId;
  }

  public void setReimbStatusId(int reimbStatusId) {
    this.reimbStatusId = reimbStatusId;
  }

  public String getReimbStatusStatus() {
    return reimbStatusStatus;
  }

  public void setReimbStatus(String reimbStatus) {
    this.reimbStatusStatus = reimbStatusStatus;
  }

  @Override
  public String toString() {
    return "ReimbStatus [reimbStatus=" + reimbStatusStatus + ", reimbStatusId=" + reimbStatusId + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((reimbStatusStatus == null) ? 0 : reimbStatusStatus.hashCode());
    result = prime * result + reimbStatusId;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ReimbStatus other = (ReimbStatus) obj;
    if (reimbStatusStatus == null) {
      if (other.reimbStatusStatus != null)
        return false;
    } else if (!reimbStatusStatus.equals(other.reimbStatusStatus))
      return false;
    if (reimbStatusId != other.reimbStatusId)
      return false;
    return true;
  }

}
