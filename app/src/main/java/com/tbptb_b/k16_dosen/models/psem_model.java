package com.tbptb_b.k16_dosen.models;

public class psem_model {

    String profil_sem;
    String jadwal_sem;
    String Mnama_sem;
    String nim_sem;

    public psem_model(){}

    public psem_model(String profil_sem, String jadwal_sem, String mnama_sem, String nim_sem) {
        this.profil_sem = profil_sem;
        this.jadwal_sem = jadwal_sem;
        Mnama_sem = mnama_sem;
        this.nim_sem = nim_sem;
    }

    public String getProfil_sem() {
        return profil_sem;
    }

    public void setProfil_sem(String profil_sem) {
        this.profil_sem = profil_sem;
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
}
