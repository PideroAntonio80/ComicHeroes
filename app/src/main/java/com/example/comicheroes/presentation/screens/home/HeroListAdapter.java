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
import com.example.comicheroes.domain.model.HeroDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeroListAdapter extends RecyclerView.Adapter<HeroListAdapter.HeroListViewHolder> {

    private Context context;
    private List<HeroDetail> HeroDetailList;
    private List<HeroDetail> originalList;

    final HeroListAdapter.OnItemClickListener listener;

    private HeroDatabase db;
    private HeroDAO dao;
    private HeroDbRepository repo;
    private Mapper mapper;

    public HeroListAdapter(Context context, List<HeroDetail> HeroDetailList, HeroListAdapter.OnItemClickListener listener) {
        this.context = context;
        this.HeroDetailList = HeroDetailList;
        this.listener = listener;
        this.originalList = new ArrayList<>();
        originalList.addAll(HeroDetailList);

        dbController();
    }

    @NonNull
    @Override
    public HeroListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new HeroListViewHolder(HeroListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HeroListViewHolder holder, int position) {

        HeroDetail myHero = HeroDetailList.get(position);
        holder.bindData(myHero);

        holder.binding.listFavouriteIcon.setOnClickListener(v -> {

            HeroDB updatedHero = mapper.fromHeroDetailToHeroDB(myHero);
            updatedHero.setFavourite(true);
            repo.updateHero(updatedHero);

            holder.binding.listFavouriteIcon.setVisibility(View.GONE);
            holder.binding.listFavouriteIconFilled.setVisibility(View.VISIBLE);
        });

        holder.binding.listFavouriteIconFilled.setOnClickListener(v -> {

            HeroDB updatedHero = mapper.fromHeroDetailToHeroDB(myHero);
            updatedHero.setFavourite(false);
            repo.updateHero(updatedHero);

            holder.binding.listFavouriteIcon.setVisibility(View.VISIBLE);
            holder.binding.listFavouriteIconFilled.setVisibility(View.GONE);
        });
    }

    @Override
    public int getItemCount() {
        return HeroDetailList == null ? 0 : HeroDetailList.size();
    }

    // Dynamic filtered search by name
    public void filter(String strSearch) {
        if (strSearch.length() == 0) {
            HeroDetailList.clear();
            HeroDetailList.addAll(originalList);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                HeroDetailList.clear();
                List<HeroDetail> collect = originalList.stream()
                        .filter(i -> i.getName().toLowerCase().contains(strSearch.toLowerCase()))
                        .collect(Collectors.toList());

                HeroDetailList.addAll(collect);
            }
            else {
                HeroDetailList.clear();
                for (HeroDetail i : originalList) {
                    if (i.getName().toLowerCase().contains(strSearch.toLowerCase())) {
                        HeroDetailList.add(i);
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

        // Painting data in each cell of the list
        public void bindData(HeroDetail heroDetail) {
            Glide.with(context).load(heroDetail.getImage()).into(binding.HeroListPhoto);

            binding.heroListName.setText(heroDetail.getName());
            binding.heroListIntelligence.setText(context.getString(R.string.hero_list_intelligence, heroDetail.getStatistics().getIntelligence()));
            binding.heroListStrength.setText(context.getString(R.string.hero_list_strength, heroDetail.getStatistics().getStrength()));
            binding.heroListSpeed.setText(context.getString(R.string.hero_list_speed, heroDetail.getStatistics().getSpeed()));
            binding.heroListDurability.setText(context.getString(R.string.hero_list_durability, heroDetail.getStatistics().getDurability()));
            binding.heroListPower.setText(context.getString(R.string.hero_list_power, heroDetail.getStatistics().getPower()));
            binding.heroListCombat.setText(context.getString(R.string.hero_list_combat, heroDetail.getStatistics().getCombat()));

            if (heroDetail.getFavourite()) {
                binding.listFavouriteIcon.setVisibility(View.GONE);
                binding.listFavouriteIconFilled.setVisibility(View.VISIBLE);
            } else {
                binding.listFavouriteIcon.setVisibility(View.VISIBLE);
                binding.listFavouriteIconFilled.setVisibility(View.GONE);
            }

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(heroDetail);
                }
            });
        }
    }

    // Interface we use to listen to the hero user press to see its details
    public interface OnItemClickListener {
        void onItemClick(HeroDetail item);
    }

    // Init database
    public void dbController() {
        db = HeroDatabase.getInstance(this.context.getApplicationContext());
        dao = db.heroDAO();
        repo = new HeroDbRepositoryImp(dao);
        mapper = new Mapper();
    }
}
