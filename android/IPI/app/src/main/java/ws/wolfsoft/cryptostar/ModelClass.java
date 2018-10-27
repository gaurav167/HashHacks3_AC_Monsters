package ws.wolfsoft.cryptostar;

/**
 * Created by wolfsoft1 on 24/3/18.
 */

public class ModelClass {
    String iteamName,price;

    public ModelClass(String iteamName, String price) {
        this.iteamName = iteamName;
        this.price = price;
    }

    public String getIteamName() {
        return iteamName;
    }

    public void setIteamName(String iteamName) {
        this.iteamName = iteamName;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
