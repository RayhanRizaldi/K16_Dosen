package com.tbptb_b.k16_dosen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptorDataRV extends RecyclerView.Adapter<AdaptorDataRV.HolderData>{
    List<String> listdata;
    LayoutInflater inflater;

    public AdaptorDataRV(Context context, List<String> listdata) {
        this.listdata = listdata;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_rv, parent, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.txtdata.setText(listdata.get(position));
    }

    @Override
    public int getItemCount() {

        return listdata.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView txtdata;
        public HolderData(@NonNull View itemView) {
            super(itemView);

            txtdata= itemView.findViewById(R.id.datatext);
        }
    }
}
