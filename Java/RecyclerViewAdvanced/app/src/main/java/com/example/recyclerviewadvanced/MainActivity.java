package com.example.recyclerviewadvanced;

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
    ArrayList<String> topic;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        btnAdd=findViewById(R.id.btnAdd);
        people=new ArrayList<Person>();
        topic= new ArrayList<String>();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new Person("Shawn","Mendes"));
                myAdapter.notifyDataSetChanged();
            }
        });
        people.add(new Person("Blank","Blank"));
        people.add(new Person("Justin","Bieber"));
        people.add(new Person("Harry","Styles"));
        people.add(new Person("Bebe","Rexha"));
        people.add(new Person("Katy","Perry"));
        people.add(new Person("Blank","Blank"));
        people.add(new Person("Zara","Larsson"));
        people.add(new Person("Calvin","Harris"));
        people.add(new Person("Ellie","Goulding"));
        people.add(new Person("Machine Gun","Kelly"));
        people.add(new Person("Blank","Blank"));
        people.add(new Person("Mike","Posner"));
        people.add(new Person("Martin","Garrix"));
        people.add(new Person("Maggie","Lindemann"));
        people.add(new Person("Megan","Nicole"));
        people.add(new Person("Blank","Blank"));
        people.add(new Person("Louis","Tomlinson"));
        people.add(new Person("Lewis","Capaldi"));
        people.add(new Person("Kelly","Clarkson"));
        people.add(new Person("Justin","Timberlake"));
        people.add(new Person("Blank","Blank"));
        people.add(new Person("Chrissy","Constanza"));
        people.add(new Person("Johnny","Orlando"));
        people.add(new Person("Jason","Derulo"));
        people.add(new Person("Conor","Maynard"));
        people.add(new Person("Blank","Blank"));
        people.add(new Person("Clara","Mae"));
        people.add(new Person("Charlie","Puth"));
        people.add(new Person("Camila","Cabello"));
        people.add(new Person("Bea","Miller"));
        //people.add(new Person("Blank","Blank","Blank"));
        //people.add(new Person("Bea","Miller","plane")); 31
        topic.add("Top Singers");
        topic.add("Most Loved Singers");
        topic.add("Fan Favorite Singers");
        topic.add("Nostalgic Singers");
        topic.add("Best Singers");
        topic.add("Best Voice Singers");
        topic.add("Top award-winning Singers");
        myAdapter=new PersonAdapter(this,people,topic);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onItemSelected(int index,int viewType) {
       if(viewType==1)
       Toast.makeText(this,"Name:"+people.get(index).getName(),Toast.LENGTH_SHORT).show();
       else
           Toast.makeText(this,topic.get(index).toString(),Toast.LENGTH_SHORT).show();
    }
}