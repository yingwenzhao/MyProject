package model;

import java.util.Date;

public class PayInstructionDo {
    private Long id;

    private String instructionType;

    private Integer executeSeq;

    private Integer position;

    private Integer sectionNo;

    private Long paymentId;

    private String instruction;

    private String payType;

    private String payTool;

    private String payToolName;

    private String outTransId;

    private String originalOutTransId;

    private String originalId;

    private Long amount;

    private Long cancelingAmount;

    private Long canceledAmount;

    private Long paytoolsId;

    private String currency;

    private String status;

    private String externalCode;

    private String externalMessage;

    private String channel;

    private Long defId;

    private Long refundDefId;

    private String outTransType;

    private String outPayDetails;

    private String extFields;

    private Date createTime;

    private Date updateTime;

    private Date completeTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstructionType() {
        return instructionType;
    }

    public void setInstructionType(String instructionType) {
        this.instructionType = instructionType == null ? null : instructionType.trim();
    }

    public Integer getExecuteSeq() {
        return executeSeq;
    }

    public void setExecuteSeq(Integer executeSeq) {
        this.executeSeq = executeSeq;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getSectionNo() {
        return sectionNo;
    }

    public void setSectionNo(Integer sectionNo) {
        this.sectionNo = sectionNo;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction == null ? null : instruction.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
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

    public String getOutTransId() {
        return outTransId;
    }

    public void setOutTransId(String outTransId) {
        this.outTransId = outTransId == null ? null : outTransId.trim();
    }

    public String getOriginalOutTransId() {
        return originalOutTransId;
    }

    public void setOriginalOutTransId(String originalOutTransId) {
        this.originalOutTransId = originalOutTransId == null ? null : originalOutTransId.trim();
    }

    public String getOriginalId() {
        return originalId;
    }

    public void setOriginalId(String originalId) {
        this.originalId = originalId == null ? null : originalId.trim();
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

    public Long getPaytoolsId() {
        return paytoolsId;
    }

    public void setPaytoolsId(Long paytoolsId) {
        this.paytoolsId = paytoolsId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public Long getDefId() {
        return defId;
    }

    public void setDefId(Long defId) {
        this.defId = defId;
    }

    public Long getRefundDefId() {
        return refundDefId;
    }

    public void setRefundDefId(Long refundDefId) {
        this.refundDefId = refundDefId;
    }

    public String getOutTransType() {
        return outTransType;
    }

    public void setOutTransType(String outTransType) {
        this.outTransType = outTransType == null ? null : outTransType.trim();
    }

    public String getOutPayDetails() {
        return outPayDetails;
    }

    public void setOutPayDetails(String outPayDetails) {
        this.outPayDetails = outPayDetails == null ? null : outPayDetails.trim();
    }

    public String getExtFields() {
        return extFields;
    }

    public void setExtFields(String extFields) {
        this.extFields = extFields == null ? null : extFields.trim();
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
}