package com.example.android.venicetourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MuseumsAdapter extends ArrayAdapter <Venice> {

    public MuseumsAdapter(Context context, ArrayList<Venice> venice) {
        super(context, 0, venice);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.museums, parent, false);
        }

        Venice currentWord = getItem(position);

        TextView museumName = (TextView) listItemView.findViewById(R.id.museum_name);
        museumName.setText(currentWord.getName());

        TextView museumAddress = (TextView) listItemView.findViewById(R.id.museum_address);
        museumAddress.setText(currentWord.getAddress());

        TextView museumTime = (TextView) listItemView.findViewById(R.id.museum_time);
        museumTime.setText(currentWord.getTime());

        TextView museumPrice = (TextView) listItemView.findViewById(R.id.museum_price);
        museumPrice.setText(currentWord.getPrice());

        View textContainer = listItemView.findViewById(R.id.museum_container);

        return listItemView;
    }
}
