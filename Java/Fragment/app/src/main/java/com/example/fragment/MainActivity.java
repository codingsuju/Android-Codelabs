package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected {

    TextView tvDescription;
    ArrayList<String> description=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDescription=findViewById(R.id.tvDescription);
        description=new ArrayList<String>();
        description.add("This is Desciption for Item 1");
        description.add("This is Desciption for Item 2");
        description.add("This is Desciption for Item 3");
        description.add("This is Desciption for Item 4");
        description.add("This is Desciption for Item 5");
        description.add("This is Desciption for Item 6");
        description.add("This is Desciption for Item 7");
        description.add("This is Desciption for Item 8");
        description.add("This is Desciption for Item 9");
        description.add("This is Desciption for Item 10");
        description.add("This is Desciption for Item 11");
        description.add("This is Desciption for Item 12");
        description.add("This is Desciption for Item 13");
        description.add("This is Desciption for Item 14");
        description.add("This is Desciption for Item 15");
        description.add("This is Desciption for Item 16");
        description.add("This is Desciption for Item 17");
        description.add("This is Desciption for Item 18");
        //the phone is in portrait mode
        if(findViewById(R.id.layout_portrait)!=null)
        {
            FragmentManager manager=this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }
        //the phone is in landscape mode
        if(findViewById(R.id.layout_land)!=null)
        {
            FragmentManager manager=this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }
    }

    @Override
    public void onItemSelected(int index) {
        tvDescription.setText(description.get(index));
        if(findViewById(R.id.layout_portrait)!=null)
        {
            FragmentManager manager=this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
