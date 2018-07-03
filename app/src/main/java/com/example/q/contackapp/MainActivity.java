package com.example.q.contackapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.q.contackapp.adapters.ViewPagerAdapter;
import com.example.q.contackapp.fragments.FragmentContacts;
import com.example.q.contackapp.fragments.FragmentGallery;
import com.example.q.contackapp.fragments.FragmentLoadInsta;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private final int[] ICONS = {R.drawable.human4, R.drawable.galleryicon, R.drawable.ic_launcher_foreground};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentContacts(), "Contacts");
        adapter.addFragment(new FragmentGallery(), "Gallery");
        adapter.addFragment(new FragmentLoadInsta(), "Instagram");
        //adapter.addFragment(new FragmentGallery(), "Gallery");

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setIcon(ICONS[i]);
        }

        //FragmentTransaction fragmentTransaction =  getSupportFragmentManager().beginTransaction();

        //fragmentTransaction.add(R.id.tablayout, new FragmentGallery());


    }

    private void askPermissions() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_CONTACTS}, 1);
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_CALL_LOG}, 1);
        }
    }
    private long pressedTime = 0;
    public interface OnBackPressedListener {
        public void onBack();
    }
    private OnBackPressedListener mBackListener;

    public void setOnBackPressedListener(OnBackPressedListener listener) {
        mBackListener =listener;
    }

    @Override
    public void onBackPressed() {
        if (mBackListener != null) {
            mBackListener.onBack();
            Log.e("!!!", "Listener is not null");
        } else {
            Log.e("!!!", "Listener is null");
            if ( pressedTime == 0 ) {
                Snackbar.make(findViewById(R.id.main_layout),
                        " 한 번 더 누르면 종료됩니다." , Snackbar.LENGTH_LONG).show();
                pressedTime = System.currentTimeMillis();
            }
            else {
                int seconds = (int) (System.currentTimeMillis() - pressedTime);

                if ( seconds > 2000 ) {
                    Snackbar.make(findViewById(R.id.main_layout),
                            " 한 번 더 누르면 종료됩니다." , Snackbar.LENGTH_LONG).show();
                    pressedTime = 0 ;
                }
                else {
                    super.onBackPressed();
                    Log.e("!!!", "onBackPressed : finish, killProcess");
                    finish();
                    android.os.Process.killProcess(android.os.Process.myPid());
                }
            }
        }
    }
}
