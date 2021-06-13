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
import com.gs.cebreja.model.BeerRanking;
import com.gs.cebreja.model.User;
import com.gs.cebreja.network.ApiService;
import com.gs.cebreja.network.response.LikeUnlikeResponseGeneric;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.gs.cebreja.activity.RankingActivity.listBeerRanking;

public class MyAdapterRanking extends RecyclerView.Adapter<MyAdapterRanking.MyViewHolder> implements Filterable {

    private List<BeerRanking> beerRankingList;
    private static OnBeerClickedListner onBeerClickedListner;



    public MyAdapterRanking(OnBeerClickedListner onBeerClickedListner){
        this.onBeerClickedListner = onBeerClickedListner;
        beerRankingList = new ArrayList<>();
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
        holder.bind(beerRankingList.get(position));
    }

    @Override
    public int getItemCount() {
        return beerRankingList.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }



    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name_Beer;
        private TextView desc_Beer;
        private TextView qtd_Likes;
        private ToggleButton likeButton;
        private ImageView imagePosterBeer;
        private BeerRanking beerRanking;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            name_Beer = itemView.findViewById(R.id.name_Beer);
            desc_Beer = itemView.findViewById(R.id.desc_Beer);
            likeButton = itemView.findViewById(R.id.likeButton);
            qtd_Likes = itemView.findViewById(R.id.qtd_Likes);
            imagePosterBeer = itemView.findViewById(R.id.posterBeer);

            likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (likeButton.isChecked()){
                        ApiService.getInstaceLike().likeCerveja(beerRanking.getId(),"Bearer "+ User.token).enqueue(new Callback<LikeUnlikeResponseGeneric>() {
                            @Override
                            public void onResponse(Call<LikeUnlikeResponseGeneric> call, Response<LikeUnlikeResponseGeneric> response) {
                            }
                            @Override
                            public void onFailure(Call<LikeUnlikeResponseGeneric> call, Throwable t) {
                            }
                        });
                        Long qtdAtual = listBeerRanking.get(getAdapterPosition()).getQtdLikes();
                        listBeerRanking.get(getAdapterPosition()).setLiked(true);
                        listBeerRanking.get(getAdapterPosition()).setQtdLikes(qtdAtual + 1);
                        notifyDataSetChanged();
                    }else{
                        ApiService.getInstaceLike().unlikeCerveja(beerRanking.getId(),"Bearer "+ User.token).enqueue(new Callback<LikeUnlikeResponseGeneric>() {
                            @Override
                            public void onResponse(Call<LikeUnlikeResponseGeneric> call, Response<LikeUnlikeResponseGeneric> response) {
                            }
                            @Override
                            public void onFailure(Call<LikeUnlikeResponseGeneric> call, Throwable t) {
                            }

                        });
                        Long qtdAtual = listBeerRanking.get(getAdapterPosition()).getQtdLikes();
                        listBeerRanking.get(getAdapterPosition()).setLiked(false);
                        listBeerRanking.get(getAdapterPosition()).setQtdLikes(qtdAtual - 1);
                        notifyDataSetChanged();
                    }

                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onBeerClickedListner != null){
                        onBeerClickedListner.onBeerClicked(beerRanking);
                    }
                }
            });
        }

        public void bind(BeerRanking beerRanking){
            this.beerRanking = beerRanking;
            name_Beer.setText(beerRanking.getTitle());
            desc_Beer.setText(beerRanking.getDescription());
            qtd_Likes.setText(beerRanking.getQtdLikes().toString());
            likeButton.setChecked(false);
            imagePosterBeer.setImageResource(R.drawable.cebreja);
            if (beerRanking.getLiked() == true){
                likeButton.setChecked(true);
            }
            if (beerRanking.getCaminhoPoster().size() > 0){
                Picasso.get().load(beerRanking.getCaminhoPoster().get(0)).into(imagePosterBeer);
            }
        }

    }

    public void setBeerList(List<BeerRanking> beerRankingList) {
        this.beerRankingList = beerRankingList;
        notifyDataSetChanged();
    }


    public interface OnBeerClickedListner {
        void onBeerClicked(BeerRanking beerRanking);
    }




}
