package cn.edu.hziee.model;

import java.io.Serializable;

/**
 * collection_info
 * @author 
 */
public class CollectionInfo implements Serializable {
    private Integer id;

    private Integer shopId;

    private Integer userId;

    private String colDate;

    private Integer colState;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getColDate() {
        return colDate;
    }

    public void setColDate(String colDate) {
        this.colDate = colDate;
    }

    public Integer getColState() {
        return colState;
    }

    public void setColState(Integer colState) {
        this.colState = colState;
    }
}