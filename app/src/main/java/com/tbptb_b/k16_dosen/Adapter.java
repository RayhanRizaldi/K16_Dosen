package com.tbptb_b.k16_dosen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tbptb_b.k16_dosen.models.ListNamaMahasiswa;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ListMahasiswa> {


    ArrayList<ListNamaMahasiswa> listnmmhs = new ArrayList<>();

    public Adapter(ArrayList<ListNamaMahasiswa> listnmmhs) {
        this.listnmmhs = listnmmhs;
    }

    public void setListnmmhs(ArrayList<ListNamaMahasiswa> listnmmhs) {
        this.listnmmhs = listnmmhs;
    }

    @NonNull
    @Override
    public Adapter.ListMahasiswa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listmahasiswabimb, parent, false);
        return new Adapter.ListMahasiswa(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ListMahasiswa holder, int position) {
        ListNamaMahasiswa listNamamhs = listnmmhs.get(position);
        holder.textNamaListMabimb.setText(listNamamhs.getNamamhs());
        holder.textNimListMabimb.setText(Integer.toString(listNamamhs.getNimmhs()));
        holder.imageAvatarListmabim.setImageResource(R.drawable.avatar);
    }

    @Override
    public int getItemCount() {
        return listnmmhs.size();
    }
    public class ListMahasiswa extends RecyclerView.ViewHolder{

        public ImageView imageAvatarListmabim;
        public TextView textNamaListMabimb,textNimListMabimb;
        public ImageButton imageButtonListDetailMabim;

        public ListMahasiswa(@NonNull View itemView) {
            super(itemView);
            imageAvatarListmabim = itemView.findViewById(R.id.imageAvatarListmabim);
            textNamaListMabimb = itemView.findViewById(R.id.textNamaListMabimb);
            textNimListMabimb = itemView.findViewById(R.id.textNimListMabimb);
            imageButtonListDetailMabim = itemView.findViewById(R.id.imageButtonListDetailMabim);
        }
    }
}
