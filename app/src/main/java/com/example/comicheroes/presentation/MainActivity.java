package com.example.comicheroes.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.comicheroes.R;
import com.example.comicheroes.data.localdb.database.HeroDatabase;
import com.example.comicheroes.data.localdb.database.dao.HeroDAO;
import com.example.comicheroes.databinding.ActivityMainBinding;
import com.example.comicheroes.presentation.screens.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    public void initView(){

        showFragment(HomeFragment.newInstance());

        Toolbar toolbar = binding.mainActivityToolbar;
        setSupportActionBar(toolbar);
    }

    public void showBackArrow() {
        binding.mainActivityToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
    }

    public void hideBackArrow() {
        binding.mainActivityToolbar.setNavigationIcon(null);
    }

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