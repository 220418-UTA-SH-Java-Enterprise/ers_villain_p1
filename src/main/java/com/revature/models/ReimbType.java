package com.revature.models;

public class ReimbType {
    private int typeId;
    private String type;

    public ReimbType() {
    }

    public ReimbType(String type) {
        this.type = type;
    }

    public ReimbType(int typeId, String type) {
        this.typeId = typeId;
        this.type = type;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getrType() {
        return type;
    }

    public void setrType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ReimbType [type=" + type + ", typeId=" + typeId + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (typeId != other.typeId)
            return false;
        return true;
    }

}
