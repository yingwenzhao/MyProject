package model;

import java.util.Date;

public class PaytoolsDo {
    private Long id;

    private Long paymentId;

    private String payTool;

    private String payToolName;

    private Long amount;

    private String currency;

    private String payToolExt;

    private String extField;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getPayTool() {
        return payTool;
    }

    public void setPayTool(String payTool) {
        this.payTool = payTool == null ? null : payTool.trim();
    }

    public String getPayToolName() {
        return payToolName;
    }

    public void setPayToolName(String payToolName) {
        this.payToolName = payToolName == null ? null : payToolName.trim();
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getPayToolExt() {
        return payToolExt;
    }

    public void setPayToolExt(String payToolExt) {
        this.payToolExt = payToolExt == null ? null : payToolExt.trim();
    }

    public String getExtField() {
        return extField;
    }

    public void setExtField(String extField) {
        this.extField = extField == null ? null : extField.trim();
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
}