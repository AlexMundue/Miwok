package com.example.android.miwok;

/**
 * Created by alexi on 13/04/2017.
 */

public class Word {

    private String mDefaultWord;
    private String mMiwokWord;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioResourceId;

    public Word(String defaultWord, String miwokWord, int mAudioResourceId){
        this.mDefaultWord = defaultWord;
        this.mMiwokWord = miwokWord;
        this.mAudioResourceId = mAudioResourceId;
    }

    public Word(String mDefaultWord, String mMiwokWord, int mImageResourceId, int mAudioResourceId) {
        this.mMiwokWord = mMiwokWord;
        this.mDefaultWord = mDefaultWord;
        this.mImageResourceId = mImageResourceId;
        this.mAudioResourceId = mAudioResourceId;
    }

    public String getmMiwokWord() {
        return mMiwokWord;
    }

    public void setmMiwokWord(String mMiwokWord) {
        this.mMiwokWord = mMiwokWord;
    }

    public String getmDefaultWord() {
        return mDefaultWord;
    }

    public void setmDefaultWord(String mDefaultWord) {
        this.mDefaultWord = mDefaultWord;
    }

    public int getmImageResourceId(){ return mImageResourceId; }

    public boolean hasImage(){ return mImageResourceId != NO_IMAGE_PROVIDED; }

    public int getmAudioResourceId(){return mAudioResourceId; }
}
