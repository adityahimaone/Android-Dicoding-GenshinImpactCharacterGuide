package com.example.genshinimpactcharacterguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridCharacterAdapter extends RecyclerView.Adapter<GridCharacterAdapter.GridViewHolder> {
    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    private ArrayList<Character> listCharacter;
    public GridCharacterAdapter(ArrayList<Character> list) {
        this.listCharacter = list;
    }

    @NonNull
    @Override
    public GridCharacterAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_character, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Character character = listCharacter.get(position);
        Glide.with(holder.itemView.getContext())
                .load(listCharacter.get(position).getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);
        holder.tvName.setText(character.getName());
        holder.itemView.setOnClickListener(view -> {
            onItemClickCallback.onItemClicked(listCharacter.get(holder.getAdapterPosition()));
        });
    }

    @Override
    public int getItemCount() {
        return listCharacter.size();
    }


    public class GridViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName= itemView.findViewById(R.id.tv_item_name);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
    public interface OnItemClickCallback{
        void onItemClicked(Character data);
    }
}
