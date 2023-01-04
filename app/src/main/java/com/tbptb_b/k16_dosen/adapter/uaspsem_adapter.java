package com.tbptb_b.k16_dosen.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tbptb_b.k16_dosen.R;
import com.tbptb_b.k16_dosen.models.ThesesItem;

import java.util.ArrayList;
import java.util.List;

public class uaspsem_adapter extends RecyclerView.Adapter<uaspsem_adapter.ViewHolder> {

    private List<ThesesItem> itemList = new ArrayList<>();

    public void setItemList(List<ThesesItem> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_detail_sem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ThesesItem theses = itemList.get(position);
        holder.textjudul.setText((CharSequence) theses.getTitle());
        holder.textabstract.setText((CharSequence) theses.getJsonMemberAbstract());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textjudul, textabstract;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textjudul = itemView.findViewById(R.id.judulTADetailSeemm);
            textabstract = itemView.findViewById(R.id.abstrakDSem);

        }
    }
}