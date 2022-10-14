package com.tbptb_b.k16_dosen.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tbptb_b.k16_dosen.R;
import com.tbptb_b.k16_dosen.models.psid_model;

import java.util.ArrayList;

public class psid_adapter extends RecyclerView.Adapter <psid_adapter.psid_viewholder>{

    ArrayList<psid_model> listpsid = new ArrayList<>();
    psid_adapter.ItempsidClickListener listener;

    public psid_adapter(ArrayList<psid_model> listpsid) {
        this.listpsid = listpsid;
    }
    public psid_adapter(ArrayList<psid_model> listpsid, psid_adapter.ItempsidClickListener listener) {
        this.listpsid = listpsid;
        this.listener = listener;
    }

    public void setListpsid(ArrayList<psid_model> listjsid) {
        this.listpsid = listpsid;
    }

    public void setListener(psid_adapter.ItempsidClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public psid_adapter.psid_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_psid, parent, false);

        return new psid_adapter.psid_viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull psid_adapter.psid_viewholder holder, int position) {

        psid_model psidmodel = listpsid.get(position);

        holder.profil_psid.setImageResource(R.drawable.avatar);
        holder.jadwal_psid.setText(psidmodel.getJadwal_psid());
        holder.Mnama_psid.setText(psidmodel.getMnama_psid());
        holder.nim_psid.setText(psidmodel.getNim_psid());
//        holder.Bterima_jsid.setText(jsidmodel.getBterima_sid());
//        holder.Btolak_jsid.setText(jsidmodel.getBtolak_sid());

    }

    @Override
    public int getItemCount() {

        return listpsid.size();
    }

    public interface ItempsidClickListener{
        void onitempsidClick (psid_model psidmodel);
    }

    public class psid_viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView profil_psid;
        public TextView jadwal_psid, Mnama_psid,nim_psid;
//        public Button Bterima_jsid, Btolak_jsid;

        public psid_viewholder(@NonNull View itemView) {
            super(itemView);

            profil_psid = itemView.findViewById(R.id.profil_psid);
            jadwal_psid = itemView.findViewById(R.id.jadwal_psid);
            Mnama_psid = itemView.findViewById(R.id.Mnama_psid);
            nim_psid = itemView.findViewById(R.id.nim_psid);
//            Bterima_jsid = itemView.findViewById(R.id.Bterima_jsid);
//            Btolak_jsid = itemView.findViewById(R.id.Btolak_jsid);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            psid_model psidmodel = listpsid.get(getAdapterPosition());
            listener.onitempsidClick(psidmodel);
        }
    }
}
