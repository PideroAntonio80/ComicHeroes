package com.example.comicheroes.presentation.screens.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.comicheroes.R;
import com.example.comicheroes.databinding.DetailFragmentBinding;
import com.example.comicheroes.domain.model.HeroDetail;
import com.example.comicheroes.presentation.MainActivity;

public class DetailFragment extends Fragment {

    private DetailFragmentBinding binding;

    private DetailViewModel viewModel;

    private String id;
    private static final String EXTRA_ID = "param1";

    private boolean isFavourite = false;

    public static DetailFragment newInstance(String idHero) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_ID, idHero);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getString(EXTRA_ID);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DetailFragmentBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((MainActivity) requireActivity()).detailFragmentTitleWriter();

        viewModel = new ViewModelProvider(requireActivity()).get(DetailViewModel.class);

        observeViewModel();
    }

    private void initComponents(HeroDetail heroDetail) {

        Glide.with(this.requireContext()).load(heroDetail.getImage()).into(binding.heroDetailPhoto);

        binding.heroDetailName.setText(heroDetail.getName());

        binding.heroDetailIntelligence.setText(getString(R.string.hero_list_intelligence, heroDetail.getStatistics().getIntelligence()));
        binding.heroDetailStrength.setText(getString(R.string.hero_list_strength, heroDetail.getStatistics().getStrength()));
        binding.heroDetailSpeed.setText(getString(R.string.hero_list_speed, heroDetail.getStatistics().getSpeed()));
        binding.heroDetailDurability.setText(getString(R.string.hero_list_durability, heroDetail.getStatistics().getDurability()));
        binding.heroDetailPower.setText(getString(R.string.hero_list_power, heroDetail.getStatistics().getPower()));
        binding.heroDetailCombat.setText(getString(R.string.hero_list_combat, heroDetail.getStatistics().getCombat()));

        binding.heroDetailGender.setText(getString(R.string.hero_detail_gender, heroDetail.getAppearance().getGender()));
        binding.heroDetailRace.setText(getString(R.string.hero_detail_race, heroDetail.getAppearance().getRace()));
        binding.heroDetailHeight.setText(getString(R.string.hero_detail_height, heroDetail.getAppearance().getHeight().get(0)));
        binding.heroDetailWeight.setText(getString(R.string.hero_detail_weight, heroDetail.getAppearance().getWeight().get(0)));
        binding.heroDetailEyeColor.setText(getString(R.string.hero_detail_eyes_color, heroDetail.getAppearance().getEyeColor()));
        binding.heroDetailHairColor.setText(getString(R.string.hero_detail_hair_color, heroDetail.getAppearance().getHairColor()));

        binding.heroDetailFullName.setText(getString(R.string.hero_detail_full_name, heroDetail.getBiography().getFullName()));
        binding.heroDetailAlterEgos.setText(getString(R.string.hero_detail_alter_egos, heroDetail.getBiography().getAlterEgos()));
        binding.heroDetailAliases.setText(getString(R.string.hero_detail_alias, heroDetail.getBiography().getAliases().get(0)));
        binding.heroDetailBirthPlace.setText(getString(R.string.hero_detail_birth_place, heroDetail.getBiography().getPlaceOfBirth()));
        binding.heroDetailFirstAppearance.setText(getString(R.string.hero_detail_first_appearance, heroDetail.getBiography().getFirstAppearance()));
        binding.heroDetailPublisher.setText(getString(R.string.hero_detail_publisher, heroDetail.getBiography().getPublisher()));
        binding.heroDetailAlignment.setText(getString(R.string.hero_detail_alignment, heroDetail.getBiography().getAlignment()));

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isFavourite = !isFavourite;

                if (isFavourite) {
                    binding.detailFavouriteIconFilled.setVisibility(View.VISIBLE);
                } else {
                    binding.detailFavouriteIconFilled.setVisibility(View.GONE);
                }
            }
        });
    }

    private void observeViewModel() {
        viewModel.getHeroDetailResponseLiveData(id).observe(getViewLifecycleOwner(), heroDetail -> {

            if (heroDetail != null) {
                initComponents(heroDetail);
            }
        });
    }
}
