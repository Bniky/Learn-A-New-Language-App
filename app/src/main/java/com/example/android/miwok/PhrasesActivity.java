package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

        WordAdapter phaseList = new WordAdapter(this, phrases, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list_phrases);

        listView.setAdapter(phaseList);
    }
}
