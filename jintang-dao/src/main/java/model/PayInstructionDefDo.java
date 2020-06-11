package model;

import java.util.Date;

public class PayInstructionDefDo {
    private Long id;

    private String payType;

    private String payTypeDesc;

    private String outTransType;

    private String payTool;

    private String channel;

    private String payToolName;

    private Integer sectionNo;

    private Integer position;

    private String instruction;

    private String forwardDefId;

    private Date createTime;

    private Date updateTime;

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

    public String getPayTypeDesc() {
        return payTypeDesc;
    }

    public void setPayTypeDesc(String payTypeDesc) {
        this.payTypeDesc = payTypeDesc == null ? null : payTypeDesc.trim();
    }

    public String getOutTransType() {
        return outTransType;
    }

    public void setOutTransType(String outTransType) {
        this.outTransType = outTransType == null ? null : outTransType.trim();
    }

    public String getPayTool() {
        return payTool;
    }

    public void setPayTool(String payTool) {
        this.payTool = payTool == null ? null : payTool.trim();
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getPayToolName() {
        return payToolName;
    }

    public void setPayToolName(String payToolName) {
        this.payToolName = payToolName == null ? null : payToolName.trim();
    }

    public Integer getSectionNo() {
        return sectionNo;
    }

    public void setSectionNo(Integer sectionNo) {
        this.sectionNo = sectionNo;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction == null ? null : instruction.trim();
    }

    public String getForwardDefId() {
        return forwardDefId;
    }

    public void setForwardDefId(String forwardDefId) {
        this.forwardDefId = forwardDefId == null ? null : forwardDefId.trim();
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