package com.verifone.kail1.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentPage1 extends Fragment implements View.OnClickListener {
    private Button bt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button1, null, false);
        bt = (Button) view.findViewById(R.id.fragment1_inner_button);
        bt.setOnClickListener(this);
        return view;
    }

    public interface Fragment1Interface {
        void fragment1_inner_button_clicked();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment1_inner_button:
                if (getActivity() instanceof Fragment1Interface) {
                    Log.d("Fragment", "Fragment1 inner button clicked");
                    ((Fragment1Interface) getActivity()).fragment1_inner_button_clicked();
                }
                break;
        }
    }
}
