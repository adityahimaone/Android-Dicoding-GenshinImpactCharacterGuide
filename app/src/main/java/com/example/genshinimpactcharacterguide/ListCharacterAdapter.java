package com.example.genshinimpactcharacterguide;

import android.media.Image;
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

public class ListCharacterAdapter extends RecyclerView.Adapter<ListCharacterAdapter.ListViewHolder>{
    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    private ArrayList<Character> listCharacter;
    public ListCharacterAdapter(ArrayList<Character> list){
        this.listCharacter = list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_character, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Character character = listCharacter.get(position);
        Glide.with(holder.itemView.getContext())
                .load(character.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);
        holder.tvName.setText(character.getName());
        holder.tvDetail.setText(character.getDetail());
        holder.itemView.setOnClickListener(view -> {
            onItemClickCallback.onItemClicked(listCharacter.get(holder.getAdapterPosition()));
        });
    }

    @Override
    public int getItemCount() {
        return listCharacter.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName= itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(Character data);
    }
}
