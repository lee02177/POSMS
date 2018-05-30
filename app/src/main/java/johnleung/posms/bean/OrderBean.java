package johnleung.posms.bean;

public class OrderBean extends ProductBean {
    private int qty;

    public OrderBean(String prod_nm, int price, int image, String prod_desc, int qty) {
        super(prod_nm, price, image, prod_desc);
        this.qty = qty;
    }

    public OrderBean(ProductBean aProduct, int qty)
    {
        super(aProduct.getProd_nm(), aProduct.getPrice(), aProduct.getImage(), aProduct.getProd_desc());
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
