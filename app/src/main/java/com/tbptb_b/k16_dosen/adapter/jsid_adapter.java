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
import com.tbptb_b.k16_dosen.models.jsid_model;

import java.util.ArrayList;

public class jsid_adapter extends RecyclerView.Adapter <jsid_adapter.jsid_viewholder>{

    //1. tambah arraylist
    ArrayList <jsid_model> listjsid = new ArrayList<>();

    //8.
    ItemjsidClickListener listner;

    //1.1 generate constructor arraylist
    public jsid_adapter(ArrayList<jsid_model> listjsid) {
        this.listjsid = listjsid;
    }
    //10. generate constructor listener
    public jsid_adapter(ArrayList<jsid_model> listjsid, ItemjsidClickListener listner) {
        this.listjsid = listjsid;
        this.listner = listner;
    }

    //1.2 generate setter arraylist
    public void setListjsid(ArrayList<jsid_model> listjsid) {
        this.listjsid = listjsid;
    }

    //9.generate setter dari listener
    public void setListner(ItemjsidClickListener listner) {
        this.listner = listner;
    }

    @NonNull
    //3.
    @Override
    public jsid_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //3.1
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_jadwalsidang, parent, false);

        return new jsid_viewholder(view);
    }

    //4.
    @Override
    public void onBindViewHolder(@NonNull jsid_viewholder holder, int position) {

        //6. setelah semua holder selesai -> dilanjutkan ke file JsidangActivity
        jsid_model jsidmodel = listjsid.get(position);
        holder.profil_jsid.setImageResource(R.drawable.avatar);
        holder.jadwal_jsid.setText(jsidmodel.getJadwal_jsid());
        holder.Mnama_jsid.setText(jsidmodel.getMnama_jsid());
        holder.nim_jsid.setText(jsidmodel.getNim_jsid());
        holder.JTA_jsid.setText(jsidmodel.getJTA_jsid());

    }

    //2.
    @Override
    public int getItemCount() {

        return listjsid.size();
    }

    //7.membuat interface
    public interface ItemjsidClickListener{
        void onItemjsidClick (jsid_model jsidmodel);
    }

    //5.
    //11. tambahkan implements View.OnClickListener agar view holder dapat diklik
    public class jsid_viewholder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        //5.1
        public ImageView profil_jsid;
        public TextView jadwal_jsid, Mnama_jsid,nim_jsid, JTA_jsid;

        public jsid_viewholder(@NonNull View itemView) {
            super(itemView);

            //5.2 binding semua komponen yang ada
            //jika ada yang dalam bentuk maka Integer to String
            profil_jsid = itemView.findViewById(R.id.profil_jsid);
            jadwal_jsid = itemView.findViewById(R.id.jadwal_jsid);
            Mnama_jsid = itemView.findViewById(R.id.Mnama_jsid);
            nim_jsid = itemView.findViewById(R.id.nim_jsid);
            JTA_jsid = itemView.findViewById(R.id.JTA_jsid);

            //12.
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //13. setelah selesai ->pindah ke jsidangActivity
            jsid_model jsidmodel = listjsid.get(getAdapterPosition());
            listner.onItemjsidClick(jsidmodel);
        }
    }
}
