package com.example.comicheroes.presentation.screens.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comicheroes.R;
import com.example.comicheroes.data.localdb.database.HeroDatabase;
import com.example.comicheroes.data.localdb.database.dao.HeroDAO;
import com.example.comicheroes.data.localdb.mapper.Mapper;
import com.example.comicheroes.data.localdb.model.HeroDB;
import com.example.comicheroes.data.repository.HeroDbRepository;
import com.example.comicheroes.data.repository.HeroDbRepositoryImp;
import com.example.comicheroes.databinding.HomeFragmentBinding;
import com.example.comicheroes.domain.model.HeroDetail;
import com.example.comicheroes.domain.model.HeroHome;
import com.example.comicheroes.presentation.MainActivity;
import com.example.comicheroes.presentation.screens.detail.DetailFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements SearchView.OnQueryTextListener {

    private HomeFragmentBinding binding;

    private HomeViewModel viewModel;

    private HeroListAdapter adapter;

    private HeroDatabase db;
    private HeroDAO dao;
    private HeroDbRepository repo;

    private Mapper mapper;

    List<HeroDB> listFromDB;
    List<HeroDetail> myList;

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

        ((MainActivity) requireActivity()).hideBackArrow();
        ((MainActivity) requireActivity()).homeFragmentTitleWriter();

        dbController();

        viewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);

        listFromDB = repo.getAllHeroes();

        if (listFromDB != null && !listFromDB.isEmpty()) {
            myList = new ArrayList<>();

            for (int i = 0; i < listFromDB.size(); i++) {
                myList.add(mapper.fromHeroDBToHeroDetail(listFromDB.get(i)));
            }

            initComponents(myList);
            initListener();
        }
        else {
            observeViewModel();
        }
    }

    public void dbController() {
        db = HeroDatabase.getInstance(this.requireContext().getApplicationContext());
        dao = db.heroDAO();
        repo = new HeroDbRepositoryImp(dao);
        mapper = new Mapper();
    }

    private void initComponents(List<HeroDetail> list) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        binding.HeroRecyclerList.setLayoutManager(layoutManager);

        binding.HeroRecyclerList.setHasFixedSize(true);

        adapter = new HeroListAdapter(this.getContext(), list, item -> requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainer, DetailFragment.newInstance(item.getId()))
                .addToBackStack(null)
                .commit());
        binding.HeroRecyclerList.setAdapter(adapter);
    }

    private void observeViewModel() {
        viewModel.getHeroesListResponseLiveData().observe(getViewLifecycleOwner(), heroDetails -> {

            if (heroDetails != null && !heroDetails.isEmpty()) {

                for (int i = 0; i < heroDetails.size(); i++) {
                    repo.insertHero(mapper.fromHeroDetailToHeroDB(heroDetails.get(i)));
                }

                listFromDB = repo.getAllHeroes();
                myList = new ArrayList<>();

                for (int i = 0; i < listFromDB.size(); i++) {
                    myList.add(mapper.fromHeroDBToHeroDetail(listFromDB.get(i)));
                }

                initComponents(myList);
                initListener();
            }
        });
    }

    private void initListener() {
        binding.searchViewHeroes.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
    }
}
