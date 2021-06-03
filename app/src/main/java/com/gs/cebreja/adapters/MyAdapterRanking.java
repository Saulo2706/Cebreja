package com.gs.cebreja.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gs.cebreja.R;
import com.gs.cebreja.model.Beer;

import java.util.List;

public class MyAdapterRanking extends RecyclerView.Adapter<MyAdapterRanking.MyViewHolder> implements Filterable {

    private List<Beer> beerList;
    private RecyclerViewClickListner listner;

    public MyAdapterRanking(List<Beer> beerList, RecyclerViewClickListner listner) {
        this.beerList = beerList;
        this.listner = listner;
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_Beer.setText(beerList.get(position).getTitle());
        holder.desc_Beer.setText(beerList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return beerList.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public interface RecyclerViewClickListner{
        void onClick(View v, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name_Beer;
        TextView desc_Beer;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            name_Beer = itemView.findViewById(R.id.name_Beer);
            desc_Beer = itemView.findViewById(R.id.desc_Beer);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View itemView) {
            listner.onClick(itemView, getAdapterPosition());
        }
    }



}
