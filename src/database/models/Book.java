package database.models;


import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
    //自增id
    private long id;
    //书名
    private String name;
    //价格
    private float prices;
    //剩余总量
    private long count;
    //显示顺序
    private long order;
    //是否显示
    private boolean hidden;
    //书本类型对应id
    private long booktypeid;
    //书类型名
    private String booktypename;
    private Date createAt;
    private Date updateAt;

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getBooktypename() {
        return booktypename;
    }
    public void setBooktypename(String booktypename) {
        this.booktypename = booktypename;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPrices() {
        return prices;
    }
    public void setPrices(float prices) {
        this.prices = prices;
    }
    public long getCount() {
        return count;
    }
    public void setCount(long count) {
        this.count = count;
    }
    public long getOrder() {
        return order;
    }
    public void setOrder(long order) {
        this.order = order;
    }
    public boolean isHidden() {
        return hidden;
    }
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    public long getBooktypeid() {
        return booktypeid;
    }
    public void setBooktypeid(long booktypeid) {
        this.booktypeid = booktypeid;
    }
}
