package com.tbptb_b.k16_dosen.models;

public class ListUlasan {
    String tglulasan;
    String cttulasan;

    public ListUlasan(){}

    public ListUlasan(String tglulasan, String cttulasan) {
        this.tglulasan = tglulasan;
        this.cttulasan = cttulasan;
    }

    public String getTglulasan() {
        return tglulasan;
    }

    public void setTglulasan(String tglulasan) {
        this.tglulasan = tglulasan;
    }

    public String getCttulasan() {
        return cttulasan;
    }

    public void setCttulasan(String cttulasan) {
        this.cttulasan = cttulasan;
    }
}
