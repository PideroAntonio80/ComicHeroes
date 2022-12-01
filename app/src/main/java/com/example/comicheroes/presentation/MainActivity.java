package com.example.comicheroes.presentation;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.comicheroes.R;
import com.example.comicheroes.databinding.ActivityMainBinding;
import com.example.comicheroes.presentation.screens.home.HomeFragment;
import com.example.comicheroes.presentation.screens.search.SearchFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initOptionBars();
        manageFragmentsTitle();
    }

    public void initOptionBars(){

        showFragment(HomeFragment.newInstance());
        binding.mainActivityToolbar.setTitle(R.string.toolbar_home_title);

        Toolbar toolbar = binding.mainActivityToolbar;
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);

        binding.mainActivityBottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.homeFragment:
                    showFragment(HomeFragment.newInstance());
                    binding.mainActivityToolbar.setTitle(R.string.toolbar_home_title);
                    item.getActionView();
                    break;
                case R.id.searchFragment:
                    showFragment(SearchFragment.newInstance());
                    binding.mainActivityToolbar.setTitle(R.string.toolbar_search_title);
                    break;
            }
            return false;
        });
    }

    private void manageFragmentsTitle() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.fragmentContainer);

        if(currentFragment instanceof HomeFragment) {
            binding.mainActivityToolbar.setTitle(R.string.toolbar_home_title);
        }
        else if(currentFragment instanceof SearchFragment) {
            binding.mainActivityToolbar.setTitle(R.string.toolbar_search_title);
        }
    }

    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).addToBackStack(null).commit();
    }

    private void showBottomBar() {
        binding.mainActivityBottomNav.setVisibility(View.VISIBLE);
    }

    private void hideBottomBar() {
        binding.mainActivityBottomNav.setVisibility(View.GONE);
    }

    private void showToolBar() {
        binding.mainActivityToolbar.setVisibility(View.VISIBLE);
    }

    private void hideToolBar() {
        binding.mainActivityToolbar.setVisibility(View.GONE);
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        manageFragmentsTitle();
        return true;
    }
}