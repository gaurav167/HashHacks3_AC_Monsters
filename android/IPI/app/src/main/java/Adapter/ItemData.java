package Adapter;

/**
 * Created by wolfsoft1 on 31/1/18.
 */

public class ItemData {
    String text;
    Integer imageId;
    public ItemData(String text, Integer imageId){
        this.text=text;
        this.imageId=imageId;
    }

    public ItemData(String text) {
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public Integer getImageId(){
        return imageId;
    }
}
