package com.gs.cebreja.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gs.cebreja.R;
import com.gs.cebreja.model.Beer;
import com.gs.cebreja.network.response.BeersResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyAdapterRanking extends RecyclerView.Adapter<MyAdapterRanking.MyViewHolder> implements Filterable {

    private List<Beer> beerList;
    private ImageView imagePosterBeer;
    private RecyclerViewClickListner listner;

    public MyAdapterRanking(){
        beerList = new ArrayList<>();
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
        holder.bind(beerList.get(position));
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
            imagePosterBeer = itemView.findViewById(R.id.posterBeer);


            itemView.setOnClickListener(this);
        }

        public void bind(Beer beer){
            name_Beer.setText(beer.getTitle());
            Picasso.get().load("https://image.tmdb.org/t/p/original/" + beer.getCaminhoPoster()).into(imagePosterBeer);
        }

        @Override
        public void onClick(View itemView) {
            listner.onClick(itemView, getAdapterPosition());
        }
    }

    public void setBeerList(List<Beer> beerList) {
        this.beerList = beerList;
        notifyDataSetChanged();
    }



}
