package com.example.hp15series.myapps;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;


public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ListViewHolder>{
    private ArrayList<wisata> listWisata;
    private Context context;

    public RecycleViewAdapter(ArrayList<wisata> list){
        this.listWisata = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemlist, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        wisata Wisata = listWisata.get(position);
        Glide.with(holder.itemView.getContext())
                .load(Wisata.getFoto())
                .apply(new RequestOptions())
                .into(holder.imgPhoto);
        holder.tvTitle.setText(Wisata.getJudul());
        holder.tvCity.setText(Wisata.getKota());
        holder.tvDescription.setText(Wisata.getDeskripsi());
        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(),listWisata.get(holder.getAdapterPosition()).getJudul(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Judul", listWisata.get(holder.getAdapterPosition()).getJudul());
                intent.putExtra("Deskripsi", listWisata.get(holder.getAdapterPosition()).getDeskripsi());
                intent.putExtra("Kota", listWisata.get(holder.getAdapterPosition()).getKota());
                intent.putExtra("link",listWisata.get(holder.getAdapterPosition()).getFoto());
                intent.putExtra("Maps",listWisata.get(holder.getAdapterPosition()).getMaps());
                context.startActivity(intent);
            }
        });
        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(),listWisata.get(holder.getAdapterPosition()).getJudul(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Judul", listWisata.get(holder.getAdapterPosition()).getJudul());
                intent.putExtra("Deskripsi", listWisata.get(holder.getAdapterPosition()).getDeskripsi());
                intent.putExtra("Kota", listWisata.get(holder.getAdapterPosition()).getKota());
                intent.putExtra("link",listWisata.get(holder.getAdapterPosition()).getFoto());
                intent.putExtra("Maps",listWisata.get(holder.getAdapterPosition()).getMaps());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listWisata.size();
    }




    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle, tvCity,tvDescription;


        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            imgPhoto = itemView.findViewById(R.id.pic);
            tvTitle = itemView.findViewById(R.id.judul);
            tvCity = itemView.findViewById(R.id.kota);
            tvDescription = itemView.findViewById(R.id.deskripsi);
        }
    }

}
