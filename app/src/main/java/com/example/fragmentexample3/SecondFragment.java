package com.example.fragmentexample3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {


    View view;

    private int page;

    public SecondFragment(){

    }
    public SecondFragment(int page){
        this.page=page;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_second, container, false);

        if (page==2){
            TextView title= (TextView)view.findViewById(R.id.textView2);
            TextView house=(TextView)view.findViewById(R.id.textView3);
            title.setText("House");
            house.setText(R.string.house);
        }


        return view;
    }
}
