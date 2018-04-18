package com.example.android.venicetourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.venice_list, container, false);

        final ArrayList<Venice> venice = new ArrayList<>();
        venice.add(new Venice(getString(R.string.carnevale), getString(R.string.carnevale_descr)));
        venice.add(new Venice(getString(R.string.redentore), getString(R.string.redentore_descr)));
        venice.add(new Venice(getString(R.string.regata), getString(R.string.regata_descr)));
        venice.add(new Venice(getString(R.string.cinema), getString(R.string.cinema_descr)));
        venice.add(new Venice(getString(R.string.archit), getString(R.string.archit_descr)));
        venice.add(new Venice(getString(R.string.arte), getString(R.string.arte_desr)));

        VeniceAdapter adapter = new VeniceAdapter(getActivity(), venice);

        ListView listView = (ListView) rootView.findViewById(R.id.visit_list);

        listView.setAdapter(adapter);

        return rootView;
    }
}