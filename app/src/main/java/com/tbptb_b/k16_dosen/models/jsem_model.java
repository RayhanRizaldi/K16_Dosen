package com.tbptb_b.k16_dosen.models;

public class jsem_model {

    public String[] getNamaJsemmodel;
    //1. buat kemudian generate constructor dan getter setter
    String profil_jsem;
    String jadwal_jsem;
    String Mnama_jsem;
    String nim_jsem;
    String JTA_jsem;

    //2. buat class kosong -> dilanjutkan ke bagian adapter
    public jsem_model() {
    }

    public jsem_model(String profil_jsem, String jadwal_jsem, String mnama_jsem, String nim_jsem, String judulTA_jsem) {
        this.profil_jsem = profil_jsem;
        this.jadwal_jsem = jadwal_jsem;
        Mnama_jsem = mnama_jsem;
        this.nim_jsem = nim_jsem;
        this.JTA_jsem = judulTA_jsem;
    }

    public String getProfil_jsem() { return profil_jsem; }

    public void setProfil_jsem(String profil_jsem) {
        this.profil_jsem = profil_jsem;
    }

    public String getJadwal_jsem() {
        return jadwal_jsem;
    }

    public void setJadwal_jsem(String jadwal_jsem) {
        this.jadwal_jsem = jadwal_jsem;
    }

    public String getMnama_jsem() {
        return Mnama_jsem;
    }

    public void setMnama_jsem(String mnama_jsem) {
        Mnama_jsem = mnama_jsem;
    }

    public String getNim_jsem() {
        return nim_jsem;
    }

    public void setNim_jsem(String nim_jsem) {
        this.nim_jsem = nim_jsem;
    }

    public String getJudulTA_jsem() {
        return JTA_jsem;
    }

    public void setJudulTA_jsem(String judulTA_jsem) {
        this.JTA_jsem = judulTA_jsem;
    }

}
