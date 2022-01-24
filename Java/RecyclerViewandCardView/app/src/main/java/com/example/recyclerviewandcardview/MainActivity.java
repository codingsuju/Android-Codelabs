package com.example.recyclerviewandcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Person> people;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd=findViewById(R.id.btnAdd);
        recyclerView=findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        people=new ArrayList<Person>();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new Person("One","Direction","bus"));
                myAdapter.notifyDataSetChanged();
            }
        });

        people.add(new Person("Justin","Bieber","bus"));
        people.add(new Person("Harry","Styles","bus"));
        people.add(new Person("Bebe","Rexha","plane"));
        people.add(new Person("Katy","Perry","plane"));
        people.add(new Person("Zara","Larsson","bus"));
        people.add(new Person("Calvin","Harris","bus"));
        people.add(new Person("Ellie","Goulding","plane"));
        people.add(new Person("Machine Gun","Kelly","plane"));
        people.add(new Person("Mike","Posner","bus"));
        people.add(new Person("Martin","Garrix","bus"));
        people.add(new Person("Maggie","Lindemann","plane"));
        people.add(new Person("Megan","Nicole","plane"));
        people.add(new Person("Louis","Tomlinson","bus"));
        people.add(new Person("Lewis","Capaldi","bus"));
        people.add(new Person("Kelly","Clarkson","plane"));
        people.add(new Person("Justin","Timberlake","plane"));
        people.add(new Person("Chrissy","Constanza","bus"));
        people.add(new Person("Johnny","Orlando","bus"));
        people.add(new Person("Jason","Derulo","plane"));
        people.add(new Person("Conor","Maynard","plane"));
        people.add(new Person("Clara","Mae","bus"));
        people.add(new Person("Charlie","Puth","bus"));
        people.add(new Person("Camila","Cabello","plane"));
        people.add(new Person("Bea","Miller","plane"));
        myAdapter=new PersonAdapter(this,people);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this,"Name "+people.get(index).getName(),Toast.LENGTH_SHORT).show();
    }
}