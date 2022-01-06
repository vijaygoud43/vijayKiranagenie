package com.mbr.KiranaGenie.Model;

public class SubCategoriesResponse {
    private int reward_image_id;
    private String reward_text;

    public int getReward_image_id()
    {
        return reward_image_id;
    }

    public void setReward_image_id(int reward_image_id)
    {
        this.reward_image_id = reward_image_id;
    }

    public String getReward_text()
    {
        return reward_text;
    }

    public void setText(String reward_text)
    {
        this.reward_text = reward_text;
    }

    public SubCategoriesResponse(int img, String text)
    {
        reward_image_id = img;
        this.reward_text = text;
    }
}
