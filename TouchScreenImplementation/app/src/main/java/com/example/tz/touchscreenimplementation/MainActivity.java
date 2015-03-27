package com.example.tz.touchscreenimplementation;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.TabHost;
import android.app.TabActivity;
import android.widget.TabHost.OnTabChangeListener;

public class TabBar extends TabActivity implements OnTabChangeListener{

    /** Called when the activity is first created. */
    TabHost tabHost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get TabHost Reference
        tabHost = getTabHost();

        // Set TabChangeListener called when tab changed
        tabHost.setOnTabChangedListener(this);

        TabHost.TabSpec spec;
        Intent intent;

        /************* TAB1 ************/
        // Create  Intents to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, Tab1.class);
        spec = tabHost.newTabSpec("First").setIndicator("")
                .setContent(intent);

        //Add intent to tab
        tabHost.addTab(spec);

        /************* TAB2 ************/
        intent = new Intent().setClass(this, Tab2.class);
        spec = tabHost.newTabSpec("Second").setIndicator("")
                .setContent(intent);
        tabHost.addTab(spec);

        /************* TAB3 ************/
        intent = new Intent().setClass(this, Tab3.class);
        spec = tabHost.newTabSpec("Third").setIndicator("")
                .setContent(intent);
        tabHost.addTab(spec);

        // Set drawable images to tab
        tabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.tab2);
        tabHost.getTabWidget().getChildAt(2).setBackgroundResource(R.drawable.tab3);

        // Set com.example.tz.touchscreenimplementation.Tab1 as Default tab and change image
        tabHost.getTabWidget().setCurrentTab(0);
        tabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.charger_select);


    }

    @Override
    public void onTabChanged(String tabId) {

        /************ Called when tab changed *************/

        //********* Check current selected tab and change according images *******/

        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
        {
            if(i==0)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.charger);
            else if(i==1)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.home);
            else if(i==2)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.implant);
        }


        Log.i("tabs", "CurrentTab: "+tabHost.getCurrentTab());

        if(tabHost.getCurrentTab()==0)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.charger_select);
        else if(tabHost.getCurrentTab()==1)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.home_select); // HOME_SELECT
        else if(tabHost.getCurrentTab()==2)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.implant_select);

    }

}