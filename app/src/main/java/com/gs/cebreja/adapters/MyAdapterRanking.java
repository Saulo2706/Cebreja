package com.gs.cebreja.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gs.cebreja.R;
import com.gs.cebreja.model.Beer;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterRanking extends RecyclerView.Adapter<MyAdapterRanking.MyViewHolder> implements Filterable {

    private List<Beer> beerList;
    private static OnBeerClickedListner onBeerClickedListner;



    public MyAdapterRanking(OnBeerClickedListner onBeerClickedListner){
        this.onBeerClickedListner = onBeerClickedListner;
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
        if (beerList.get(position).getLiked() == true){
            holder.likeButton.setChecked(true);
        }

    }

    @Override
    public int getItemCount() {
        return beerList.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }


    static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name_Beer;
        private TextView desc_Beer;
        private ToggleButton likeButton;
        private ImageView imagePosterBeer;
        private Beer beer;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);


            name_Beer = itemView.findViewById(R.id.name_Beer);
            desc_Beer = itemView.findViewById(R.id.desc_Beer);
            likeButton = itemView.findViewById(R.id.likeButton);
            imagePosterBeer = itemView.findViewById(R.id.posterBeer);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onBeerClickedListner != null){
                        onBeerClickedListner.onBeerClicked(beer);
                    }
                }
            });
        }

        public void bind(Beer beer){
            this.beer = beer;
            Picasso.get().load("https://image.tmdb.org/t/p/original/" + beer.getCaminhoPoster()).into(imagePosterBeer);
        }

    }

    public void setBeerList(List<Beer> beerList) {
        this.beerList = beerList;
        notifyDataSetChanged();
    }

    public interface OnBeerClickedListner {
        void onBeerClicked(Beer beer);
    }



}
