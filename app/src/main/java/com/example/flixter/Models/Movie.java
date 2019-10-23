package com.example.flixter.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    double avgVote;

    public Movie(JSONObject jsonObj) throws JSONException {
        posterPath = jsonObj.getString("poster_path");
        title = jsonObj.getString("title");
        overview = jsonObj.getString("overview");
        backdropPath = jsonObj.getString("backdrop_path");
        avgVote = Double.parseDouble(jsonObj.getString("vote_average"));
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException{
        List<Movie> movies = new ArrayList<>();
        for(int i = 0; i<movieJsonArray.length();i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        /*format can append the 2 together, %s marks where to put the second string (posterPath) in the first string*/
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",backdropPath);
    }

    public double getAvgVote() {
        return avgVote;
    }
}
