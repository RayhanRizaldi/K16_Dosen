package com.tbptb_b.k16_dosen;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tbptb_b.k16_dosen.models.jadwal_seminar;

import java.util.ArrayList;

public class AdapterJSem extends RecyclerView.Adapter<AdapterJSem.JSemViewHolder> {

    ArrayList<jadwal_seminar> listjsem = new ArrayList<>();

    public AdapterJSem(ArrayList<jadwal_seminar> getjadwal_seminar) {
    }

    public void setListjadwal_seminar(ArrayList<jadwal_seminar> listjadwal_seminar) {
        this.listjsem = listjadwal_seminar;
    }

    @NonNull
    @Override
    public JSemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_jadwalseminar,parent, false);
        return new JSemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JSemViewHolder holder, int position) {
        jadwal_seminar jsem = listjsem.get(position);

        holder.prof_jsem .setImageResource(R.drawable.avatar);
        holder.Mnama_jseminar.setText(jsem.getNama_mhs());
        holder.nim_jseminar .setText(jsem. getNim());
        holder.jadwalsem .setText(jsem. getJadwal());
        holder.JTA_jseminar .setText(jsem. getJudulTA());


    }

    @Override
    public int getItemCount() {
        return listjsem.size();
    }

    public class JSemViewHolder extends RecyclerView.ViewHolder {

        public ImageView prof_jsem;
        public TextView jadwalsem, Mnama_jseminar, nim_jseminar, JTA_jseminar;

        public JSemViewHolder(@NonNull View itemView) {
            super(itemView);
            prof_jsem = itemView.findViewById(R.id. prof_jsem);
            jadwalsem = itemView.findViewById(R.id. jadwalsem);
            Mnama_jseminar = itemView.findViewById(R.id. Mnama_jseminar);
            nim_jseminar = itemView.findViewById(R.id. nim_jseminar);
            JTA_jseminar = itemView.findViewById(R.id.JTA_jseminar);

        }
    }
}
