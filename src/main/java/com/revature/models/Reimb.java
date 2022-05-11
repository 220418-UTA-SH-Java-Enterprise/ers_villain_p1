package com.revature.models;

import java.time.LocalDate;

public class Reimb {
    private int reimbId;
    private double amount;
    private LocalDate submitted;
    private LocalDate resolved;
    private String description;
    private String receipt;
    private int authorId;
    private int resolverId;
    private int statusId;
    private int typeId;

    public Reimb() {
    }

    public Reimb(double amount, LocalDate submitted, LocalDate resolved, String description, String receipt,
            int authorId, int resolverId, int statusId, int typeId) {
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.receipt = receipt;
        this.authorId = authorId;
        this.resolverId = resolverId;
        this.statusId = statusId;
        this.typeId = typeId;
    }

    public Reimb(int reimbId, double amount, LocalDate submitted, LocalDate resolved, String description,
            String receipt,
            int authorId, int resolverId, int statusId, int typeId) {
        this.reimbId = reimbId;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.receipt = receipt;
        this.authorId = authorId;
        this.resolverId = resolverId;
        this.statusId = statusId;
        this.typeId = typeId;
    }

    public int getReimbId() {
        return reimbId;
    }

    public void setReimbId(int reimbId) {
        this.reimbId = reimbId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getSubmitted() {
        return submitted;
    }

    public void setSubmitted(LocalDate submitted) {
        this.submitted = submitted;
    }

    public LocalDate getResolved() {
        return resolved;
    }

    public void setResolved(LocalDate resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getResolverId() {
        return resolverId;
    }

    public void setResolverId(int resolverId) {
        this.resolverId = resolverId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Reimb [amount=" + amount + ", authorId=" + authorId + ", description=" + description + ", receipt="
                + receipt + ", resolved=" + resolved + ", resolverId=" + resolverId + ", statusId=" + statusId
                + ", submitted=" + submitted + ", typeId=" + typeId + ", reimbId=" + reimbId + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + authorId;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((receipt == null) ? 0 : receipt.hashCode());
        result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
        result = prime * result + resolverId;
        result = prime * result + statusId;
        result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
        result = prime * result + typeId;
        result = prime * result + reimbId;
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
        Reimb other = (Reimb) obj;
        if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
            return false;
        if (authorId != other.authorId)
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (receipt == null) {
            if (other.receipt != null)
                return false;
        } else if (!receipt.equals(other.receipt))
            return false;
        if (resolved == null) {
            if (other.resolved != null)
                return false;
        } else if (!resolved.equals(other.resolved))
            return false;
        if (resolverId != other.resolverId)
            return false;
        if (statusId != other.statusId)
            return false;
        if (submitted == null) {
            if (other.submitted != null)
                return false;
        } else if (!submitted.equals(other.submitted))
            return false;
        if (typeId != other.typeId)
            return false;
        if (reimbId != other.reimbId)
            return false;
        return true;
    }

}
