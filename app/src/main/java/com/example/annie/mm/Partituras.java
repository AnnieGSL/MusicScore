package com.example.annie.mm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Partituras extends Fragment {
    RecyclerView recyclerView;
    partAdapter adapter;

    public Partituras() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fe = inflater.inflate(R.layout.fragment_partituras, container, false);
        recyclerView = (RecyclerView)fe.findViewById(R.id.rvParts);

        adapter = new partAdapter(getActivity(), Datos.getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return fe;
    }

}
