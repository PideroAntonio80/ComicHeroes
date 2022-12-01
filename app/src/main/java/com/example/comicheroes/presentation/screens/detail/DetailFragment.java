package com.example.comicheroes.presentation.screens.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.comicheroes.R;
import com.example.comicheroes.databinding.DetailFragmentBinding;

public class DetailFragment extends Fragment {

    private View view;

    private DetailViewModel detailViewModel = new DetailViewModel();

    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        DetailFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.detail_fragment_, container, false);
        view = binding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
