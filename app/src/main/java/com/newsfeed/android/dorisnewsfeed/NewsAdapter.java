package com.newsfeed.android.dorisnewsfeed;


import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by dori on 28.05.2018.
 */

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.newsfeed_list_item, parent, false);
        }

        // Find the news at the given position in the list of news
        News currentNews = getItem(position);
        String currentTitle = currentNews.getTitle();
        String currentDate = currentNews.getDate();
        String currentCategory = currentNews.getCategory();
        String currentUrl = currentNews.getUrl();
        String currentAuthors=currentNews.getAuthor();

        //find the TextView with the id news_title
        TextView titleView = (TextView) listItemView.findViewById(R.id.news_title);
        titleView.setText(currentTitle);

        //find the TextView with the ID category
        TextView categoryView = (TextView) listItemView.findViewById(R.id.category);
        categoryView.setText(currentCategory);

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Display the date of the current news in that TextView
        dateView.setText(currentDate);

        TextView urlView = (TextView) listItemView.findViewById(R.id.url);
        urlView.setText(currentUrl);

        TextView authorsView = (TextView) listItemView.findViewById(R.id.authors_text_view);
        authorsView.setText(currentAuthors);

        // Set the color on the news background and the title TextView
        GradientDrawable categoryCircle = (GradientDrawable) categoryView.getBackground();

        // Get the appropriate background color based on the current news category
        int categoryColor = getCategoryColor(currentNews.getCategory());

        // Set the color on the magnitude circle
        categoryCircle.setColor(categoryColor);
        titleView.setTextColor(categoryColor);

        // Return the list item view that is now showing the appropriate data
        return listItemView;

    }

    private int getCategoryColor(String category) {
        int categoryColorResourceId;
        switch (category) {
            case "News":
                categoryColorResourceId = R.color.global;
                break;
            case "Politics":
                categoryColorResourceId = R.color.art;
                break;
            case "Society":
                categoryColorResourceId = R.color.life;
                break;
            case "Science":
                categoryColorResourceId = R.color.footbal;
                break;
            case "Music":
                categoryColorResourceId = R.color.film;
                break;
            case "Technology":
                categoryColorResourceId = R.color.career;
                break;
            case "Culture":
                categoryColorResourceId = R.color.culture;
                break;
            case "World news":
                categoryColorResourceId = R.color.world;
                break;
            case "Business":
                categoryColorResourceId = R.color.business;
                break;
            case "Environment":
                categoryColorResourceId = R.color.envir;
                break;
            case "From the Guardian":
                categoryColorResourceId = R.color.fromguard;
                break;
            case "US news":
                categoryColorResourceId = R.color.us;
                break;
            case "UK news":
                categoryColorResourceId = R.color.uk;
                break;
            default:
                categoryColorResourceId = R.color.global;
                break;
        }
        return ContextCompat.getColor(getContext(), categoryColorResourceId);
    }
}
