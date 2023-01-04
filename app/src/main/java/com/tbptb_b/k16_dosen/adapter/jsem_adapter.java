package com.tbptb_b.k16_dosen.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tbptb_b.k16_dosen.R;
import com.tbptb_b.k16_dosen.models.jsem_model;

import java.util.ArrayList;

public class jsem_adapter extends RecyclerView.Adapter <jsem_adapter.jsem_viewholder>{

    //1. tambah arraylist
    ArrayList <jsem_model> listjsem = new ArrayList<>();

    //8.
    ItemjsemClickListener listner;

    //1.1 generate constructor arraylist
    public jsem_adapter(ArrayList<jsem_model> listjsem) {
        this.listjsem = listjsem;
    }
    //10. generate constructor listener
    public jsem_adapter(ArrayList<jsem_model> listjsem, ItemjsemClickListener listner) {
        this.listjsem = listjsem;
        this.listner = listner;
    }

    //1.2 generate setter arraylist
    public void setListjsem(ArrayList<jsem_model> listjsem) {
        this.listjsem = listjsem;
    }

    //9.generate setter dari listener
    public void setListner(ItemjsemClickListener listner) {
        this.listner = listner;
    }

    @NonNull
    //3.
    @Override
    public jsem_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //3.1
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_jadwalseminar, parent, false);

        return new jsem_viewholder(view);
    }

    //4.
    @Override
    public void onBindViewHolder(@NonNull jsem_viewholder holder, int position) {

        //6. setelah semua holder selesai -> dilanjutkan ke file JseminarActivity
        jsem_model jsemmodel = listjsem.get(position);
        holder.profil_jsem.setImageResource(R.drawable.avatar);
        holder.jadwal_jsem.setText(jsemmodel.getJadwal_sem());
        holder.Mnama_jsem.setText(jsemmodel.getMnama_sem());
        holder.nim_jsem.setText(jsemmodel.getNim_sem());
        holder.JTA_jsem.setText(jsemmodel.getJudulTA_sem());

    }

    //2.
    @Override
    public int getItemCount() {

        return listjsem.size();
    }

    //7.membuat interface
    public interface ItemjsemClickListener{
        void onItemjsemClick (jsem_model jsemmodel);
    }

    //5.
    //11. tambahkan implements View.OnClickListener agar view holder dapat diklik
    public class jsem_viewholder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        //5.1
        public ImageView profil_jsem;
        public TextView jadwal_jsem, Mnama_jsem,nim_jsem, JTA_jsem;

        public jsem_viewholder(@NonNull View itemView) {
            super(itemView);

            //5.2 binding semua komponen yang ada
            //jika ada yang dalam bentuk maka Integer to String
            profil_jsem = itemView.findViewById(R.id.profil_jsem);
            jadwal_jsem = itemView.findViewById(R.id.jadwal_jsem);
            Mnama_jsem = itemView.findViewById(R.id.Mnama_jsem);
            nim_jsem = itemView.findViewById(R.id.nim_jsem);
            JTA_jsem = itemView.findViewById(R.id.JTA_jsem);

            //12.
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //13. setelah selesai ->pindah ke jseminarActivity
            jsem_model jsemmodel = listjsem.get(getAdapterPosition());
            listner.onItemjsemClick(jsemmodel);
        }
    }
}