package main.order;

import java.time.LocalDateTime;

import main.person.Deliver;

public class CompletedOrder extends Order {
    private Deliver deliver;
    private LocalDateTime checkoutTime;
    private String paymentMethod;
    private OrderStatus orderStatus;

    public CompletedOrder(PendingOrder pendingOrder, LocalDateTime time, String method) {
        super(pendingOrder.getId(), pendingOrder.getCustomerId(), pendingOrder.getRestaurantId(), 
            pendingOrder.getReceivingAddress(), pendingOrder.getOrderTime(), pendingOrder.getTotalPrice(), pendingOrder.getRemark());
        this.checkoutTime = time;
        this.paymentMethod = method;
    }

    public Deliver getDeliver() {
        return deliver;
    }

    public void assignDeliver(Deliver deliver) {
        this.deliver = deliver;
        orderStatus = OrderStatus.OUT_FOR_DELIVERY;
    }

    public LocalDateTime getCheckoutTime() {
        return checkoutTime;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void finishDelivery() {
        orderStatus = OrderStatus.DELIVERED;
    }

    public void cancelOrder() {
        orderStatus = OrderStatus.CANCELLED;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}
