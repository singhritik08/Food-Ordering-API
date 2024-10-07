package com.example.Fms.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateOrderStatusReq {
    private int orderId;
    private String status;
}
