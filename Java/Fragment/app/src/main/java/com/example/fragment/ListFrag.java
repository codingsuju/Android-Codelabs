package com.example.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ListFrag extends ListFragment {
    ItemSelected activity;

    public interface ItemSelected{
        void onItemSelected(int index);
    }

    public ListFrag() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity=(ItemSelected) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<String> data=new ArrayList<String>();
        data.add("This is Item 1");
        data.add("This is Item 2");
        data.add("This is Item 3");
        data.add("This is Item 4");
        data.add("This is Item 5");
        data.add("This is Item 6");
        data.add("This is Item 7");
        data.add("This is Item 8");
        data.add("This is Item 9");
        data.add("This is Item 10");
        data.add("This is Item 11");
        data.add("This is Item 12");
        data.add("This is Item 13");
        data.add("This is Item 14");
        data.add("This is Item 15");
        data.add("This is Item 16");
        data.add("This is Item 17");
        data.add("This is Item 18");
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,data));
        if(this.getActivity().findViewById(R.id.layout_land)!=null)
        {
            activity.onItemSelected(0);
        }
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        activity.onItemSelected(position);
    }
}
