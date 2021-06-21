package com.gs.cebreja.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gs.cebreja.R;
import com.gs.cebreja.activity.FavoriteBeersActivity;
import com.gs.cebreja.model.Favorite;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterFavoriteBeers extends RecyclerView.Adapter<MyAdapterFavoriteBeers.ListFavoriteBeerViewHolder> {

    private List<Favorite> favorites;
    private static MyAdapterFavoriteBeers.ItemFavoriteOrderClickListner itemFavoriteOrderClickListner;

    public MyAdapterFavoriteBeers(MyAdapterFavoriteBeers.ItemFavoriteOrderClickListner itemFavoriteOrderClickListner) {
        this.favorites = new ArrayList<>();
        this.itemFavoriteOrderClickListner = itemFavoriteOrderClickListner;
    }

    @NonNull
    @Override
    public ListFavoriteBeerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_beer_list, parent, false);
        return new MyAdapterFavoriteBeers.ListFavoriteBeerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterFavoriteBeers.ListFavoriteBeerViewHolder holder, int position) {
        holder.bind(favorites.get(position));
    }

    @Override
    public int getItemCount() {
        return (favorites != null && favorites.size() > 0) ? favorites.size() : 0;
    }

    public void setFavorites(List<Favorite> favorites){
        this.favorites = favorites;
        notifyDataSetChanged();
    }

    static class ListFavoriteBeerViewHolder extends RecyclerView.ViewHolder {

        private TextView name_Beer;
        private Favorite favorites;

        public ListFavoriteBeerViewHolder(@NonNull View itemView) {
            super(itemView);
            name_Beer = itemView.findViewById(R.id.nameBeer);
        }

        public void bind(Favorite favorites){
            this.favorites = favorites;
            name_Beer.setText(favorites.getString());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemFavoriteOrderClickListner != null){
                        itemFavoriteOrderClickListner.itemFavoriteOrderClickListner(favorites);
                    }
                }
            });
        }
    }

    public interface ItemFavoriteOrderClickListner {

        void itemFavoriteOrderClickListner(Favorite favorite);

    }
}
