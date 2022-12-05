package com.example.comicheroes.presentation.screens.splash;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.comicheroes.R;
import com.example.comicheroes.databinding.SplashFragmentBinding;
import com.example.comicheroes.presentation.MainActivity;
import com.example.comicheroes.presentation.screens.home.HomeFragment;

public class SplashFragment extends Fragment {

    SplashFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = SplashFragmentBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((MainActivity) requireActivity()).hideToolBar();

        initView();
    }

    // We show an animation during 6 seconds before we come into the app
    private void initView() {

        final Handler handler = new Handler();
        handler.postDelayed(
                () -> requireActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, HomeFragment.newInstance())
                        .commit(), 6000);
    }
}
