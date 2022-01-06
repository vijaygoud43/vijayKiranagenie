package com.mbr.KiranaGenie.Model;

import java.util.ArrayList;
import java.util.List;

public class ProductfullDetailsResponseModel {
    private List<PRODUCTFULLDETAILS> data= new ArrayList<>();
    public List<PRODUCTFULLDETAILS> getfulldetails() {
        return data;
    }



    public class PRODUCTFULLDETAILS{
int id,getProduct_id;

        String  name,manufacturer,model,image,mrpprice,price,rating,description,quantity;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getGetProduct_id() {
            return getProduct_id;
        }

        public void setGetProduct_id(int getProduct_id) {
            this.getProduct_id = getProduct_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
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

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }



    }

}
