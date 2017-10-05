package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v4.media.MediaBrowserCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 12-09-2016.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param pWords is the list of {@link Word}s to be displayed.
        * @param ColorResourceId is the resource ID for the background color for this list of words
     */
    public WordAdapter(Context context, ArrayList<Word> pWords, int ColorResourceId) {
        super(context,0,pWords);
        mColorResourceId=ColorResourceId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        final Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView MiwokTextView = (TextView) listItemView.findViewById(R.id.miwok);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        MiwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView DefaultTextView = (TextView) listItemView.findViewById(R.id.eng);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        DefaultTextView.setText(currentWord.getDefaultTranslation());

        // Set the theme color for the list item
        View TextContainer = (View) listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        TextContainer.setBackgroundColor(color);
        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView ImageResource = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView

        if(currentWord.hasImage()) {
            ImageResource.setImageResource(currentWord.getImageResourceId());
            ImageResource.setVisibility(View.VISIBLE);
        }
        else{
            ImageResource.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
