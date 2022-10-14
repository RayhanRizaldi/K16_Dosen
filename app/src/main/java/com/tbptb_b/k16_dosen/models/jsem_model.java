package com.tbptb_b.k16_dosen.models;

public class jsem_model {

    public String[] getNamaJsemmodel;
    //1. buat kemudian generate constructor dan getter setter
    String profil_sem;
    String jadwal_sem;
    String Mnama_sem;
    String nim_sem;
    String JTA_sem;

    //2. buat class kosong -> dilanjutkan ke bagian adapter
    public jsem_model(){}

    public jsem_model(String profil, String jadwal_sem, String mnama_sem, String nim_sem, String judulTA_sem) {
        this.profil_sem = profil;
        this.jadwal_sem = jadwal_sem;
        Mnama_sem = mnama_sem;
        this.nim_sem = nim_sem;
        this.JTA_sem = judulTA_sem;
    }

    public String getProfil() {
        return profil_sem;
    }

    public void setProfil(String profil) {
        this.profil_sem = profil;
    }

    public String getJadwal_sem() {
        return jadwal_sem;
    }

    public void setJadwal_sem(String jadwal_sem) {
        this.jadwal_sem = jadwal_sem;
    }

    public String getMnama_sem() {
        return Mnama_sem;
    }

    public void setMnama_sem(String mnama_sem) {
        Mnama_sem = mnama_sem;
    }

    public String getNim_sem() {
        return nim_sem;
    }

    public void setNim_sem(String nim_sem) {
        this.nim_sem = nim_sem;
    }

    public String getJudulTA_sem() {
        return JTA_sem;
    }

    public void setJudulTA_sem(String judulTA_sem) {
        this.JTA_sem = judulTA_sem;
    }

}
