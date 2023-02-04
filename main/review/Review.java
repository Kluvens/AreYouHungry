package main.review;

public abstract class Review {
    private int rating;
    private String comments;

    public Review(int rating) {
        this.rating = rating;
        this.comments = null;
    }

    public Review(int rating, String comments) {
        this.rating = rating;
        this.comments = comments;
    }

    public int getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }
}
