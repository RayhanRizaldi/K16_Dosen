package com.tbptb_b.k16_dosen.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tbptb_b.k16_dosen.R;
import com.tbptb_b.k16_dosen.retrofit.listmahasiswa.ThesesItem;

import java.util.ArrayList;


public class AdapterListMahasiswaMenu extends RecyclerView.Adapter<AdapterListMahasiswaMenu.ListMahasiswa> {

    private MhsBimbinganClickListener clickMahasswa;
    private ArrayList<ThesesItem> listnmmhs = new ArrayList<>();
    MhsBimbinganClickListener listener ;
    ThesesItem  mhasiswaResponse;

    public void setListMahasiswa(ArrayList<ThesesItem> listnmmhs) {
        this.listnmmhs = listnmmhs;
        notifyDataSetChanged();
    }

    public AdapterListMahasiswaMenu(MhsBimbinganClickListener listener) {
        this.listener = listener;
    }

    public AdapterListMahasiswaMenu(ArrayList<ThesesItem> listnmmhs) {
        this.listnmmhs = listnmmhs;
    }



    public AdapterListMahasiswaMenu(ArrayList<ThesesItem> listnmmhs, MhsBimbinganClickListener listener) {
        this.listnmmhs = listnmmhs;
        this.listener = listener;
    }


    public void setListener(MhsBimbinganClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ListMahasiswa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listmahasiswabimb, parent, false);
        return new ListMahasiswa(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMahasiswa holder, int position) {
        ThesesItem listNamamhs = listnmmhs.get(position);
        holder.textNamaListMabimb.setText(listNamamhs.getStudent().getName());
        holder.textNimListMabimb.setText(listNamamhs.getStudent().getNim());
//        holder.textIdMaba.setText(listNamamhs.getStudent().getNim());
//        holder.imageAvatarListmabim.setImageResource(R.drawable.avatar);
    }

    @Override
    public int getItemCount() {
        return listnmmhs.size();
    }

    public interface MhsBimbinganClickListener{
        void ClickMhsBimbingan(ThesesItem mhasiswaResponse);
    }

    public class ListMahasiswa extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imageAvatarListmabim;
        public TextView textNamaListMabimb,textNimListMabimb;
        public String textIdMaba;

        public ListMahasiswa(@NonNull View itemView) {
            super(itemView);
            imageAvatarListmabim = itemView.findViewById(R.id.imageAvatarListmabim);
            textNamaListMabimb = itemView.findViewById(R.id.textNamaListMabimb);
            textNimListMabimb = itemView.findViewById(R.id.textNimListMabimb);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            ThesesItem namamhs = listnmmhs.get(getAdapterPosition());
            listener.ClickMhsBimbingan(namamhs);
        }
    }
}
