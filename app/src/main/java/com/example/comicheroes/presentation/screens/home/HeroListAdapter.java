package com.example.comicheroes.presentation.screens.home;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.comicheroes.R;
import com.example.comicheroes.data.localdb.database.HeroDatabase;
import com.example.comicheroes.data.localdb.database.dao.HeroDAO;
import com.example.comicheroes.data.localdb.mapper.Mapper;
import com.example.comicheroes.data.localdb.model.HeroDB;
import com.example.comicheroes.data.repository.HeroDbRepository;
import com.example.comicheroes.data.repository.HeroDbRepositoryImp;
import com.example.comicheroes.databinding.HeroListItemBinding;
import com.example.comicheroes.domain.model.HeroHome;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeroListAdapter extends RecyclerView.Adapter<HeroListAdapter.HeroListViewHolder> {

    private Context context;
    private List<HeroHome> heroHomeList;
    private List<HeroHome> originalList;

    final HeroListAdapter.OnItemClickListener listener;

    private HeroDatabase db;
    private HeroDAO dao;
    private HeroDbRepository repo;
    private Mapper mapper = new Mapper();

    public HeroListAdapter(Context context, List<HeroHome> heroHomeList, HeroListAdapter.OnItemClickListener listener) {
        this.context = context;
        this.heroHomeList = heroHomeList;
        this.listener = listener;
        this.originalList = new ArrayList<>();
        originalList.addAll(heroHomeList);
    }

    @NonNull
    @Override
    public HeroListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new HeroListViewHolder(HeroListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HeroListViewHolder holder, int position) {

        HeroHome myHero = heroHomeList.get(position);
        holder.bindData(myHero);

        holder.binding.listFavouriteIcon.setOnClickListener(v -> {

            HeroDB updatedHero = new HeroDB(
                    myHero.getId(),
                    myHero.getImage(),
                    myHero.getName(),
                    myHero.getStatistics().getIntelligence(),
                    myHero.getStatistics().getStrength(),
                    myHero.getStatistics().getSpeed(),
                    myHero.getStatistics().getDurability(),
                    myHero.getStatistics().getPower(),
                    myHero.getStatistics().getCombat(),
                    true
            );
            repo.updateHero(updatedHero);

            holder.binding.listFavouriteIcon.setVisibility(View.GONE);
            holder.binding.listFavouriteIconFilled.setVisibility(View.VISIBLE);
        });

        holder.binding.listFavouriteIconFilled.setOnClickListener(v -> {

            myHero.setFavourite(false);
            repo.updateHero(mapper.fromHeroHomeToHeroDB(myHero));

            holder.binding.listFavouriteIcon.setVisibility(View.VISIBLE);
            holder.binding.listFavouriteIconFilled.setVisibility(View.GONE);
        });
    }

    @Override
    public int getItemCount() {
        return heroHomeList == null ? 0 : heroHomeList.size();
    }

    public void filter(String strSearch) {
        if (strSearch.length() == 0) {
            heroHomeList.clear();
            heroHomeList.addAll(originalList);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                heroHomeList.clear();
                List<HeroHome> collect = originalList.stream()
                        .filter(i -> i.getName().toLowerCase().contains(strSearch.toLowerCase()))
                        .collect(Collectors.toList());

                heroHomeList.addAll(collect);
            }
            else {
                heroHomeList.clear();
                for (HeroHome i : originalList) {
                    if (i.getName().toLowerCase().contains(strSearch.toLowerCase())) {
                        heroHomeList.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    public class HeroListViewHolder extends RecyclerView.ViewHolder {

        private HeroListItemBinding binding;

        public HeroListViewHolder(HeroListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(HeroHome heroHome) {
            Glide.with(context).load(heroHome.getImage()).into(binding.HeroListPhoto);

            binding.heroListName.setText(heroHome.getName());
            binding.heroListIntelligence.setText(context.getString(R.string.hero_list_intelligence, heroHome.getStatistics().getIntelligence()));
            binding.heroListStrength.setText(context.getString(R.string.hero_list_strength, heroHome.getStatistics().getStrength()));
            binding.heroListSpeed.setText(context.getString(R.string.hero_list_speed, heroHome.getStatistics().getSpeed()));
            binding.heroListDurability.setText(context.getString(R.string.hero_list_durability, heroHome.getStatistics().getDurability()));
            binding.heroListPower.setText(context.getString(R.string.hero_list_power, heroHome.getStatistics().getPower()));
            binding.heroListCombat.setText(context.getString(R.string.hero_list_combat, heroHome.getStatistics().getCombat()));

            if (heroHome.getFavourite()) {
                binding.listFavouriteIcon.setVisibility(View.GONE);
                binding.listFavouriteIconFilled.setVisibility(View.VISIBLE);
            } else {
                binding.listFavouriteIcon.setVisibility(View.VISIBLE);
                binding.listFavouriteIconFilled.setVisibility(View.GONE);
            }

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(heroHome);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(HeroHome item);
    }

    public void dbController() {
        db = HeroDatabase.getInstance(this.context.getApplicationContext());
        dao = db.heroDAO();
        repo = new HeroDbRepositoryImp(dao);
    }
}
