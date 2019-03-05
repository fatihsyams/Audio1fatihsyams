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
public class HewanFragment extends Fragment {
    HewanAdapter adapter;
    RecyclerView rvHewan;
    String[] namaHewan = {"DOG", "MONKEY", "PIG", "SNAKE", "TIGER"};
    int[] gambarHewan = {R.drawable.dog, R.drawable.monkey, R.drawable.pig, R.drawable.snake, R.drawable.tiger};
    int[] soundHewan = {R.raw.bark, R.raw.rmonkeycolobus, R.raw.pig, R.raw.pig, R.raw.snakehit2, R.raw.tiger};

    public HewanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hewan, container, false);
        rvHewan = view.findViewById(R.id.rv_hewan);
        rvHewan.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter = new HewanAdapter(getActivity(), namaHewan, gambarHewan, soundHewan);
        rvHewan.setAdapter(adapter);
        return view;
    }

}
