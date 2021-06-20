package com.gs.cebreja.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gs.cebreja.R;
import com.gs.cebreja.model.UserApreciation;

import java.util.List;

public class MyAdapterAvaliationsBeer extends RecyclerView.Adapter<MyAdapterAvaliationsBeer.ListAppreciationsViewHolder> {

    List<UserApreciation> appreciations;

    public MyAdapterAvaliationsBeer() {
        appreciations = appreciations;
    }

    @NonNull
    @Override
    public ListAppreciationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_avaliation_list, parent, false);
        return new ListAppreciationsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterAvaliationsBeer.ListAppreciationsViewHolder holder, int position) {
        holder.nameAvaliator.setText(appreciations.get(position).getUser());
        holder.scoreBeer.setText(appreciations.get(position).getScore());
        holder.descAval.setText(appreciations.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        return (appreciations != null && appreciations.size() > 0) ? appreciations.size() : 0;
    }

    static class ListAppreciationsViewHolder extends RecyclerView.ViewHolder{

        private TextView nameAvaliator,scoreBeer,descAval;

        public ListAppreciationsViewHolder(@NonNull View itemView) {
            super(itemView);
            nameAvaliator = itemView.findViewById(R.id.nameAvaliator);
            scoreBeer = itemView.findViewById(R.id.scoreBeer);
            descAval = itemView.findViewById(R.id.descAval);
        }
    }

    public void setAppreciations(List<UserApreciation> appreciations){
        this.appreciations = appreciations;
        notifyDataSetChanged();
    }

}
