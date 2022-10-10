package com.tbptb_b.k16_dosen.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class jadwal_seminar {

    String profil;
    String jadwal;
    String nama_mhs;
    String nim;
    String judulTA;

    public  jadwal_seminar(){}

    public jadwal_seminar(String profil, String jadwal, String nama_mhs, String nim, String judulTA) {
        this.profil = profil;
        this.jadwal = jadwal;
        this.nama_mhs = nama_mhs;
        this.nim = nim;
        this.judulTA = judulTA;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public String getNama_mhs() {
        return nama_mhs;
    }

    public void setNama_mhs(String nama_mhs) {
        this.nama_mhs = nama_mhs;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getJudulTA() {
        return judulTA;
    }

    public void setJudulTA(String judulTA) {
        this.judulTA = judulTA;
    }
}
