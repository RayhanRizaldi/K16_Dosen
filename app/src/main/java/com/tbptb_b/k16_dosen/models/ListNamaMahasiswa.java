package com.tbptb_b.k16_dosen.models;

public class ListNamaMahasiswa {

    String fotomhs;
    String namamhs;
    int nimmhs;

    public ListNamaMahasiswa(){}

    public ListNamaMahasiswa(String fotomhs, String namamhs, int nimmhs) {
        this.fotomhs = fotomhs;
        this.namamhs = namamhs;
        this.nimmhs = nimmhs;
    }

    public String getFotomhs() {
        return fotomhs;
    }

    public void setFotomhs(String fotomhs) {
        this.fotomhs = fotomhs;
    }

    public String getNamamhs() {
        return namamhs;
    }

    public void setNamamhs(String namamhs) {
        this.namamhs = namamhs;
    }

    public int getNimmhs() {
        return nimmhs;
    }

    public void setNimmhs(int nimmhs) {
        this.nimmhs = nimmhs;
    }
}
