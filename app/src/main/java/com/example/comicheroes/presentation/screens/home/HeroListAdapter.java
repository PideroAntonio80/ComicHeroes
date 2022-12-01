package com.example.comicheroes.presentation.screens.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.comicheroes.R;
import com.example.comicheroes.databinding.HeroListItemBinding;
import com.example.comicheroes.domain.model.HeroHome;

import java.util.List;

public class HeroListAdapter extends RecyclerView.Adapter<HeroListAdapter.HeroListViewHolder> {

    private Context context;
    private List<HeroHome> heroHomeList;

    public HeroListAdapter(Context context, List<HeroHome> heroHomeList) {
        this.context = context;
        this.heroHomeList = heroHomeList;
    }

    @NonNull
    @Override
    public HeroListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new HeroListViewHolder(HeroListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HeroListViewHolder holder, int position) {

        HeroHome heroHome = heroHomeList.get(position);

        Glide.with(context).load(heroHome.image).into(holder.binding.HeroListPhoto);

        holder.binding.heroListName.setText(heroHome.getName());
        holder.binding.heroListIntelligence.setText(context.getString(R.string.hero_list_intelligence, heroHome.statistics.getIntelligence()));
        holder.binding.heroListStrength.setText(context.getString(R.string.hero_list_strength, heroHome.statistics.getStrength()));
        holder.binding.heroListSpeed.setText(context.getString(R.string.hero_list_speed, heroHome.statistics.getSpeed()));
        holder.binding.heroListDurability.setText(context.getString(R.string.hero_list_durability, heroHome.statistics.getDurability()));
        holder.binding.heroListPower.setText(context.getString(R.string.hero_list_power, heroHome.statistics.getPower()));
        holder.binding.heroListCombat.setText(context.getString(R.string.hero_list_combat, heroHome.statistics.getCombat()));

        if (heroHome.isFavourite) {
            holder.binding.listFavouriteIcon.setVisibility(View.GONE);
            holder.binding.listFavouriteIconFilled.setVisibility(View.VISIBLE);
        } else {
            holder.binding.listFavouriteIcon.setVisibility(View.VISIBLE);
            holder.binding.listFavouriteIconFilled.setVisibility(View.GONE);
        }

        holder.binding.listFavouriteIcon.setOnClickListener(v -> {

                holder.binding.listFavouriteIcon.setVisibility(View.GONE);
                holder.binding.listFavouriteIconFilled.setVisibility(View.VISIBLE);
        });

        holder.binding.listFavouriteIconFilled.setOnClickListener(v -> {

                holder.binding.listFavouriteIcon.setVisibility(View.VISIBLE);
                holder.binding.listFavouriteIconFilled.setVisibility(View.GONE);
        });
    }

    @Override
    public int getItemCount() {
        return heroHomeList == null ? 0 : heroHomeList.size();
    }

    public static class HeroListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private HeroListItemBinding binding;

        public HeroListViewHolder(HeroListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
