package com.mbr.KiranaGenie.Model;

public class Catallitems {
    private int catimage_id;
    private String text;

    public int getCatimage_id()
    {
        return catimage_id;
    }

    public void setImage_id(int catimage_id)
    {
        this.catimage_id = catimage_id;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public Catallitems(int img, String text)
    {
        catimage_id = img;
        this.text = text;
    }
}
