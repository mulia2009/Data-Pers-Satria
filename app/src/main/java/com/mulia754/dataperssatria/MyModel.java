package com.mulia754.dataperssatria;

import androidx.annotation.NonNull;

public class MyModel
{
    String nama_pers;

    public MyModel(String nama_pers) {
        this.nama_pers = nama_pers;

    }



    public String getPangkat() {
        return pangkat_pers;
    }

    public void setPangkat_pers(String pangkat_pers) {
        this.pangkat_pers = pangkat_pers;
    }

    String pangkat_pers;

    public String getNama_pers() {
        return nama_pers;
    }

    public void setNama_pers(String nama_pers) {
        this.nama_pers = nama_pers;
    }

    @NonNull
    @Override
    public String toString() {

        return nama_pers;
    }
}
