package com.gs.cebreja.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gs.cebreja.R;
import com.gs.cebreja.model.OrderSolicitations;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterSolicitations extends RecyclerView.Adapter<MyAdapterSolicitations.ListSolicitationsViewHolder>{

    private List<OrderSolicitations> solicitations;
    private static ItemBeerOrderClickListner itemBeerOrderClickListner;


    public MyAdapterSolicitations(ItemBeerOrderClickListner itemBeerOrderClickListner) {
        solicitations = new ArrayList<>();
        this.itemBeerOrderClickListner = itemBeerOrderClickListner;

    }


    @NonNull
    @Override
    public MyAdapterSolicitations.ListSolicitationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_list_solicitation, parent, false);
        return new MyAdapterSolicitations.ListSolicitationsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterSolicitations.ListSolicitationsViewHolder holder, int position) {
        holder.bind(solicitations.get(position));
    }

    @Override
    public int getItemCount() {
        return (solicitations != null && solicitations.size() > 0) ? solicitations.size() : 0;
    }

    public void setSolicitations(List<OrderSolicitations> solicitations){
        this.solicitations = solicitations;
        notifyDataSetChanged();
    }

    static class ListSolicitationsViewHolder extends RecyclerView.ViewHolder{

        private TextView name_Beer,statusOrder,typeOrder;
        private ImageView imagePosterBeer;
        private OrderSolicitations solicitations;

        public ListSolicitationsViewHolder(@NonNull View itemView) {
            super(itemView);
            name_Beer = itemView.findViewById(R.id.name_Beer);
            imagePosterBeer = itemView.findViewById(R.id.posterBeer);
            statusOrder = itemView.findViewById(R.id.statusOrder);
            typeOrder = itemView.findViewById(R.id.typeOrder);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemBeerOrderClickListner != null){
                        itemBeerOrderClickListner.onItemBeerOrderClicado(solicitations);
                    }
                }
            });

        }

        public void bind(OrderSolicitations solicitations){
            this.solicitations = solicitations;
            name_Beer.setText(solicitations.getName());
            statusOrder.setText(solicitations.getOrderStatus().getName());
            typeOrder.setText(solicitations.getOrderType().getName() +" - "+solicitations.getWhenChanged());

            if (solicitations.getPhotos().size() > 0){
                Picasso.get().load(solicitations.getPhotos().get(0)).into(imagePosterBeer);
            }
        }



    }
    public interface  ItemBeerOrderClickListner{

        void onItemBeerOrderClicado(OrderSolicitations order);

    }

}
