package com.tbptb_b.k16_dosen.models;

public class jsid_model {

    //1. buat kemudian generate constructor dan getter setter
    String profil_jsid;
    String jadwal_jsid;
    String Mnama_jsid;
    String nim_jsid;
    String JTA_jsid;

    //2. buat class kosong -> dilanjutkan ke bagian adapter
    public jsid_model(){}

    public jsid_model(String profil_jsid, String jadwal_jsid, String mnama_jsid, String nim_jsid, String JTA_jsid) {
        this.profil_jsid = profil_jsid;
        this.jadwal_jsid = jadwal_jsid;
        Mnama_jsid = mnama_jsid;
        this.nim_jsid = nim_jsid;
        this.JTA_jsid = JTA_jsid;
    }

    public String getProfil_jsid() {
        return profil_jsid;
    }

    public void setProfil_jsid(String profil_jsid) {
        this.profil_jsid = profil_jsid;
    }

    public String getJadwal_jsid() {
        return jadwal_jsid;
    }

    public void setJadwal_jsid(String jadwal_jsid) {
        this.jadwal_jsid = jadwal_jsid;
    }

    public String getMnama_jsid() {
        return Mnama_jsid;
    }

    public void setMnama_jsid(String mnama_jsid) {
        Mnama_jsid = mnama_jsid;
    }

    public String getNim_jsid() {
        return nim_jsid;
    }

    public void setNim_jsid(String nim_jsid) {
        this.nim_jsid = nim_jsid;
    }

    public String getJTA_jsid() {
        return JTA_jsid;
    }

    public void setJTA_jsid(String JTA_jsid) {
        this.JTA_jsid = JTA_jsid;
    }
}
