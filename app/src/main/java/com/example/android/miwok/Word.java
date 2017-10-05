package com.example.android.miwok;


/**
 * Created by user on 12-09-2016.
 */
public class Word  {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId=NO_IMAGE_PROVIDED;
    private int mAudio;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String DefaultTranslation,String MiwokTransaltion,int Audio)
    {
        mDefaultTranslation=DefaultTranslation;
        mMiwokTranslation=MiwokTransaltion;
        mAudio=Audio;
    }

    public Word(String DefaultTranslation,String MiwokTranslation,int ImageResourceId,int Audio)
    {
        mDefaultTranslation=DefaultTranslation;
        mMiwokTranslation=MiwokTranslation;
        mImageResourceId=ImageResourceId;
        mAudio=Audio;
    }
    /**
     * Get the default ta=ranslation of the word.
     * @return
     */
    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok Translation of the word.
     * @return
     */
    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
    }

    public int getImageResourceId() { return mImageResourceId;}

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getmAudio() {return mAudio;}


}
