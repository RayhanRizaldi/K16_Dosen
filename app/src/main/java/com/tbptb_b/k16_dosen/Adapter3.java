package com.tbptb_b.k16_dosen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tbptb_b.k16_dosen.models.ListNamaMahasiswa;
import com.tbptb_b.k16_dosen.models.Listlogbook;

import java.text.BreakIterator;
import java.util.ArrayList;

public class Adapter3 extends RecyclerView.Adapter<Adapter3.ListMahasiswa> {


    ArrayList<Listlogbook> listnmmhs = new ArrayList<>();

    public Adapter3(ArrayList<Listlogbook> listnmmhs) {
        this.listnmmhs = listnmmhs;
    }

    public void setListnmmhs(ArrayList<Listlogbook> listnmmhs) {
        this.listnmmhs = listnmmhs;
    }

    @NonNull
    @Override
    public Adapter3.ListMahasiswa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listlogbook, parent, false);
        return new Adapter3.ListMahasiswa(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter3.ListMahasiswa holder, int position) {
        Listlogbook listNamamhs = listnmmhs.get(position);
        holder.textTglListLb.setText(listNamamhs.getTanggallb());
        holder.textDeskripsiListLb.setText(listNamamhs.getDeskripsilb());
    }

    @Override
    public int getItemCount() {
        return listnmmhs.size();
    }
    public class ListMahasiswa extends RecyclerView.ViewHolder{

        public TextView textTglListLb, textDeskripsiListLb;

        public ListMahasiswa(@NonNull View itemView) {
            super(itemView);
            textDeskripsiListLb = itemView.findViewById(R.id.textDeskripsiListLb);
            textTglListLb = itemView.findViewById(R.id.textTglListLb);
        }
    }
}
