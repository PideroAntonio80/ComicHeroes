package com.example.comicheroes.presentation.screens.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comicheroes.databinding.HomeFragmentBinding;
import com.example.comicheroes.domain.model.HeroHome;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeFragmentBinding binding;

    private HomeViewModel viewModel;

    private HeroListAdapter adapter;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = HomeFragmentBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);

        observeViewModel();
    }

    private void initComponents(List<HeroHome> list) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        binding.HeroRecyclerList.setLayoutManager(layoutManager);

        binding.HeroRecyclerList.setHasFixedSize(true);

        adapter = new HeroListAdapter(this.getContext(), list);
        binding.HeroRecyclerList.setAdapter(adapter);
    }

    private void observeViewModel() {
        viewModel.getHeroesListResponseLiveData().observe(getViewLifecycleOwner(), heroHomes -> {

            if (heroHomes != null && !heroHomes.isEmpty()) {
                initComponents(heroHomes);
            }
        });
    }
}
