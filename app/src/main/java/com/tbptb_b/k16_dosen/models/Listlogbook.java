package com.tbptb_b.k16_dosen.models;

public class Listlogbook {

    String tanggallb;
    String deskripsilb;
    Integer statuslb;


    public Listlogbook(){}

    public Listlogbook(String tanggallb, String deskripsilb, Integer statuslb) {
        this.tanggallb = tanggallb;
        this.deskripsilb = deskripsilb;
        this.statuslb = statuslb;
    }

    public String getTanggallb(){return tanggallb;}

    public void setTanggallb(String tanggallb){
        this.deskripsilb = deskripsilb;
    }

    public String getDeskripsilb(){return deskripsilb;}

    public void setDeskripsilb(String deskripsilb) {
        this.deskripsilb = deskripsilb;
    }

    public Integer getStatuslb(){return statuslb;}

    public void setStatuslb(Integer statuslb) {
        this.statuslb = statuslb;
    }
}
