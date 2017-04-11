package com.verifone.kail1.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements FragmentPage1.Fragment1Interface,
        FragmentPage2.Fragment2Interface, View.OnClickListener {

    private TextView button1, button2;
    private FragmentPage1 fragmentPage1;
    private FragmentPage2 fragmentPage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        button1 = (TextView) findViewById(R.id.button1);
        button2 = (TextView) findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentPage1 = new FragmentPage1();
        fragmentTransaction.add(R.id.fragment_content, fragmentPage1).commit();
    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (view.getId()) {
            case R.id.button1:
                if (fragmentPage1 == null)
                    fragmentPage1 = new FragmentPage1();
                fragmentTransaction.replace(R.id.fragment_content, fragmentPage1);
                break;
            case R.id.button2:
                if (fragmentPage2 == null) {
                    fragmentPage2 = new FragmentPage2();
                    fragmentPage2.setFragment2Interface(this);
                }
                fragmentTransaction.replace(R.id.fragment_content, fragmentPage2);
                break;
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void fragment1_inner_button_clicked() {
        Log.d("Fragment", "Fragment1 clicked");
        Toast.makeText(this, "Hello Fragment1 inner button clicked", Toast.LENGTH_LONG).show();
    }

    @Override
    public void fragment2_inner_button_clicked() {
        Log.d("Fragment", "Fragment2 clicked");
        Toast.makeText(this, "Hello Fragment2 inner button clicked", Toast.LENGTH_LONG).show();
    }
}
