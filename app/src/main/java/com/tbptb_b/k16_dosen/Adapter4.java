package com.tbptb_b.k16_dosen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tbptb_b.k16_dosen.models.ListUlasan;
import com.tbptb_b.k16_dosen.models.Listlogbook;

import java.util.ArrayList;

public class Adapter4 extends RecyclerView.Adapter<Adapter4.Listulasan>{

    ArrayList<ListUlasan> listulasan = new ArrayList<>();

    public Adapter4(ArrayList<ListUlasan> listulsn) {
        this.listulasan = listulasan;
    }

    public void setListnmmhs(ArrayList<ListUlasan> listulsn) {
        this.listulasan = listulasan;
    }

    @NonNull
    @Override
    public Adapter4.Listulasan onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listulasan, parent, false);
        return new Adapter4.Listulasan(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter4.Listulasan holder, int position) {

        ListUlasan listul= listulasan.get(position);
        holder.textTglListUl.setText(listul.getTglulasan());
        holder.textDeskripsiListUl.setText(listul.getCttulasan());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Listulasan extends RecyclerView.ViewHolder {
        public TextView textTglListUl, textDeskripsiListUl;
        public Listulasan(@NonNull View itemView) {
            super(itemView);

            textDeskripsiListUl = itemView.findViewById(R.id.textCatatanUlasan);
            textTglListUl = itemView.findViewById(R.id.textTglListUlasan);
        }
    }
}