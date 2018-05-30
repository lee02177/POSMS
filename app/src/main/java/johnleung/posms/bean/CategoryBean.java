package johnleung.posms.bean;

public class CategoryBean {
    private int images;
    private String cate_nm;

    public CategoryBean(String cate_nm, int images)
    {
        this.cate_nm = cate_nm;
        this.images = images;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getCate_nm() {
        return cate_nm;
    }

    public void setCate_nm(String cate_nm) {
        this.cate_nm = cate_nm;
    }
}
