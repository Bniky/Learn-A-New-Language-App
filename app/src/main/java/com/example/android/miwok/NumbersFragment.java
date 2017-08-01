package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class NumbersFragment extends Fragment {

    private MediaPlayer sound;
    private AudioManager mAu;

    private AudioManager.OnAudioFocusChangeListener mAudioManagerL = new AudioManager.OnAudioFocusChangeListener(){
        @Override
        public void onAudioFocusChange(int i) {
            if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // Pause playback because your Audio Focus was
                // temporarily stolen, but will be back soon.
                // i.e. for a phone call

                // Lower the volume, because something else is also
                // playing audio over you.
                // i.e. for notifications or navigation directions
                // Depending on your audio playback, you may prefer to
                // pause playback here instead. You do you.
            } else if (i == AudioManager.AUDIOFOCUS_GAIN) {
                // Resume playback, because you hold the Audio Focus
                // again!
                // i.e. the phone call ended or the nav directions
                // are finished
                // If you implement ducking and lower the volume, be
                // sure to return it to normal here, as well.
                sound.start();
            }else if(i == AudioManager.AUDIOFOCUS_LOSS){
                HelperClass.releaseMediaPlayer(sound, mAu, mAudioManagerL);
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompleteListener = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp) {
            HelperClass.releaseMediaPlayer(sound, mAu, mAudioManagerL);
        }};


    public NumbersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_numbers, container, false);

        /** TODO: Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */

        // Up navigation (back to previous page.)
        // ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAu = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);


        final ArrayList<Word> numbers = new ArrayList<Word>();

        numbers.add(new Word("אחד", "one", R.drawable.number_one, R.raw.one_in_hebrew));
        numbers.add(new Word("שְׁנַיִם", "two", R.drawable.number_two, R.raw.two_in_hebrew));
        numbers.add(new Word("שְׁלוֹשָׁה", "three", R.drawable.number_three, R.raw.three_in_hebrew));
        numbers.add(new Word("אַרְבָּעָה", "four", R.drawable.number_four, R.raw.four_in_hebrew));
        numbers.add(new Word("חֲמִשָׁה", "five", R.drawable.number_five, R.raw.five_in_hebrew));
        numbers.add(new Word("שִׁשָּׁה", "six", R.drawable.number_six, R.raw.six_in_hebrew));
        numbers.add(new Word("שִׁבְעַה", "seven", R.drawable.number_seven, R.raw.seven_in_hebrew));
        numbers.add(new Word("שְׁמוֹנָה", "eight", R.drawable.number_eight, R.raw.eight_in_hebrew));
        numbers.add(new Word("תִּשְׁעָה", "nine", R.drawable.number_nine, R.raw.nine_in_hebrew));
        numbers.add(new Word("עֲשָׂרָה", "ten", R.drawable.number_ten, R.raw.ten_in_hebrew));

        //LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

       /*for(int i = 0;i<numbers.size();i++) {

           TextView text = new TextView(this);
           text.setText(numbers.get(i));
           rootView.addView(text);
       }*/


        //ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, R.layout.simple_list_item_1, numbers);

        WordAdapter itemsAdapter = new WordAdapter(getActivity(), numbers, R.color.category_numbers);

        ListView listView = (ListView) rootView.findViewById(R.id.list_numbers);

        listView.setAdapter(itemsAdapter);
        Log.v("NumberFragment", "4");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                HelperClass.releaseMediaPlayer(sound, mAu, mAudioManagerL);

                // Request audio focus for playback, Use the music stream. Request permanent focus.
                int result = mAu.requestAudioFocus(mAudioManagerL, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback

                    //mAudioManager.requestAudioFocus(mAudioManager, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

                    sound = MediaPlayer.create(getActivity(), numbers.get(i).getSoundId());
                    sound.start();

                    sound.setOnCompletionListener(mCompleteListener);

                    Word word = numbers.get(i);
                    Log.v("NumberActity", "word " + word.toString());

                }
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        HelperClass.releaseMediaPlayer(sound, mAu, mAudioManagerL);
    }

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(getActivity());
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
