package com.mbr.KiranaGenie.Model;

public class CategoryResponseModelClass {
    int category_id;
    private String parent_id, name, image;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public CategoryResponseModelClass(int category_id, String parent_id, String name, String image) {
        this.category_id = category_id;
        this.parent_id = parent_id;
        this.name = name;
        this.image = image;
    }
}
