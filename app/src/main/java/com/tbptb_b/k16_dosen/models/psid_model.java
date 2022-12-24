package com.tbptb_b.k16_dosen.models;

public class psid_model {

    String profil_psid;
    String jadwal_psid;
    String Mnama_psid;
    String nim_psid;

    public psid_model(){}

    public psid_model(String profil_psid, String jadwal_psid, String mnama_psid, String nim_psid) {
        this.profil_psid = profil_psid;
        this.jadwal_psid = jadwal_psid;
        this.Mnama_psid = mnama_psid;
        this.nim_psid = nim_psid;
    }

    public String getProfil_psid() {
        return profil_psid;
    }

    public void setProfil_psid(String profil_psid) {
        this.profil_psid = profil_psid;
    }

    public String getJadwal_psid() {
        return jadwal_psid;
    }

    public void setJadwal_psid(String jadwal_psid) {
        this.jadwal_psid = jadwal_psid;
    }

    public String getMnama_psid() {
        return Mnama_psid;
    }

    public void setMnama_psid(String mnama_psid) {
        Mnama_psid = mnama_psid;
    }

    public String getNim_psid() {
        return nim_psid;
    }

    public void setNim_psid(String nim_psid) {
        this.nim_psid = nim_psid;
    }

}
