package net.xc.pojo;

/**
 * 仓库
 */
public class Warehouse {

    private Integer id;
    private Integer userId;
    private Integer fintmentId;
    private Integer num;

    public Warehouse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFintmentId() {
        return fintmentId;
    }

    public void setFintmentId(Integer fintmentId) {
        this.fintmentId = fintmentId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
