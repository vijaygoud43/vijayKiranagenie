package com.mbr.KiranaGenie.data.request;

import java.io.Serializable;

public class AddCartRequest implements Serializable {
    String product_id;
    String quantity;

    public AddCartRequest(String product_id, String quantity) {
        this.product_id = product_id;
        this.quantity = quantity;
    }

}
