package com.bawei.dimensionsofthefilm.view;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.bawei.dimensionsofthefilm.R;
import com.bawei.dimensionsofthefilm.fragment.DianyingFragment;
import com.bawei.dimensionsofthefilm.fragment.YingyuanFragment;

import java.util.ArrayList;

public class GuanzhuActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<Fragment> list = new ArrayList<>();
    private ArrayList<String> listtab = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guanzhu);
        tabLayout = findViewById(R.id.tabllayout);
        viewPager = findViewById(R.id.view_pager);


         list.add(new YingyuanFragment());
         list.add(new DianyingFragment());

         listtab.add("电影");
        listtab.add("影院");

                                            //getChildFragmentManager()
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return  listtab.get(position);

            }
        });
         tabLayout.setupWithViewPager(viewPager);
    }


}
