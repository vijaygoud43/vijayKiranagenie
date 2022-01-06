package com.mbr.KiranaGenie.Model;

import java.util.ArrayList;
import java.util.List;

public class AllCategoryResponseModule {

    private List<ALLCATEGORIES> data=new ArrayList<>();
    public List<AllCategoryResponseModule.ALLCATEGORIES> getallcatdata() {
        return data;
    }
    public class ALLCATEGORIES   {
        int category_id;
        private String parent_id, name, image;

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
    }




    }