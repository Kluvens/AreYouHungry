package main.order;

import java.time.LocalDateTime;

public class CompletedOrder extends Order {
    private LocalDateTime checkoutTime;
    private String paymentMethod;

    public CompletedOrder(PendingOrder pendingOrder, LocalDateTime time, String method) {
        super(pendingOrder.getId(), pendingOrder.getCustomerId(), pendingOrder.getRestaurantId(), 
            pendingOrder.getReceivingAddress(), pendingOrder.getOrderTime(), pendingOrder.getTotalPrice(), pendingOrder.getRemark());
        this.checkoutTime = time;
        this.paymentMethod = method;
    }

    public LocalDateTime getCheckoutTime() {
        return checkoutTime;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
