import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.Movie;
import models.Store;

public class Main {
    static Store store = new Store();
    public static void main(String[] args) {
        System.out.println("\n********************JAVA VIDEO STORE********************\n");
        try {
            loadMovies("movies.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(store);
            manageMovies();
        }
    }

    public static void manageMovies() {
        Scanner scan = new Scanner(System.in);
        boolean value = true;
        while (value) {
            System.out.println("Kindly choose \n\ta. Purchase \n\tb. rent \n\tc. return \n\td. exit");
            String userChoice = scan.nextLine();
            switch (userChoice) {
                case "a":
                    System.out.println("What is the name of the movie you want to purchase");
                    if (scan.nextLine().isBlank()) {
                        System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                        continue;
                    } else {
                        store.action(scan.nextLine(), "sell");
                        System.out.println("\n\nUPDATED MOVIES\n\n" + store);
                        continue;
                    }
                    
                case "b":
                    System.out.println("What is the name of the movie you want to rent");
                    store.action(scan.nextLine(), "rent");
                    System.out.println("\n\nUPDATED MOVIES\n\n" + store);
                    continue;
                case "c":
                    System.out.println("What is the name of the movie you want to return");
                    store.action(scan.nextLine(), "return");
                    System.out.println("\n\nUPDATED MOVIES\n\n" + store);
                    continue;
                case "d":
                    value = false;
                    return;
            }
        }
        scan.close();
    }

     public static void loadMovies(String fileName) throws FileNotFoundException {       
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scan = new Scanner(fis);
        while (scan.hasNextLine()) {
            String[] words = scan.nextLine().split("--");
            store.addMovie(new Movie(words[0], words[1], Double.parseDouble(words[2])));
        }
        scan.close();

     }

}
