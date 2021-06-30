package models;

import java.util.ArrayList;

public class Store {
    ArrayList <Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovies(int index) {
        return new Movie(movies.get(index));
    }

    public void setMovies(int index, Movie movie) {
        this.movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie) {
        this.movies.add(new Movie(movie));
    }

    public void action(String movieName, String action) {
        if (movies.isEmpty()) {
            throw new IllegalStateException("Store not in a valid state to perform action");
        }
        if (!action.equalsIgnoreCase("sell") && !action.equalsIgnoreCase("rent") && !action.equalsIgnoreCase("return")) {
            throw new IllegalArgumentException("INVALID INPUT...");
        }
        if (movieName == null || movieName.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equals(movieName) && action.equals("sell")) {
                if (!(movies.get(i).isAvailable())) {
                    throw new IllegalStateException("Cannot sell movie that was rented!");
                }
                this.movies.remove(i);
            } else if (movies.get(i).getName().equals(movieName) && action.equals("rent")) {
                this.movies.get(i).setAvailable(false);
            } else if (movies.get(i).getName().equals(movieName) && action.equals("return")) {
                this.movies.get(i).setAvailable(true);
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < movies.size(); i++) {
            temp += movies.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }
    
}
