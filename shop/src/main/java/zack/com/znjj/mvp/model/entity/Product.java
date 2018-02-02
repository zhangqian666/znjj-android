package zack.com.znjj.mvp.model.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Administrator on 2018/2/2.
 */

public class Product implements MultiItemEntity {

    /**
     * id : 26
     * categoryId : 100002
     * name : Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机
     * subtitle : iPhone 7，现更以红色呈现。
     * mainImage : 241997c4-9e62-4824-b7f0-7425c3c28917.jpeg
     * price : 6999
     * status : 1
     * imageHost : http://39.106.46.79/images/
     */

    private int id;
    private int categoryId;
    private String name;
    private String subtitle;
    private String mainImage;
    private double price;
    private int status;
    private String imageHost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
