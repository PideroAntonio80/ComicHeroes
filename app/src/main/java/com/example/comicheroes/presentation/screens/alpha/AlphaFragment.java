package com.example.comicheroes.presentation.screens.alpha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.comicheroes.R;
import com.example.comicheroes.databinding.AlphaFragmentBinding;
import com.example.comicheroes.presentation.screens.home.HomeFragment;

public class AlphaFragment extends Fragment {

    private View view;

    private AlphaViewModel alphaViewModel = new AlphaViewModel();

    public static AlphaFragment newInstance() {
        return new AlphaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        AlphaFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.alpha_fragment, container, false);
        view = binding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
