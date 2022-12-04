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
                    true,
                    myHero.getAppearance().getGender(),
                    myHero.getAppearance().getRace(),
                    myHero.getAppearance().getHeight().get(0),
                    myHero.getAppearance().getHeight().get(1),
                    myHero.getAppearance().getWeight().get(0),
                    myHero.getAppearance().getWeight().get(1),
                    myHero.getAppearance().getEyeColor(),
                    myHero.getAppearance().getHairColor(),
                    myHero.getBiography().getFullName(),
                    myHero.getBiography().getAlterEgos(),
                    myHero.getBiography().getAliases().get(0),
                    myHero.getBiography().getPlaceOfBirth(),
                    myHero.getBiography().getFirstAppearance(),
                    myHero.getBiography().getPublisher(),
                    myHero.getBiography().getAlignment()
            );
            repo.updateHero(updatedHero);

            holder.binding.listFavouriteIcon.setVisibility(View.GONE);
            holder.binding.listFavouriteIconFilled.setVisibility(View.VISIBLE);
        });

        holder.binding.listFavouriteIconFilled.setOnClickListener(v -> {

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
                    false,
                    myHero.getAppearance().getGender(),
                    myHero.getAppearance().getRace(),
                    myHero.getAppearance().getHeight().get(0),
                    myHero.getAppearance().getHeight().get(1),
                    myHero.getAppearance().getWeight().get(0),
                    myHero.getAppearance().getWeight().get(1),
                    myHero.getAppearance().getEyeColor(),
                    myHero.getAppearance().getHairColor(),
                    myHero.getBiography().getFullName(),
                    myHero.getBiography().getAlterEgos(),
                    myHero.getBiography().getAliases().get(0),
                    myHero.getBiography().getPlaceOfBirth(),
                    myHero.getBiography().getFirstAppearance(),
                    myHero.getBiography().getPublisher(),
                    myHero.getBiography().getAlignment()
            );
            repo.updateHero(updatedHero);

            holder.binding.listFavouriteIcon.setVisibility(View.VISIBLE);
            holder.binding.listFavouriteIconFilled.setVisibility(View.GONE);
        });
    }

    @Override
    public int getItemCount() {
        return HeroDetailList == null ? 0 : HeroDetailList.size();
    }

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

    public interface OnItemClickListener {
        void onItemClick(HeroDetail item);
    }

    public void dbController() {
        db = HeroDatabase.getInstance(this.context.getApplicationContext());
        dao = db.heroDAO();
        repo = new HeroDbRepositoryImp(dao);
        mapper = new Mapper();
    }
}
