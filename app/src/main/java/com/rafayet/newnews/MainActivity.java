package com.rafayet.newnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.rafayet.newnews.View.Adapter.PagerAdapter;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem tab_Home, tab_Science, tab_health, tab_Entertainment, tab_Technology, tab_Sports;
    PagerAdapter pagerAdapter;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tab_Home = findViewById(R.id.tabItem_Home);
        tab_Science = findViewById(R.id.tabItem_Science);
        tab_Sports = findViewById(R.id.tabItem_Sports);
        tab_Entertainment = findViewById(R.id.tabItem_Entertainment);
        tab_health = findViewById(R.id.tabItem_Health);
        tab_Technology = findViewById(R.id.tabItem_Technology);


        ViewPager viewPager = findViewById(R.id.fragmentContainer);
        tabLayout = findViewById(R.id.tab_SubLayout);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (
                                tab.getPosition() == 0 ||
                                tab.getPosition() == 1 ||
                                tab.getPosition() == 2 ||
                                tab.getPosition() == 3 ||
                                tab.getPosition() == 4 ||
                                tab.getPosition() == 5
                ){
                    pagerAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



    }
}