package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.miwok.R.id.li;

/**
 * Created by Nicholas on 22/07/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {


    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    //color for each list
    private int mColor;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param word A List of word objects to display in a list
     */
    public WordAdapter(Activity context, ArrayList<Word> word, int color) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, word);
        mColor  = color;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(li);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColor);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);



        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentAndroidFlavor = getItem(position);

        LinearLayout rr = (LinearLayout) listItemView.findViewById(R.id.li);
        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.language);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentAndroidFlavor.getHebrewTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.english);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentAndroidFlavor.getDefaultTranslation());

        /* Image not empty

         */

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if(currentAndroidFlavor.hasImageResourceId()) {
            imageView.setImageResource(currentAndroidFlavor.getImageResourceId());

        }else{
            imageView.setVisibility(View.GONE);
        }

            // Return the whole list item layout (containing 2 TextViews and an ImageView)
            // so that it can be shown in the ListView
            return listItemView;

    }
}
