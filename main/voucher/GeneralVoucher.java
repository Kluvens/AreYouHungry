package main.voucher;

import java.time.LocalDateTime;

public class GeneralVoucher extends Voucher {
    public GeneralVoucher(int percentDiscount, LocalDateTime expireTime) {
        super(percentDiscount, expireTime);
    }
}
