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
public class MuseumsFragment extends Fragment {

    public MuseumsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.venice_list, container, false);

        final ArrayList<Venice> venice = new ArrayList<>();

        venice.add(new Venice(getString(R.string.palazzo_ducale), getString(R.string.ducale_address),
                getString(R.string.ducale_time), getString(R.string.ducale_ticket)));
        venice.add(new Venice(getString(R.string.basilica_sanmarco), getString(R.string.basilica_address),
                getString(R.string.basilica_time), getString(R.string.basilica_ticket)));
        venice.add(new Venice(getString(R.string.museo_correr), getString(R.string.correr_address),
                getString(R.string.correr_time), getString(R.string.correr_ticket)));
        venice.add(new Venice(getString(R.string.gallerie_accademia), getString(R.string.gallerie_address),
                getString(R.string.gallerie_time), getString(R.string.gallerie_ticket)));
        venice.add (new Venice(getString(R.string.ca_oro), getString(R.string.oro_address),
                getString(R.string.oro_time), getString(R.string.oro_ticket)));
        venice.add(new Venice(getString(R.string.rezzonico), getString(R.string.rezzonico_address),
                getString(R.string.rezzonico_time), getString(R.string.rezzonico_ticket)));
        venice.add(new Venice(getString(R.string.pesaro), getString(R.string.pesaro_address),
                getString(R.string.pesaro_time), getString(R.string.pesaro_ticket)));
        venice.add(new Venice(getString(R.string.mocenigo), getString(R.string.mocenigo_address),
                getString(R.string.mocenigo_time), getString(R.string.mocenigo_ticket)));
        venice.add(new Venice(getString(R.string.goldoni), getString(R.string.goldoni_address),
                getString(R.string.goldoni_time), getString(R.string.goldoni_ticket)));
        venice.add(new Venice(getString(R.string.fortuny), getString(R.string.fortuny_address),
                getString(R.string.fortuny_time), getString(R.string.fortuny_ticket)));
        venice.add(new Venice(getString(R.string.grimani), getString(R.string.grimani_address),
                getString(R.string.grimani_time), getString(R.string.grimani_ticket)));

        MuseumsAdapter adapter = new MuseumsAdapter(getActivity(), venice);

        ListView listView = (ListView) rootView.findViewById(R.id.visit_list);

        listView.setAdapter(adapter);
        return rootView;
    }
}