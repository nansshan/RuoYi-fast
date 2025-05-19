package com.ruoyi.project.system.records.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * birds对象 bird_records
 * 
 * @author ruoyi
 * @date 2025-05-19
 */
public class BirdRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private Long id;

    /** 鸟种 */
    @Excel(name = "鸟种")
    private String birdSpecies;

    /** 品种 */
    @Excel(name = "品种")
    private String variety;

    /** 脚环编号 */
    @Excel(name = "脚环编号")
    private String legBandNumber;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 鉴定日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "鉴定日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date identificationDate;

    /** APV检测结果 */
    @Excel(name = "APV检测结果")
    private String apvResult;

    /** PBFD检测结果 */
    @Excel(name = "PBFD检测结果")
    private String pbfdResult;

    /** 查询号 */
    @Excel(name = "查询号")
    private String searchNumb;

    /** 送检人 */
    @Excel(name = "送检人")
    private String senderName;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setBirdSpecies(String birdSpecies) 
    {
        this.birdSpecies = birdSpecies;
    }

    public String getBirdSpecies() 
    {
        return birdSpecies;
    }

    public void setVariety(String variety) 
    {
        this.variety = variety;
    }

    public String getVariety() 
    {
        return variety;
    }

    public void setLegBandNumber(String legBandNumber) 
    {
        this.legBandNumber = legBandNumber;
    }

    public String getLegBandNumber() 
    {
        return legBandNumber;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setIdentificationDate(Date identificationDate) 
    {
        this.identificationDate = identificationDate;
    }

    public Date getIdentificationDate() 
    {
        return identificationDate;
    }

    public void setApvResult(String apvResult) 
    {
        this.apvResult = apvResult;
    }

    public String getApvResult() 
    {
        return apvResult;
    }

    public void setPbfdResult(String pbfdResult) 
    {
        this.pbfdResult = pbfdResult;
    }

    public String getPbfdResult() 
    {
        return pbfdResult;
    }

    public void setSearchNumb(String searchNumb) 
    {
        this.searchNumb = searchNumb;
    }

    public String getSearchNumb() 
    {
        return searchNumb;
    }

    public void setSenderName(String senderName) 
    {
        this.senderName = senderName;
    }

    public String getSenderName() 
    {
        return senderName;
    }

    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("birdSpecies", getBirdSpecies())
            .append("variety", getVariety())
            .append("legBandNumber", getLegBandNumber())
            .append("gender", getGender())
            .append("identificationDate", getIdentificationDate())
            .append("apvResult", getApvResult())
            .append("pbfdResult", getPbfdResult())
            .append("searchNumb", getSearchNumb())
            .append("senderName", getSenderName())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
