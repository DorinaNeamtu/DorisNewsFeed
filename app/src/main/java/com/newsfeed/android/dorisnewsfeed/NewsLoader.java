package com.newsfeed.android.dorisnewsfeed;

import java.util.List;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;


/**
 * Created by dori on 28.05.2018.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {
    /**
     * Tag for log messages
     */
    public static final String LOG_TAG = NewsActivity.class.getName();

    /**
     * Query URL
     */
    private String mUrl;

    /**
     * Constructs a new {@link NewsLoader}.
     *
     * @param context of the activity
     * @param url     to load data from
     */
    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG, "Test:onStartLoading() method called:... ");
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<News> loadInBackground() {
        Log.i(LOG_TAG, "Test:loadinBackground() method called:... ");
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of news.
        List<News> news = QueryUtils.fetchNewsData(mUrl);
        return news;
    }
}
