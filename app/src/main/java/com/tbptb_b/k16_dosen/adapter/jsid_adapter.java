package com.tbptb_b.k16_dosen.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tbptb_b.k16_dosen.R;
import com.tbptb_b.k16_dosen.datamodels.SeminarsItem;
import com.tbptb_b.k16_dosen.models.jsid_model;

import java.util.ArrayList;
import java.util.List;

public class jsid_adapter extends RecyclerView.Adapter <jsid_adapter.jsid_viewholder>{

    private List<SeminarsItem> itemThesis = new ArrayList<>();
    ItemjsidClickListener listener;

    public void setItemThesis(List<SeminarsItem> itemThesis) {
        this.itemThesis = itemThesis;
        notifyDataSetChanged();
    }

    public void setListener(ItemjsidClickListener listener) {
        this.listener = listener;
    }

    @NonNull
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

        SeminarsItem jsidmodel = itemThesis.get(position);
        String str1= jsidmodel.getThesis().getStudent().getName();
        String str2 = str1.toLowerCase();
        holder.Mnama_jsid.setText(jsid_adapter.StringFormatter.capitalizeWord(str2));
        holder.nim_jsid.setText(jsidmodel.getThesis().getStudent().getNim());
        holder.jadwal_jsid.setText(jsidmodel.getThesis().getStartAt());

    }

    //2.
    @Override
    public int getItemCount() {

        return itemThesis.size();
    }
    //7.membuat interface
    public interface ItemjsidClickListener{
        void onItemjsidClick(SeminarsItem jsidmodel);
    }

    public class jsid_viewholder extends RecyclerView.ViewHolder implements  View.OnClickListener{

//        //5.1
//        public ImageView profil_jsid;
        public TextView jadwal_jsid, Mnama_jsid,nim_jsid;

        public jsid_viewholder(@NonNull View itemView) {
            super(itemView);

            Mnama_jsid = itemView.findViewById(R.id.Mnama_jsid);
            nim_jsid = itemView.findViewById(R.id.nim_jsid);
            jadwal_jsid = itemView.findViewById(R.id.jadwal_jsid);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            SeminarsItem jsidmodel = itemThesis.get(getAdapterPosition());
            listener.onItemjsidClick(jsidmodel);
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
