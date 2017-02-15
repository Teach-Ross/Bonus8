package com.company;

import java.util.Collections;

public class MovieApp {

    public static void printCategoryMenu(){
        System.out.println("1: Animated\n2: Drama\n3: Horror\n4: Sci-Fi");
    }

    public static void main(String[] args) {
        MovieCollection movieList = new MovieCollection();
        String userString;
        int userNum;
        boolean continueLoop = true;

        while(continueLoop) {

            printCategoryMenu();
            userNum = Validate.validateInt("Select a category (1-4)", 1, 4);
            switch (userNum) {
                case 1:
                    movieList.viewSortedCategory("animated");
                    break;
                case 2:
                    movieList.viewSortedCategory("drama");
                    break;
                case 3:
                    movieList.viewSortedCategory("horror");
                    break;
                case 4:
                    movieList.viewSortedCategory("scifi");
            }
            userString = Validate.validateYesOrNo("Would you like to return to main menu? (Y/N) ");
            if (userString.equalsIgnoreCase("n")) {
                continueLoop = false;
            }
        }
        movieList.viewSorted();


    }
}
