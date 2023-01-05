package com.tbptb_b.k16_dosen.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tbptb_b.k16_dosen.R;
import com.tbptb_b.k16_dosen.retrofit.detailta.SupervisorsItem;

import java.util.ArrayList;

public class AdapterSupervisors {

    public ArrayList<SupervisorsItem> getDataDosen() {
        return dataDosen;
    }

    public void setDataDosen(ArrayList<SupervisorsItem> dataDosen) {
        this.dataDosen = dataDosen;
    }

    //1. tambah arraylist
    private ArrayList <SupervisorsItem> dataDosen = new ArrayList<>();


}
