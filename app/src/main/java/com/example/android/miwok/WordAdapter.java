package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alexi on 13/04/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    //Background color
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int backgroundColor){
        super(context,0, words);
        mColorResourceId = backgroundColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwokWordTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        // Get the miwok translation from the current Word object and
        // set this text on the name TextView
        miwokWordTextView.setText(currentWord.getMiwokWord());

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView defaultWordTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        // Get the english translation from the current Word object and
        // set this text on the number TextView
        defaultWordTextView.setText(currentWord.getDefaultWord());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        // Get the image resource ID from the current Word object and
        // set the image to image
        if(currentWord.hasImage()){
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }else {
            //If the word does not contain an image, then the imageView is removed from the view
            imageView.setVisibility(View.GONE);
        }


        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
