package com.example.audio1fatihsyams;


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
public class BuahFragment extends Fragment {
    BuahAdapter adapter;
    RecyclerView rvBuah;

    String[] namaBuah = {"APEL", "ALPUKAT", "CERI", "JAMBUAIR", "DURIAN"};
    int[] gambarBuah = {R.drawable.apel, R.drawable.alpukat, R.drawable.ceri, R.drawable.jambuair, R.drawable.durian};
    int[] suaraBuah = {R.raw.apel, R.raw.alpukat, R.raw.ceri, R.raw.jambuair, R.raw.durian };
    public BuahFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_buah, container, false);
        rvBuah = v.findViewById(R.id.rv_buah);
        rvBuah.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false));
        adapter = new BuahAdapter(getActivity(), namaBuah, gambarBuah, suaraBuah);
        rvBuah.setAdapter(adapter);
        return v;
    }

}
