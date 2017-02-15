package com.company;

public class Movie {
    private String title;
    private String category;

    public Movie(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    //Overridden method to print formatted string with movie title and category
    @Override
    public String toString(){
        return String.format("%-40s%-15s", title, category);
    }


}
