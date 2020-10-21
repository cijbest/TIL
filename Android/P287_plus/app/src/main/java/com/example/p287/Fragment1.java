package com.example.p287;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1  extends Fragment {

    TextView textView;
    EditText editText;
    ImageView imageView;
    View1Manager manager;
    String str;
    public Fragment1(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = null;
        viewGroup = (ViewGroup)inflater.inflate(
                R.layout.fragment_1,container,false);
        textView = viewGroup.findViewById(R.id.textView);
        editText = viewGroup.findViewById(R.id.editText);
        imageView = viewGroup.findViewById(R.id.imageView);
        //textView.setText(str);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                textView.setText(str);
            }
        });
        return viewGroup;
    }
    public void setTx(String str){
        this.str = str;
        textView.setText(str);
    }


public static interface View1Manager{
    public void changeTx(String str);
}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof View1Manager){
            manager = (View1Manager)context;
        }
    }

}





