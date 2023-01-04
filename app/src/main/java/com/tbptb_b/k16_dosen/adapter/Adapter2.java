package com.tbptb_b.k16_dosen.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tbptb_b.k16_dosen.R;
import com.tbptb_b.k16_dosen.models.ListNamaMahasiswa;

import java.util.ArrayList;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.ListMahasiswa> {


    ArrayList<ListNamaMahasiswa> listnmmhs = new ArrayList<>();

    public Adapter2(ArrayList<ListNamaMahasiswa> listnmmhs) {
        this.listnmmhs = listnmmhs;
    }

    public void setListnmmhs(ArrayList<ListNamaMahasiswa> listnmmhs) {
        this.listnmmhs = listnmmhs;
    }

    @NonNull
    @Override
    public Adapter2.ListMahasiswa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listperstjuanmhsbbm, parent, false);
        return new Adapter2.ListMahasiswa(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter2.ListMahasiswa holder, int position) {
        ListNamaMahasiswa listNamamhs = listnmmhs.get(position);
        holder.textNamaSetujuBbm.setText(listNamamhs.getNamamhs());
        holder.textNimSetujuBbm.setText(Integer.toString(listNamamhs.getNimmhs()));
        holder.imageAvatarSetujuBbm.setImageResource(R.drawable.avatar);
    }

    @Override
    public int getItemCount() {
        return listnmmhs.size();
    }
    public class ListMahasiswa extends RecyclerView.ViewHolder{

        public ImageView imageAvatarSetujuBbm;
        public TextView textNamaSetujuBbm,textNimSetujuBbm;
        public Button ButtonpersetujuanBbm;

        public ListMahasiswa(@NonNull View itemView) {
            super(itemView);
            imageAvatarSetujuBbm = itemView.findViewById(R.id.imageAvatarSetujuBbm);
            textNamaSetujuBbm = itemView.findViewById(R.id.textNamaSetujuBbm);
            textNimSetujuBbm = itemView.findViewById(R.id.textNimSetujuBbm);
            ButtonpersetujuanBbm = itemView.findViewById(R.id.ButtonpersetujuanBbm);
        }
    }
}
