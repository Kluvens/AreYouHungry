package main.order;

import java.time.LocalDateTime;

import main.person.Deliver;
import main.voucher.Voucher;

public class CompletedOrder extends Order {
    private Deliver deliver;
    private LocalDateTime checkoutTime;
    private String paymentMethod;
    private OrderStatus orderStatus;
    private Voucher voucher;
    private double finalPrice;

    public CompletedOrder(PendingOrder pendingOrder, LocalDateTime time, String method) {
        super(pendingOrder.getId(), pendingOrder.getCustomerId(), pendingOrder.getRestaurantId(), 
            pendingOrder.getReceivingAddress(), pendingOrder.getOrderTime(), pendingOrder.getTotalPrice(), pendingOrder.getRemark());
        this.checkoutTime = time;
        this.paymentMethod = method;
        this.finalPrice = this.getTotalPrice();
    }

    public CompletedOrder(PendingOrder pendingOrder, LocalDateTime time, String method, Voucher voucher) {
        super(pendingOrder.getId(), pendingOrder.getCustomerId(), pendingOrder.getRestaurantId(), 
            pendingOrder.getReceivingAddress(), pendingOrder.getOrderTime(), pendingOrder.getTotalPrice(), pendingOrder.getRemark());
        this.checkoutTime = time;
        this.paymentMethod = method;
        this.voucher = voucher;
        this.finalPrice = this.getTotalPrice()*(voucher.getPercentDiscount()/100);
    }

    public Deliver getDeliver() {
        return deliver;
    }

    public void assignDeliver(Deliver deliver) {
        this.deliver = deliver;
        orderStatus = OrderStatus.PICKING_UP;
    }

    public LocalDateTime getCheckoutTime() {
        return checkoutTime;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void pickupFood() {
        orderStatus = OrderStatus.OUT_FOR_DELIVERY;
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

    public Voucher getVoucher() {
        return voucher;
    }

    @Override
    public double getTotalPrice() {
        return finalPrice;
    }
}
