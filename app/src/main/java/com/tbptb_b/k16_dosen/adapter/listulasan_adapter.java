package com.tbptb_b.k16_dosen.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tbptb_b.k16_dosen.R;
import com.tbptb_b.k16_dosen.models.ListUlasan;

import java.util.ArrayList;

public class listulasan_adapter extends RecyclerView.Adapter<listulasan_adapter.Listulasan>{

    ArrayList<ListUlasan> listulsn = new ArrayList<>();

    public listulasan_adapter(ArrayList<ListUlasan> listulsn) {
        this.listulsn = listulsn;
    }

    public void setListulsn(ArrayList<ListUlasan> listulsn) {
        this.listulsn = listulsn;
    }

    @NonNull
    @Override
    public listulasan_adapter.Listulasan onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listulasan, parent, false);
        return new listulasan_adapter.Listulasan(view);
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