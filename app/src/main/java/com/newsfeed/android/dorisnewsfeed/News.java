package com.newsfeed.android.dorisnewsfeed;

/**
 * Created by dori on 28.05.2018.
 */

public class News {

    private String mTitle;
    private String mDate;
    private String mCategory;
    private String mUrl;
    private String mAuthor;

    /**
     * @param title    represents the title of the news
     * @param category represents the category of the news
     * @param date     the date when the news was published
     * @param url      the website URL to find more details about the news
     */
    public News(String title, String date, String category, String url,String author) {
        mTitle = title;
        mDate = date;
        mCategory = category;
        mUrl = url;
        mAuthor=author;
    }

    /*
    *return the title of the news
     */
    public String getTitle() {
        return mTitle;
    }

    /*
    * return the date of the news
    */
    public String getDate() {
        return mDate;
    }

    /*
    *return the category of the news
     */
    public String getCategory() {
        return mCategory;
    }

    /*
    *return the url of the news
     */
    public String getUrl() {
        return mUrl;
    }

    public String getAuthor(){
        return mAuthor;
    }

}
