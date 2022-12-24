package com.tbptb_b.k16_dosen.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tbptb_b.k16_dosen.R;
import com.tbptb_b.k16_dosen.SeminarPersetujuanActivity;
import com.tbptb_b.k16_dosen.models.psem_model;

import java.util.ArrayList;

public class psem_adapter extends RecyclerView.Adapter <psem_adapter.psem_viewholder>{
    
    ArrayList <psem_model> listsem  = new ArrayList<>();
    itempsemClickListener listener;

    public psem_adapter(ArrayList<psem_model> listsem ) {
        this.listsem  = listsem ;
    }

    public psem_adapter(ArrayList<psem_model> listsem , itempsemClickListener listener) {
        this.listsem = listsem ;
        this.listener = listener;
    }

    public void setlistsem (ArrayList<psem_model> listsem ) {
        this.listsem  = listsem ;
    }

    @NonNull
    @Override
    public psem_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_setujuseminar, parent, false);
        
        return new psem_adapter.psem_viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull psem_viewholder holder, int position) {

        psem_model psemmodel = listsem.get(position);

        holder.profil_sem.setImageResource(R.drawable.avatar);
        holder.jadwal_sem.setText(psemmodel.getJadwal_sem());
        holder.Mnama_sem.setText(psemmodel.getMnama_sem());
        holder.nim_sem.setText(psemmodel.getNim_sem());
        
    }

    @Override
    public int getItemCount() {
        
        return listsem .size();
    }

    public void setListener(SeminarPersetujuanActivity seminarPersetujuanActivity) {
    }
    public interface itempsemClickListener {
        void onitempsemClick (psem_model psemmodel);
    }

    public class psem_viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView profil_sem;
        public TextView jadwal_sem, Mnama_sem,nim_sem;
        
        public psem_viewholder(@NonNull View itemView) {
            super(itemView);

            profil_sem = itemView.findViewById(R.id.profil_sem);
            jadwal_sem = itemView.findViewById(R.id.jadwal_sem);
            Mnama_sem = itemView.findViewById(R.id.Mnama_sem);
            nim_sem = itemView.findViewById(R.id.nim_sem);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            psem_model psemmodel = listsem.get(getAdapterPosition());
            listener.onitempsemClick(psemmodel);
        }
    }
}
