package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.attr.y;
import static com.example.android.miwok.R.id.family;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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


        WordAdapter familytListItem = new WordAdapter(this, familym, R.color.category_family);

        ListView familyList = (ListView) findViewById(R.id.list_family);

        familyList.setAdapter(familytListItem);

    }
}
