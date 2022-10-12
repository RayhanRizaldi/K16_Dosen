package com.tbptb_b.k16_dosen.models;

public class jsid_model {

    String profil_sid;
    String jadwal_sid;
    String Mnama_sid;
    String nim_sid;
//    int Bterima_sid;
//    int Btolak_sid;

    public jsid_model(){}

    public jsid_model(String profil_sid, String jadwal_sid, String mnama_sid, String nim_sid) {
        this.profil_sid = profil_sid;
        this.jadwal_sid = jadwal_sid;
        Mnama_sid = mnama_sid;
        this.nim_sid = nim_sid;
    }

    public String getProfil_sid() {
        return profil_sid;
    }

    public void setProfil_sid(String profil_sid) {
        this.profil_sid = profil_sid;
    }

    public String getJadwal_sid() {
        return jadwal_sid;
    }

    public void setJadwal_sid(String jadwal_sid) {
        this.jadwal_sid = jadwal_sid;
    }

    public String getMnama_sid() {
        return Mnama_sid;
    }

    public void setMnama_sid(String mnama_sid) {
        Mnama_sid = mnama_sid;
    }

    public String getNim_sid() {
        return nim_sid;
    }

    public void setNim_sid(String nim_sid) {
        this.nim_sid = nim_sid;
    }

    //    public int getBterima_sid() {
//        return Bterima_sid;
//    }
//
//    public void setBterima_sid(int bterima_sid) {
//        Bterima_sid = bterima_sid;
//    }
//
//    public int getBtolak_sid() {
//        return Btolak_sid;
//    }
//
//    public void setBtolak_sid(int btolak_sid) {
//        Btolak_sid = btolak_sid;
//    }
}
