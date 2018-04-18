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
public class PlacesFragment extends Fragment {

    public PlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.venice_list, container, false);

        final ArrayList <Venice> venice = new ArrayList<>();

        venice.add(new Venice(getString(R.string.piazza_sanmarco), getString(R.string.sanmarco_descr),
                R.drawable.sanmarco));
        venice.add(new Venice(getString(R.string.rialto), getString(R.string.rialto_descr), R.drawable.ponte_rialto));
        venice.add(new Venice(getString(R.string.sospiri), getString(R.string.sospiri_descr), R.drawable.ponte_sospiri));
        venice.add(new Venice(getString(R.string.scalzi), getString(R.string.scalzi_descr),
                R.drawable.ponte_scalzi));
        venice.add(new Venice(getString(R.string.ponte_accademia), getString(R.string.accademia_descr),
                R.drawable.ponte_accademia));
        venice.add(new Venice(getString(R.string.guglie), getString(R.string.guglie_descr),
                R.drawable.ponte_guglie));
        venice.add(new Venice(getString(R.string.tre_archi), getString(R.string.tre_archi_descr),
                R.drawable.tre_archi));
        venice.add(new Venice(getString(R.string.fondamente_nuove), getString(R.string.fondamente_nuove_descr),
                R.drawable.fondamente_nuove));
        venice.add(new Venice(getString(R.string.bovolo), getString(R.string.bovolo_descr),
                R.drawable.scala_contarini));

        VeniceAdapter adapter = new VeniceAdapter(getActivity(), venice);

        ListView listView = (ListView) rootView.findViewById(R.id.visit_list);

        listView.setAdapter(adapter);

        return rootView;
    }
}