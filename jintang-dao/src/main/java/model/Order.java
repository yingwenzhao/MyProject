package model;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Long id;

    private String txType;

    private String mercId;

    private String mercCustId;

    private String channelType;

    private String channelSeqNo;

    private String productCode;

    private String orderTimeOut;

    private BigDecimal orderAmt;

    private BigDecimal refundAmt;

    private String orgOrderNo;

    private String orderStatus;

    private String transId;

    private Date requestTime;

    private Date requestCompleteTime;

    private Date createTime;

    private Date updateTime;

    private String custId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTxType() {
        return txType;
    }

    public void setTxType(String txType) {
        this.txType = txType == null ? null : txType.trim();
    }

    public String getMercId() {
        return mercId;
    }

    public void setMercId(String mercId) {
        this.mercId = mercId == null ? null : mercId.trim();
    }

    public String getMercCustId() {
        return mercCustId;
    }

    public void setMercCustId(String mercCustId) {
        this.mercCustId = mercCustId == null ? null : mercCustId.trim();
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType == null ? null : channelType.trim();
    }

    public String getChannelSeqNo() {
        return channelSeqNo;
    }

    public void setChannelSeqNo(String channelSeqNo) {
        this.channelSeqNo = channelSeqNo == null ? null : channelSeqNo.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getOrderTimeOut() {
        return orderTimeOut;
    }

    public void setOrderTimeOut(String orderTimeOut) {
        this.orderTimeOut = orderTimeOut == null ? null : orderTimeOut.trim();
    }

    public BigDecimal getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(BigDecimal orderAmt) {
        this.orderAmt = orderAmt;
    }

    public BigDecimal getRefundAmt() {
        return refundAmt;
    }

    public void setRefundAmt(BigDecimal refundAmt) {
        this.refundAmt = refundAmt;
    }

    public String getOrgOrderNo() {
        return orgOrderNo;
    }

    public void setOrgOrderNo(String orgOrderNo) {
        this.orgOrderNo = orgOrderNo == null ? null : orgOrderNo.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId == null ? null : transId.trim();
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Date getRequestCompleteTime() {
        return requestCompleteTime;
    }

    public void setRequestCompleteTime(Date requestCompleteTime) {
        this.requestCompleteTime = requestCompleteTime;
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

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }
}