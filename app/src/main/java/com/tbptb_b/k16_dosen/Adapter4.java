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

    ArrayList<ListUlasan> listulsn = new ArrayList<>();

    public Adapter4(ArrayList<ListUlasan> listulsn) {
        this.listulsn = listulsn;
    }

    public void setListulsn(ArrayList<ListUlasan> listulsn) {
        this.listulsn = listulsn;
    }

    @NonNull
    @Override
    public Adapter4.Listulasan onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listulasan, parent, false);
        return new Adapter4.Listulasan(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Listulasan holder, int position) {

        ListUlasan Listulsn= listulsn.get(position);
        holder.textTglListUl.setText(Listulsn.getTglulasan());
        holder.textDeskripsiListUl.setText(Listulsn.getCttulasan());

    }

    @Override
    public int getItemCount() {
        return listulsn.size();
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