package models;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    public Movie(String name, String format, double rating) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (!format.equalsIgnoreCase("Blue-Ray") && !format.equalsIgnoreCase("DVD")) {
            throw new IllegalArgumentException("Format should either be Blue-Ray or DVD");
        }
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Rating can only be between 1 and 10");
        }
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.isAvailable = true;
        this.rentalPrice = toRentalPrice(format);
        this.sellingPrice = toSellingPrice(format);
        
    }

    public Movie (Movie source) {
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.sellingPrice = source.sellingPrice;
        this.rentalPrice = source.rentalPrice;
        this.isAvailable = source.isAvailable;
    }
    
    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public double getRating() {
        return rating;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
    }

    public void setFormat(String format) {
        if (!format.equalsIgnoreCase("Blue-Ray") && !format.equalsIgnoreCase("DVD")) {
            throw new IllegalArgumentException("Format should either be Blue-Ray or DVD");
        }
        this.format = format;
        setSellingPrice(toSellingPrice(format));
        setRentalPrice(toRentalPrice(format));
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Rating can only be between 1 and 10");
        }
        this.rating = rating;
    }

    private void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    private void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public double toRentalPrice(String format) {
        rentalPrice = this.format.equals("Blue-Ray") ? 1.99 : 0.99;
        return rentalPrice;
    }

    public double toSellingPrice(String format) {
        sellingPrice = this.format.equals("Blue-Ray") ? 4.25 : 2.25;
        return sellingPrice;
    }

    public String toString() {
        return "\t Name: " + this.name + "\n" +
                "\t Format: " + this.format + "\n" +
                "\t Rating: " + this.rating + "\n" +
                "\t Selling Price: " + this.sellingPrice + "\n" +
                "\t Rental Price: " + this.rentalPrice + "\n" +
                "\t Availability: " + (this.isAvailable ? "in-stock" : "rented") + "\n";
    }

}
