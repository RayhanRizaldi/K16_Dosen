package com.tbptb_b.k16_dosen.models;

public class Listlogbook {

    String tanggallb;
    String deskripsilb;

    public Listlogbook(){}

    public Listlogbook(String tanggallb, String deskripsilb) {
        this.tanggallb = tanggallb;
        this.deskripsilb = deskripsilb;
    }

    public String getTanggallb(){return tanggallb;}

    public void setTanggallb(String tanggallb){
        this.deskripsilb = deskripsilb;
    }

    public String getDeskripsilb(){return deskripsilb;}

    public void setDeskripsilb(String deskripsilb) {
        this.deskripsilb = deskripsilb;
    }

}
