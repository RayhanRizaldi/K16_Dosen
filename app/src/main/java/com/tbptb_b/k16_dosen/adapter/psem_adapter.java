package com.tbptb_b.k16_dosen.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tbptb_b.k16_dosen.R;
import com.tbptb_b.k16_dosen.models.psem_model;

import java.util.ArrayList;

public class psem_adapter extends RecyclerView.Adapter <psem_adapter.jsid_viewholder>{
    
    ArrayList <psem_model> listjsid = new ArrayList<>();
    ItemjsidClickListener listener;

    public psem_adapter(ArrayList<psem_model> listjsid) {
        this.listjsid = listjsid;
    }
    public psem_adapter(ArrayList<psem_model> listjsid, ItemjsidClickListener listener) {
        this.listjsid = listjsid;
        this.listener = listener;
    }

    public void setListjsid(ArrayList<psem_model> listjsid) {
        this.listjsid = listjsid;
    }

    public void setListener(ItemjsidClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public jsid_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_setujuseminar, parent, false);
        
        return new psem_adapter.jsid_viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull jsid_viewholder holder, int position) {

        psem_model jsidmodel = listjsid.get(position);

        holder.profil_jsid.setImageResource(R.drawable.avatar);
        holder.jadwal_jsid.setText(jsidmodel.getJadwal_sid());
        holder.Mnama_jsid.setText(jsidmodel.getMnama_sid());
        holder.nim_jsid.setText(jsidmodel.getNim_sid());
//        holder.Bterima_jsid.setText(jsidmodel.getBterima_sid());
//        holder.Btolak_jsid.setText(jsidmodel.getBtolak_sid());
        
    }

    @Override
    public int getItemCount() {
        
        return listjsid.size();
    }

    public interface ItemjsidClickListener{
        void onitemjsidClick (psem_model jsidmodel);
    }

    public class jsid_viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView profil_jsid;
        public TextView jadwal_jsid, Mnama_jsid,nim_jsid;
//        public Button Bterima_jsid, Btolak_jsid;
        
        public jsid_viewholder(@NonNull View itemView) {
            super(itemView);

            profil_jsid = itemView.findViewById(R.id.profil_jsid);
            jadwal_jsid = itemView.findViewById(R.id.jadwal_jsid);
            Mnama_jsid = itemView.findViewById(R.id.Mnama_jsid);
            nim_jsid = itemView.findViewById(R.id.nim_jsid);
//            Bterima_jsid = itemView.findViewById(R.id.Bterima_jsid);
//            Btolak_jsid = itemView.findViewById(R.id.Btolak_jsid);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            psem_model jsidmodel = listjsid.get(getAdapterPosition());
            listener.onitemjsidClick(jsidmodel);
        }
    }
}
