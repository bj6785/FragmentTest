package com.verifone.kail1.myapplication;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentTitle extends Fragment{
    private TextView title_left;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title, null, false);
        title_left = (TextView) view.findViewById(R.id.title_left);
        title_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "测试", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
