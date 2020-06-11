package model;

import java.util.Date;

public class PaymentDo {
    private Long id;

    private String payType;

    private String currency;

    private Long amount;

    private Long cancelingAmount;

    private Long canceledAmount;

    private String originId;

    private String status;

    private String busiType;

    private String busiOrderNo;

    private String requestNo;

    private String customerId;

    private String toCustomerId;

    private String merchantId;

    private String tranId;

    private String extField;

    private String externalCode;

    private String externalMessage;

    private Date createTime;

    private Date updateTime;

    private Date completeTime;

    private String routeCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getCancelingAmount() {
        return cancelingAmount;
    }

    public void setCancelingAmount(Long cancelingAmount) {
        this.cancelingAmount = cancelingAmount;
    }

    public Long getCanceledAmount() {
        return canceledAmount;
    }

    public void setCanceledAmount(Long canceledAmount) {
        this.canceledAmount = canceledAmount;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId == null ? null : originId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType == null ? null : busiType.trim();
    }

    public String getBusiOrderNo() {
        return busiOrderNo;
    }

    public void setBusiOrderNo(String busiOrderNo) {
        this.busiOrderNo = busiOrderNo == null ? null : busiOrderNo.trim();
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo == null ? null : requestNo.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getToCustomerId() {
        return toCustomerId;
    }

    public void setToCustomerId(String toCustomerId) {
        this.toCustomerId = toCustomerId == null ? null : toCustomerId.trim();
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public String getTranId() {
        return tranId;
    }

    public void setTranId(String tranId) {
        this.tranId = tranId == null ? null : tranId.trim();
    }

    public String getExtField() {
        return extField;
    }

    public void setExtField(String extField) {
        this.extField = extField == null ? null : extField.trim();
    }

    public String getExternalCode() {
        return externalCode;
    }

    public void setExternalCode(String externalCode) {
        this.externalCode = externalCode == null ? null : externalCode.trim();
    }

    public String getExternalMessage() {
        return externalMessage;
    }

    public void setExternalMessage(String externalMessage) {
        this.externalMessage = externalMessage == null ? null : externalMessage.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode == null ? null : routeCode.trim();
    }
}