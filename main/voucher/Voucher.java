package main.voucher;

import java.time.LocalDateTime;

public abstract class Voucher {
    private int percentDiscount;
    private LocalDateTime expireTime;

    public Voucher(int percentDiscount, LocalDateTime expireTime) {
        this.percentDiscount = percentDiscount;
        this.expireTime = expireTime;
    }

    public int getPercentDiscount() {
        return percentDiscount;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void updateExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
