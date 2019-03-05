package com.example.audio1fatihsyams;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HijaiyahFragment extends Fragment {
    RecyclerView rvHijaiyah;
    HijaiyahAdapter adapter;

    public HijaiyahFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_hijaiyah, container, false);
        rvHijaiyah = view.findViewById(R.id.rv_hijaiyah);
        rvHijaiyah.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        adapter = new HijaiyahAdapter(getActivity());
        rvHijaiyah.setAdapter(adapter);


        return view;
    }

}
