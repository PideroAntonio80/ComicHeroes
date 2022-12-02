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

import com.example.comicheroes.R;
import com.example.comicheroes.databinding.HomeFragmentBinding;
import com.example.comicheroes.domain.model.HeroHome;
import com.example.comicheroes.presentation.MainActivity;
import com.example.comicheroes.presentation.screens.detail.DetailFragment;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeFragmentBinding binding;

    private HomeViewModel viewModel;

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

        ((MainActivity) requireActivity()).showBottomBar();

        viewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);

        observeViewModel();
    }

    private void initComponents(List<HeroHome> list) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        binding.HeroRecyclerList.setLayoutManager(layoutManager);

        binding.HeroRecyclerList.setHasFixedSize(true);

        HeroListAdapter adapter = new HeroListAdapter(this.getContext(), list, item -> requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainer, DetailFragment.newInstance(item.getId()))
                .addToBackStack(null)
                .commit());
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
