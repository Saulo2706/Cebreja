package com.gs.cebreja.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gs.cebreja.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<DetailsBeer> beerList;

    public MyAdapter(List<DetailsBeer> beerList) {
        this.beerList = beerList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.beer_list,
                parent,
                false
        );
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.name_Beer.setText(beerList.get(position).getTitle());
        holder.desc_Beer.setText(beerList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return beerList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name_Beer;
        TextView desc_Beer;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            name_Beer = itemView.findViewById(R.id.name_Beer);
            desc_Beer = itemView.findViewById(R.id.desc_Beer);
        }
    }

}
