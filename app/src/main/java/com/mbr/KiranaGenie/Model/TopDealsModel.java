package com.mbr.KiranaGenie.Model;

public class TopDealsModel {

    private String name;
    private String brandname;
    private String item_name;
    private String actual_price;
    private String topdeals_offerprice;

    private int image_drawable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }
    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
    public String getActual_price() {
        return actual_price;
    }

    public void setActual_price(String actual_price) {
        this.actual_price = actual_price;
    }
    public String getTopdeals_offerprice() {
        return topdeals_offerprice;
    }

    public void setTopdeals_offerprice(String topdeals_offerprice) {
        this.topdeals_offerprice = topdeals_offerprice;
    }

    public int getImage_drawable() {
        return image_drawable;
    }

    public void setImage_drawable(int image_drawable) {
        this.image_drawable = image_drawable;
    }
}
