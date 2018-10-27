package Adapter;

/**
 * Created by wolfsoft1 on 31/1/18.
 */

public class ItemDataClass {
    String text;
    Integer imageId;
    public ItemDataClass(String text, Integer imageId){
        this.text=text;
        this.imageId=imageId;
    }

    public ItemDataClass(String text) {
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public Integer getImageId(){
        return imageId;
    }
}
