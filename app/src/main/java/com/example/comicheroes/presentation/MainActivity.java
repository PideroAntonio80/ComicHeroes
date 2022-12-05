package com.example.comicheroes.presentation;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.comicheroes.R;
import com.example.comicheroes.databinding.ActivityMainBinding;
import com.example.comicheroes.presentation.screens.splash.SplashFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    // Control the first fragment we show
    public void initView(){

        showFragment(new SplashFragment());

        Toolbar toolbar = binding.mainActivityToolbar;
        setSupportActionBar(toolbar);
    }

    public void showToolBar() {
        binding.mainActivityToolbar.setVisibility(View.VISIBLE);
    }

    public void hideToolBar() {
        binding.mainActivityToolbar.setVisibility(View.GONE);
    }

    public void showBackArrow() {
        binding.mainActivityToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
    }

    public void hideBackArrow() {
        binding.mainActivityToolbar.setNavigationIcon(null);
    }

    // Function to change fragments
    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).addToBackStack(null).commit();
    }

    public void homeFragmentTitleWriter() {
        binding.mainActivityToolbar.setTitle(R.string.toolbar_home_title);
    }

    public void detailFragmentTitleWriter() {
        binding.mainActivityToolbar.setTitle(R.string.toolbar_detail_title);
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}