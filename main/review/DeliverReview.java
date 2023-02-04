package main.review;

import main.person.Deliver;

public class DeliverReview extends Review {
    private Deliver deliver;
    private int rating;

    public DeliverReview(Deliver deliver, int rating) {
        super(rating);
        this.deliver = deliver;
    }

    public DeliverReview(Deliver deliver, int rating, String comments) {
        super(rating, comments);
        this.deliver = deliver;
    }

    public Deliver getDeliver() {
        return deliver;
    }
}
