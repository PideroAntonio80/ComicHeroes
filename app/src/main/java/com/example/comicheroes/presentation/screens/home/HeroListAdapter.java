package com.example.comicheroes.presentation.screens.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
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
        HeroListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.hero_list_item, parent, false);

        return new HeroListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroListViewHolder holder, int position) {

        HeroHome heroHome = heroHomeList.get(position);
        holder.bindConnection(heroHome);

        Glide.with(context).load(heroHome.image).into(holder.mBinding.HeroListPhoto);
//        holder.mBinding.heroListName.setText(heroHome.name);
//        holder.mBinding.heroListIntelligence.setText(heroHome.statistics.getIntelligence());
//        holder.mBinding.heroListStrength.setText(heroHome.statistics.getStrength());
//        holder.mBinding.heroListSpeed.setText(heroHome.statistics.getSpeed());
//        holder.mBinding.heroListDurability.setText(heroHome.statistics.getDurability());
//        holder.mBinding.heroListPower.setText(heroHome.statistics.getPower());
//        holder.mBinding.heroListCombat.setText(heroHome.statistics.getCombat());
//
//        if (heroHome.isFavourite) {
//            holder.mBinding.listFavouriteIcon.setVisibility(View.VISIBLE);
//        } else {
//            holder.mBinding.listFavouriteIcon.setVisibility(View.GONE);
//        }
    }

    @Override
    public int getItemCount() {
        return heroHomeList.size();
    }

    public static class HeroListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final HeroListItemBinding mBinding;

        public HeroListViewHolder(HeroListItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            itemView.setOnClickListener(this);
        }

        public void bindConnection (HeroHome heroHome) {
            mBinding.setHero(heroHome);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
