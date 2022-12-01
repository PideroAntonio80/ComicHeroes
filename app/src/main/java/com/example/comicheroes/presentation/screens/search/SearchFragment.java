package com.example.comicheroes.presentation.screens.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.comicheroes.R;
import com.example.comicheroes.databinding.SearchFragmentBinding;
import com.example.comicheroes.presentation.screens.home.HomeFragment;

public class SearchFragment extends Fragment {

    private View view;

    private SearchViewModel searchViewModel = new SearchViewModel();

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        SearchFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.search_fragment, container, false);
        view = binding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
