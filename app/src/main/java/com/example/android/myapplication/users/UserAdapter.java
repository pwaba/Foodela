package com.example.android.myapplication.users;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.android.myapplication.R;

import java.util.ArrayList;

/**
 * Created by peter on 2016-11-28.
 */

public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_obj, parent, false);
        }
        // Lookup view for data population
        TextView nickname = (TextView) convertView.findViewById(R.id.secondLine);
        TextView headline = (TextView) convertView.findViewById(R.id.firstLine);
        RatingBar ratingBar = (RatingBar) convertView.findViewById(R.id.ratingBar);
        ImageView image = (ImageView) convertView.findViewById(R.id.userIcon);
        // Populate the data into the template view using the data object
        nickname.setText(user.getName());
        headline.setText(user.getHeadline());
        ratingBar.setRating(user.getAverageScore());
        image.setImageResource(R.drawable.ic_menu_gallery);
        // Return the completed view to render on screen
        return convertView;
    }
}
