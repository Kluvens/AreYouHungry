package main.address;

import java.time.LocalDateTime;

public abstract class Address {
    private int id;
    private String stateName;
    private String cityName;
    private String postalCode;
    private String suburbName;
    private String addressDetail;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Address(int id, String stateName, String cityName, 
                    String postalCode, String suburbName, String addressDetail) {
        this.id = id;
        this.stateName = stateName;
        this.cityName = cityName;
        this.postalCode = postalCode;
        this.suburbName = suburbName;
        this.addressDetail = addressDetail;
        this.createTime = LocalDateTime.now();
        this.updateTime = createTime;
    }

    public int getAddressId() {
        return id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getSuburbName() {
        return suburbName;
    }

    public void setSuburbName(String suburbName) {
        this.suburbName = suburbName;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
