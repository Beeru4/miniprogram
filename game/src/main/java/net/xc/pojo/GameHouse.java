package net.xc.pojo;


/**
 * 房屋
 */
public class GameHouse {

    private Integer id;
    private String region;
    private Integer typeId;
    private double price;
    private double prices;
    private double goodDegrees;

    public GameHouse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    public double getGoodDegrees() {
        return goodDegrees;
    }

    public void setGoodDegrees(double goodDegrees) {
        this.goodDegrees = goodDegrees;
    }
}
