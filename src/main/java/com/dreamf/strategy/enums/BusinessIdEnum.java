package com.dreamf.strategy.enums;

/**
 * your businessId
 * @author lmj
 */
public enum BusinessIdEnum {

    YOUR_BUSINESS_ID(0);
    
    private Integer businessId;
    
    public Integer getBusinessId() {
        return businessId;
    }
    
    private BusinessIdEnum(Integer businessId) {
        this.businessId=businessId;
    }
}
