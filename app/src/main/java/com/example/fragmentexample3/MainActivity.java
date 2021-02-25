package com.example.fragmentexample3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Boolean twoPane=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragContainer_personality)!=null){
            Log.d("help","help");
            twoPane=true;
        }

        if (twoPane==false){
            loadFragment(new FirstFragment(),R.id.fragContainer_first);
            Button personalityButton = findViewById(R.id.button_personality);
            personalityButton.setOnClickListener(v -> launchActivity(v,1));
            Button houseInfoButton = findViewById(R.id.button_houseInfo);
            houseInfoButton.setOnClickListener(v -> launchActivity(v,2));
        }
        else{
            loadFragment(new FirstFragment(), R.id.fragContainer_land_first);
            loadFragment(new SecondFragment(1), R.id.fragContainer_personality);
            loadFragment(new SecondFragment(2), R.id.fragContainer_houseInfo);
        }

    }

    public void loadFragment(Fragment fragment, int id){
        FragmentManager fragmentManager = getSupportFragmentManager();
        // create a fragment transaction to begin the transaction and replace the fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //replacing the placeholder - fragmentContainterView with the fragment that is passed as parameter
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }

    public void launchActivity(View view, int page){
        Intent intent = new Intent(this, SecondActivity.class);
        int extra=page;
        intent.putExtra("page",extra);
        startActivity(intent);
    }
}