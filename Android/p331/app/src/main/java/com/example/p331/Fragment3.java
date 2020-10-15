package com.example.p331;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment3 extends Fragment {

    TextView tx;
    Button button;
    MainActivity m;
    public Fragment3(MainActivity m) {
        this.m = m;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = null;
        viewGroup = (ViewGroup) inflater.inflate(
                R.layout.fragment_3, container,false);
        button = viewGroup.findViewById(R.id.button);
        tx = viewGroup.findViewById(R.id.tt3);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(m, tx.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return viewGroup;
    }
}