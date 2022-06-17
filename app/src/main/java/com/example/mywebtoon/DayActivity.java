package com.example.mywebtoon;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

import androidx.annotation.Nullable;

public class DayActivity extends TabActivity {

    ImageView iv[] = new ImageView[8];
    int imgid[] = {R.id.i1, R.id.i2, R.id.i3, R.id.i4,
                R.id.i5, R.id.i6, R.id.i7, R.id.i8};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day);

        //TabHost
        TabHost tabHost = getTabHost();

        TabHost.TabSpec tsMon = tabHost.newTabSpec("MON").setIndicator("월");
        tsMon.setContent(R.id.tabMon);
        tabHost.addTab(tsMon);

        TabHost.TabSpec tsTue = tabHost.newTabSpec("TUE").setIndicator("화");
        tsTue.setContent(R.id.tabTue);
        tabHost.addTab(tsTue);

        TabHost.TabSpec tsWed = tabHost.newTabSpec("WED").setIndicator("수");
        tsWed.setContent(R.id.tabWed);
        tabHost.addTab(tsWed);

        TabHost.TabSpec tsThu = tabHost.newTabSpec("THU").setIndicator("목");
        tsThu.setContent(R.id.tabThu);
        tabHost.addTab(tsThu);

        TabHost.TabSpec tsFri = tabHost.newTabSpec("FRI").setIndicator("금");
        tsFri.setContent(R.id.tabFri);
        tabHost.addTab(tsFri);

        TabHost.TabSpec tsSat = tabHost.newTabSpec("SAT").setIndicator("토");
        tsSat.setContent(R.id.tabSat);
        tabHost.addTab(tsSat);

        TabHost.TabSpec tsSun = tabHost.newTabSpec("SUN").setIndicator("일");
        tsSun.setContent(R.id.tabSun);
        tabHost.addTab(tsSun);

        tabHost.setCurrentTab(0);


        //ImageView
        for (int i = 0; i < imgid.length; i++) {
            final int index; index = i;
            iv[index] = (ImageView) findViewById(imgid[index]);
            
            //Mon 1웹툰
            iv[0].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 = new Intent(getApplicationContext(), Toon1Activity.class);
                    startActivity(intent1);
                }
            });
        }
    }
}
