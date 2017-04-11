package com.verifone.kail1.myapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentPage1 extends Fragment implements View.OnClickListener {
    private Button bt;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.add(Menu.NONE,0, 0, "item1");
        menu.add(Menu.NONE,1, 1, "item2");
        menu.add(Menu.NONE,2, 2, "item3");
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                Toast.makeText(getActivity(), "item1", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(getActivity(), "item2", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getActivity(), "item3", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
