package com.example.q.contackapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.widget.EditText;

import com.example.q.contackapp.adapters.ViewPagerAdapter;
import com.example.q.contackapp.fragments.FragmentContacts;
import com.example.q.contackapp.fragments.FragmentGallery;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private final int[] ICONS = {R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentContacts(), "Contacts");
        adapter.addFragment(new FragmentGallery(), "Gallery");

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabTextColors(android.R.color.white, android.R.color.white);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tab.setIcon(ICONS[i]);
        }
    }
}
