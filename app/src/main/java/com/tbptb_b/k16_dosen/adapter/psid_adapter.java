package com.tbptb_b.k16_dosen.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tbptb_b.k16_dosen.R;
import com.tbptb_b.k16_dosen.datamodels.SeminarsItem;
import com.tbptb_b.k16_dosen.models.psid_model;

import java.util.ArrayList;
import java.util.List;

public class psid_adapter extends RecyclerView.Adapter <psid_adapter.psid_viewholder>{

    private List<SeminarsItem> itemSetuju = new ArrayList<>();
    jsid_adapter.ItemjsidClickListener listener;

    public void setitemSetuju(List<SeminarsItem> itemSetuju) {
        this.itemSetuju = itemSetuju;
        notifyDataSetChanged();
    }

    public void setListener(jsid_adapter.ItemjsidClickListener listener) {
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

        SeminarsItem psidmodel = itemSetuju.get(position);
        String str1= psidmodel.getThesis().getStudent().getName();
        String str2 = str1.toLowerCase();
        holder.Mnama_psid.setText(jsid_adapter.StringFormatter.capitalizeWord(str2));
        holder.nim_psid.setText(psidmodel.getThesis().getStudent().getNim());
        holder.JTA_psid.setText(psidmodel.getThesis().getTitle());

    }

    @Override
    public int getItemCount() {

        return itemSetuju.size();
    }

    public interface ItempsidClickListener{
        void onitempsidClick (SeminarsItem psidmodel);
    }

    public class psid_viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView profil_psid;
        public TextView jadwal_psid, JTA_psid, Mnama_psid,nim_psid;

        public psid_viewholder(@NonNull View itemView) {
            super(itemView);

            profil_psid = itemView.findViewById(R.id.profil_psid);
            jadwal_psid = itemView.findViewById(R.id.jadwal_psid);
            Mnama_psid = itemView.findViewById(R.id.Mnama_psid);
            nim_psid = itemView.findViewById(R.id.nim_psid);
            JTA_psid = itemView.findViewById(R.id.JTA_psid);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            SeminarsItem psidmodel = itemSetuju.get(getAdapterPosition());
            listener.onItemjsidClick(psidmodel);
        }
    }

    public static class StringFormatter {
        public static String capitalizeWord(String str){
            String words[]=str.split("\\s");
            String capitalizeWord="";
            for(String w:words){
                String first=w.substring(0,1);
                String afterfirst=w.substring(1);
                capitalizeWord+=first.toUpperCase()+afterfirst+" ";
            }
            return capitalizeWord.trim();
        }
    }
}
