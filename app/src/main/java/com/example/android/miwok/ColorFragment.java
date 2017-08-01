package com.example.android.miwok;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {


    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_colors, container, false);

        // Up navigation (back to previous page.)
        // ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ArrayList<Word> colors = new ArrayList<>();

        colors.add(new Word("שחור", "black", R.drawable.color_black));
        colors.add(new Word("אדום", "red", R.drawable.color_red));
        colors.add(new Word("לבן", "white", R.drawable.color_white));
        colors.add(new Word("אפור", "gray", R.drawable.color_gray));
        colors.add(new Word("ירוק", "green", R.drawable.color_green));
        colors.add(new Word("צהוב חרדל", "mustard yellow", R.drawable.color_mustard_yellow));
        colors.add(new Word("צהוב מאובק", "dusty yellow", R.drawable.color_dusty_yellow));
        colors.add(new Word("חום", "brown", R.drawable.color_brown));

        WordAdapter listIterator = new WordAdapter(getActivity(), colors, R.color.category_colors);

        ListView listColor = (ListView) rootView.findViewById(R.id.list_colors);

        listColor.setAdapter(listIterator);

        return rootView;
    }

}
