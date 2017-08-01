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
public class FamilyFragment extends Fragment {


    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_family, container, false);

        // Up navigation (back to previous page.)
        // ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<Word> familym = new ArrayList<Word>();

        familym.add(new Word( "אַבָּא", "father",R.drawable.family_father));
        familym.add(new Word( "אִמָא", "mother", R.drawable.family_mother));
        familym.add(new Word( "בֵּן", "son", R.drawable.family_son));
        familym.add(new Word( "בַּת", "daughter",R.drawable.family_daughter));
        familym.add(new Word( "אח גדול", "older brother", R.drawable.family_older_brother));
        familym.add(new Word( "אח יותר צעיר", "younger brother", R.drawable.family_younger_brother));
        familym.add(new Word( "אחות גדולה", "older sister", R.drawable.family_older_sister));
        familym.add(new Word( "סַבתָא", "grandmother", R.drawable.family_grandmother));
        familym.add(new Word( "סָבָּא", "grandfather", R.drawable.family_grandfather));


        WordAdapter familytListItem = new WordAdapter(getActivity(), familym, R.color.category_family);

        ListView familyList = (ListView) rootView.findViewById(R.id.list_family);

        familyList.setAdapter(familytListItem);

        return rootView;
    }

}
