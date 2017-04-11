package com.verifone.kail1.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentPage2 extends Fragment implements View.OnClickListener{
    private Button bt;
    Fragment2Interface fragment2Interface;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button2, null, false);
        bt = (Button) view.findViewById(R.id.fragment2_inner_button);
        bt.setOnClickListener(this);
        return view;
    }

    public interface Fragment2Interface {
        void fragment2_inner_button_clicked();
    }

    public void setFragment2Interface(Fragment2Interface fragment2Interface) {
        this.fragment2Interface = fragment2Interface;
    }

    @Override
    public void onClick(View view) {
       switch (view.getId()) {
           case R.id.fragment2_inner_button:
                this.fragment2Interface.fragment2_inner_button_clicked();
               break;
       }
    }
}
