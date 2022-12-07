package com.tbptb_b.k16_dosen.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tbptb_b.k16_dosen.R;
import com.tbptb_b.k16_dosen.models.ListNamaMahasiswa;

import java.util.ArrayList;

public class mhsbimbingan_adapter extends RecyclerView.Adapter<mhsbimbingan_adapter.ListMahasiswa> {


    ArrayList<ListNamaMahasiswa> listnmmhs = new ArrayList<>();
    MhsBimbinganClickListener listener ;

    public mhsbimbingan_adapter(ArrayList<ListNamaMahasiswa> listnmmhs) {
        this.listnmmhs = listnmmhs;
    }



    public mhsbimbingan_adapter(ArrayList<ListNamaMahasiswa> listnmmhs, MhsBimbinganClickListener listener) {
        this.listnmmhs = listnmmhs;
        this.listener = listener;
    }

    public void setListnmmhs(ArrayList<ListNamaMahasiswa> listnmmhs) {
        this.listnmmhs = listnmmhs;
    }
    public void setListener(MhsBimbinganClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public mhsbimbingan_adapter.ListMahasiswa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listmahasiswabimb, parent, false);
        return new mhsbimbingan_adapter.ListMahasiswa(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mhsbimbingan_adapter.ListMahasiswa holder, int position) {
        ListNamaMahasiswa listNamamhs = listnmmhs.get(position);
        holder.textNamaListMabimb.setText(listNamamhs.getNamamhs());
        holder.textNimListMabimb.setText(Integer.toString(listNamamhs.getNimmhs()));
        holder.imageAvatarListmabim.setImageResource(R.drawable.avatar);
    }

    @Override
    public int getItemCount() {
        return listnmmhs.size();
    }

    public interface MhsBimbinganClickListener{
        void ClickMhsBimbingan(ListNamaMahasiswa mhsbb);
    }

    public class ListMahasiswa extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imageAvatarListmabim;
        public TextView textNamaListMabimb,textNimListMabimb;

        public ListMahasiswa(@NonNull View itemView) {
            super(itemView);
            imageAvatarListmabim = itemView.findViewById(R.id.imageAvatarListmabim);
            textNamaListMabimb = itemView.findViewById(R.id.textNamaListMabimb);
            textNimListMabimb = itemView.findViewById(R.id.textNimListMabimb);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            ListNamaMahasiswa namamhs = listnmmhs.get(getAdapterPosition());
            listener.ClickMhsBimbingan(namamhs);
        }
    }
}
