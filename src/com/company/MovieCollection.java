package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*  MovieCollection builds ArrayList of Movie objects
    Provides structure for user interaction with collection movies
 */

public class MovieCollection {
    private ArrayList<Movie> collection;

    public MovieCollection() {
        this.collection = new ArrayList<Movie>();
        stockCollection();
    }
    public void addMovie(Movie movie){
        this.collection.add(movie);
    }

    //Returns ArrayList of entire movie collection
    public ArrayList<Movie> getCollection() {
        return collection;
    }

    public void setCollection(ArrayList<Movie> collection) {
        this.collection = collection;
    }

    public void viewSorted(){
        this.collection
                .stream()
                .sorted(Comparator.comparing(Movie::getCategory).thenComparing(Movie::getTitle))
                .forEach(this::printMovie);

        }

    /*  New viewByCategory method using lambda expressions to filter sort and print.
        How to correct if no results match?
        @param category allows user to find Movie objects that match specified category within the MovieCollection
     */

    public void viewSortedCategory (String category) {


        this.collection
                .stream()
                //filters the colletion down to only those Movie objects whose category matches specified category
                .filter(x -> x.getCategory().equalsIgnoreCase(category))
                //sorts by title alphabetically
                .sorted(Comparator.comparing(Movie::getTitle))
               // .sorted((x1, x2) -> x1.getTitle().compareTo(x2.getTitle()))
                .forEach(this::printMovie);
                //.forEach(x -> printMovie(x));
    }


        /*
        ArrayList<Movie> byCategory = new ArrayList<Movie>();

        for (Movie movie : this.collection) {
            if (movie.getCategory().equalsIgnoreCase(category)) {
                byCategory.add(movie);
            }
        }

        */





    public void viewByCategory(String category) {
        boolean check = false;


        for (Movie movie : this.collection) {
            if (movie.getCategory().equalsIgnoreCase(category)) {
                printMovie(movie);
                check = true;
            }
        }
        if (!check) {
            System.out.println("No movies available for this category!");
        }

    }

    public void printMovie(Movie movie){
        System.out.println(movie.toString());
    }

    public void printMovieCollection(){
        for(Movie movie: this.collection){
            printMovie(movie);
        }
    }


    // Uses MovieIO class to populate MovieCollection with a stock this of movies

    public void stockCollection(){

        for(int i = 1; i <= 100; i++){
            this.collection.add(MovieIO.getMovie(i));
        }
    }
}
