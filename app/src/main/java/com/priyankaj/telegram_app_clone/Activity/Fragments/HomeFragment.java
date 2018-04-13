package com.priyankaj.telegram_app_clone.Activity.Fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.priyankaj.telegram_app_clone.Activity.Data.CustomPojo;
import com.priyankaj.telegram_app_clone.Activity.Data.HideShowScrollListener;
import com.priyankaj.telegram_app_clone.Activity.Data.RVAdapter;
import com.priyankaj.telegram_app_clone.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    RVAdapter adapter;
    FloatingActionButton fab;
    private ArrayList<CustomPojo> listContentArr= new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycleView);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        //As explained in the tutorial, LineatLayoutManager tells the RecyclerView that the view
        //must be arranged in linear fashion
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new RVAdapter(getContext());
        //Method call for populating the view
        populateRecyclerViewValues();


        return view;


    }

    private void populateRecyclerViewValues() {

        for(int iter=1;iter<=50;iter++) {
            //Creating POJO class object
            CustomPojo pojoObject = new CustomPojo();
            //Values are binded using set method of the POJO class
            pojoObject.setName("Priyanka");
            pojoObject.setContent("Hello How are you?: "+iter);
            pojoObject.setTime("10:48 PM");
            //After setting the values, we add all the Objects to the array
            //Hence, listConentArr is a collection of Array of POJO objects
            listContentArr.add(pojoObject);
        }
        //We set the array to the adapter
        adapter.setListContent(listContentArr);
        //We in turn set the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);

    }

    public void onResume() {
        super.onResume();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                recyclerView.smoothScrollToPosition(recyclerView.getAdapter().getItemCount());

            }
        });
     recyclerView.addOnScrollListener(
             new HideShowScrollListener() {
        @Override
        public void onHide() {
            fab.hide();
        }

        @Override
        public void onShow() {
            fab.show();
        }
    });



}
}



