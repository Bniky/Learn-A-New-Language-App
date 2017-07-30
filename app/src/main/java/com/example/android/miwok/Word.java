package com.example.android.miwok;

/**
 * Created by Nicholas on 22/07/2017.
 */

public class Word {

    private String hebrewTranslation;
    private String defaultTranslation;
    private int imageResourceId;
    private  int soundId;

    public Word(String hebrewTranslation, String defaultTranslation){

        this.hebrewTranslation = hebrewTranslation;
        this.defaultTranslation = defaultTranslation;
    }



    public Word(String hebrewTranslation, String defaultTranslation, int id){
        this.hebrewTranslation = hebrewTranslation;
        this.defaultTranslation = defaultTranslation;
        this.imageResourceId = id;

    }

    public Word(String hebrewTranslation, String defaultTranslation, int id, int audio){
        this.hebrewTranslation = hebrewTranslation;
        this.defaultTranslation = defaultTranslation;
        this.imageResourceId = id;
        soundId = audio;
    }

    public String getHebrewTranslation() {
        return hebrewTranslation;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public int getImageResourceId(){
        return imageResourceId;
    }

    public int getSoundId(){
        return soundId;
    }

    public boolean hasImageResourceId(){
        return getImageResourceId() != 0;
    }

    public boolean hasSound(){
        return getSoundId() != 0;
    }

    @Override
    public String toString() {
        return "Word{" +
                "hebrewTranslation='" + hebrewTranslation + '\'' +
                ", defaultTranslation='" + defaultTranslation + '\'' +
                ", imageResourceId=" + imageResourceId +
                ", soundId=" + soundId +
                '}';
    }
}
