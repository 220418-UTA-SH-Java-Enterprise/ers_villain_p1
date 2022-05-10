package com.revature.models;

public class ReimbType {
    private int typeId;
    private String rType;

    public ReimbType() {
    }

    public ReimbType(String rType) {
        this.rType = rType;
    }

    public ReimbType(int typeId, String rType) {
        this.typeId = typeId;
        this.rType = rType;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getrType() {
        return rType;
    }

    public void setrType(String rType) {
        this.rType = rType;
    }

    @Override
    public String toString() {
        return "ReimbType [rType=" + rType + ", typeId=" + typeId + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rType == null) ? 0 : rType.hashCode());
        result = prime * result + typeId;
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
        ReimbType other = (ReimbType) obj;
        if (rType == null) {
            if (other.rType != null)
                return false;
        } else if (!rType.equals(other.rType))
            return false;
        if (typeId != other.typeId)
            return false;
        return true;
    }

}
