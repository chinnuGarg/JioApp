package com.app.jiogameapp.activity;



import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.app.jiogameapp.R;
import com.app.jiogameapp.fragment.MainFragment;


public class MainActivityMain extends FragmentActivity {

    Context context;
    TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        loadFragment(new MainFragment());
    }







    public void loadFragment(android.support.v4.app.Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainframe_layout,fragment);
        fragmentTransaction.commitAllowingStateLoss();

    }


}
