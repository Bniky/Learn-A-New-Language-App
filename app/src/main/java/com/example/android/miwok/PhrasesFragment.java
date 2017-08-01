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
public class PhrasesFragment extends Fragment {


    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.activity_phrases, container, false);

        // Up navigation (back to previous page.)
        // ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayList<Word> phrases = new ArrayList<Word>();

        phrases.add(new Word( "לאן אתה הולך?" , "Where are you going?"));
        phrases.add(new Word( "מה השם שלך?", "What is your name?"));
        phrases.add(new Word( "שמי", "My name is"));
        phrases.add(new Word( "איך אתה מרגיש?" , "How are you feeling?"));
        phrases.add(new Word( "אני מרגיש טוב.", "I’m feeling good."));
        phrases.add(new Word( "אתה בא?" , "Are you coming?"));
        phrases.add(new Word( "כן, אני באה." , "Yes, I’m coming."));
        phrases.add(new Word( "אני בא." , "I’m coming."));
        phrases.add(new Word( "בוא נלך." , "Let’s go."));
        phrases.add(new Word( "בוא הנה.","Come here."));

        WordAdapter phaseList = new WordAdapter(getActivity(), phrases, R.color.category_phrases);

        ListView listView = (ListView) rootView.findViewById(R.id.list_phrases);

        listView.setAdapter(phaseList);

        return rootView;
    }

}
