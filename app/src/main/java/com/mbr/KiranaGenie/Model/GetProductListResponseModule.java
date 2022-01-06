package com.mbr.KiranaGenie.Model;

import java.util.ArrayList;
import java.util.List;

public class GetProductListResponseModule {
    private List<GetProductListResponseModule.GETPRODUCTLIST> data= new ArrayList<>();
    public List<GetProductListResponseModule.GETPRODUCTLIST> getproductlistList() {
        return data;
    }

    public class GETPRODUCTLIST{
        int category_id;
        int product_id;
        private String  name,manufacturer, image,mrpprice,price,minimum;



        public void setId(int id) {
            this.category_id = id;
        }

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMinimum() {
            return minimum;
        }

        public void setMinimum(String minimum) {
            this.minimum = minimum;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getMrpprice() {
            return mrpprice;
        }

        public void setMrpprice(String mrpprice) {
            this.mrpprice = mrpprice;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
