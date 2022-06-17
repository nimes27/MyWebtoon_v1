package com.example.mywebtoon;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

import androidx.annotation.Nullable;

public class GenreActivity extends TabActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genre);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tsFantasy = tabHost.newTabSpec("FANTASY").setIndicator("판타지");
        tsFantasy.setContent(R.id.tabFantasy);
        tabHost.addTab(tsFantasy);

        TabHost.TabSpec tsAction = tabHost.newTabSpec("ACTION").setIndicator("액션");
        tsAction.setContent(R.id.tabAction);
        tabHost.addTab(tsAction);

        TabHost.TabSpec tsRomance = tabHost.newTabSpec("ROMANCE").setIndicator("로맨스");
        tsRomance.setContent(R.id.tabRomance);
        tabHost.addTab(tsRomance);

        TabHost.TabSpec tsThriller = tabHost.newTabSpec("THRILLER").setIndicator("스릴러");
        tsThriller.setContent(R.id.tabThriller);
        tabHost.addTab(tsThriller);

        tabHost.setCurrentTab(0);
    }
}
