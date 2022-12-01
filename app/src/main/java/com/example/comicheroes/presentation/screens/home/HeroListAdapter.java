package com.example.comicheroes.presentation.screens.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comicheroes.R;
import com.example.comicheroes.databinding.HeroListItemBinding;
import com.example.comicheroes.domain.model.HeroHome;

import java.util.List;

public class HeroListAdapter extends RecyclerView.Adapter<HeroListAdapter.HeroListViewHolder> {

    List<HeroHome> heroHomeList;

    @NonNull
    @Override
    public HeroListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HeroListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.hero_list_item, parent, false);

        return new HeroListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroListViewHolder holder, int position) {
        holder.bindConnection(heroHomeList.get(position));
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
