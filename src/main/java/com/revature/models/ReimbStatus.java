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
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "reimb_status_id")
  private int reimbStatusId;

  @Column(name = "reimb_status")
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

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ReimbStatus other = (ReimbStatus) obj;
    if (reimbStatus == null) {
      if (other.reimbStatus != null)
        return false;
    } else if (!reimbStatus.equals(other.reimbStatus))
      return false;
    if (reimbStatusId != other.reimbStatusId)
      return false;
    return true;
  }

  

}
