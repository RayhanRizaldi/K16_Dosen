package com.tbptb_b.k16_dosen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tbptb_b.k16_dosen.models.ListNamaMahasiswa;
import com.tbptb_b.k16_dosen.models.Listlogbook;
import com.tbptb_b.k16_dosen.models.LogbooksItem;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class Adapter3 extends RecyclerView.Adapter<Adapter3.ViewHolder> {

    private List<LogbooksItem> itemList = new ArrayList<>();

    public void setItemList(List<LogbooksItem> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listlogbook, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LogbooksItem logbook = itemList.get(position);
        holder.textTglListLb.setText(logbook.getDate());
        holder.textDeskripsiListLb.setText(logbook.getProgress());
        if(logbook.getStatus() == 1){
            holder.imageViewCheklb.setImageResource(R.drawable.bx_checksquare);
        } else {
            holder.imageViewCheklb.setImageResource(R.drawable.bx_nonesquare);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textTglListLb, textDeskripsiListLb;
        public ImageView imageViewCheklb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textDeskripsiListLb = itemView.findViewById(R.id.textDeskripsiListLb);
            textTglListLb = itemView.findViewById(R.id.textTglListLb);
            imageViewCheklb = itemView.findViewById(R.id.imageViewCheklb);

        }
    }


//    private ArrayList<Listlogbook> logbooks = new ArrayList<>();
//    ListLogbookClickListener listener;
//
//    public Adapter3(ArrayList<Listlogbook> logbooks) {
//        this.logbooks = logbooks;
//    }
////
//    public Adapter3(ArrayList<Listlogbook> logbooks, ListLogbookClickListener listener) {
//        this.logbooks = logbooks;
//        this.listener = listener;
//    }
//
//    public void setlogbooks(ArrayList<Listlogbook> logbooks) {
//        this.logbooks = logbooks;
//        notifyDataSetChanged();
//    }
//
//    public void setListener(ListLogbookClickListener listener){
//        this.listener = listener;
//    }
//
//    @NonNull
//    @Override
//    public Adapter3.ListLogbook onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.listlogbook, parent, false);
//        return new Adapter3.ListLogbook(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ListLogbook holder, int position) {
//        LogbooksItem logbooksItem= logbooks.get(position);
//        holder.textTglListLb.setText(logbooksItem.getDate());
//        holder.textDeskripsiListLb.setText(logbooksItem.getProgress());
//        if(logbooksItem.getStatus() == 1){
//            holder.imageViewCheklb.setImageResource(R.drawable.bx_checksquare);
//        } else {
//            holder.imageViewCheklb.setImageResource(R.drawable.bx_nonesquare);
//        }
//    }
//
//    public interface ListLogbookClickListener{
//        void onListLogbookClick(Listlogbook listlogbook);
//    }
//
//    @Override
//    public int getItemCount() {
//        return logbooks.size();
//    }
//    public class ListLogbook extends RecyclerView.ViewHolder implements View.OnClickListener{
//
//        public TextView textTglListLb, textDeskripsiListLb;
//        public ImageView imageViewCheklb;
//
//        public ListLogbook(@NonNull View itemView) {
//            super(itemView);
//            textDeskripsiListLb = itemView.findViewById(R.id.textDeskripsiListLb);
//            textTglListLb = itemView.findViewById(R.id.textTglListLb);
//            imageViewCheklb = itemView.findViewById(R.id.imageViewCheklb);
//
//            itemView.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View view) {
//            Listlogbook listlogbook = logbooks.get(getAdapterPosition());
//            listener.onListLogbookClick(listlogbook);
//        }
//    }


}
