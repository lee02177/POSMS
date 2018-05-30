package johnleung.posms.bean;

import java.io.Serializable;

public class ProductBean implements Serializable{
    private String prod_nm;
    private int price;
    private int image;
    private String prod_desc;

    public ProductBean(String prod_nm, int price, int image, String prod_desc) {
        this.prod_nm = prod_nm;
        this.price = price;
        this.image = image;
        this.prod_desc = prod_desc;
    }

    public String getProd_nm() {
        return prod_nm;
    }

    public void setProd_nm(String prod_nm) {
        this.prod_nm = prod_nm;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getProd_desc() {
        return prod_desc;
    }

    public void setProd_desc(String prod_desc) {
        this.prod_desc = prod_desc;
    }
}
