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

import java.text.BreakIterator;
import java.util.ArrayList;

public class Adapter3 extends RecyclerView.Adapter<Adapter3.ListLogbook> {


    ArrayList<Listlogbook> listlb = new ArrayList<>();
    ListLogbookClickListener listener;

    public Adapter3(ArrayList<Listlogbook> listlb) {
        this.listlb = listlb;
    }

    public Adapter3(ArrayList<Listlogbook> listlb, ListLogbookClickListener listener) {
        this.listlb = listlb;
        this.listener = listener;
    }

    public void setListlb(ArrayList<Listlogbook> listlb) {
        this.listlb = listlb;
    }

    public void setListener(ListLogbookClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public Adapter3.ListLogbook onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listlogbook, parent, false);
        return new Adapter3.ListLogbook(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListLogbook holder, int position) {
        Listlogbook Listlb= listlb.get(position);
        holder.textTglListLb.setText(Listlb.getTanggallb());
        holder.textDeskripsiListLb.setText(Listlb.getDeskripsilb());
        if(Listlb.getStatuslb() == 1){
            holder.imageViewCheklb.setImageResource(R.drawable.bx_checksquare);
        } else {
            holder.imageViewCheklb.setImageResource(R.drawable.bx_nonesquare);
        }
    }

    public interface ListLogbookClickListener{
        void onListLogbookClick(Listlogbook listlogbook);
    }

    @Override
    public int getItemCount() {
        return listlb.size();
    }
    public class ListLogbook extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView textTglListLb, textDeskripsiListLb;
        public ImageView imageViewCheklb;

        public ListLogbook(@NonNull View itemView) {
            super(itemView);
            textDeskripsiListLb = itemView.findViewById(R.id.textDeskripsiListLb);
            textTglListLb = itemView.findViewById(R.id.textTglListLb);
            imageViewCheklb = itemView.findViewById(R.id.imageViewCheklb);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Listlogbook listlogbook = listlb.get(getAdapterPosition());
            listener.onListLogbookClick(listlogbook);
        }
    }


}
