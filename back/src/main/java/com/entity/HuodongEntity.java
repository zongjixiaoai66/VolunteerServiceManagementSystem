package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 志愿活动
 *
 * @author 
 * @email
 */
@TableName("huodong")
public class HuodongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuodongEntity() {

	}

	public HuodongEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 活动编号
     */
    @ColumnInfo(comment="活动编号",type="varchar(200)")
    @TableField(value = "huodong_uuid_number")

    private String huodongUuidNumber;


    /**
     * 活动名称
     */
    @ColumnInfo(comment="活动名称",type="varchar(200)")
    @TableField(value = "huodong_name")

    private String huodongName;


    /**
     * 活动照片
     */
    @ColumnInfo(comment="活动照片",type="varchar(200)")
    @TableField(value = "huodong_photo")

    private String huodongPhoto;


    /**
     * 活动地点
     */
    @ColumnInfo(comment="活动地点",type="varchar(200)")
    @TableField(value = "huodong_address")

    private String huodongAddress;


    /**
     * 活动时间
     */
    @ColumnInfo(comment="活动时间",type="varchar(200)")
    @TableField(value = "huodong_shijian")

    private String huodongShijian;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 活动类型
     */
    @ColumnInfo(comment="活动类型",type="int(11)")
    @TableField(value = "huodong_types")

    private Integer huodongTypes;


    /**
     * 可报名人数
     */
    @ColumnInfo(comment="可报名人数",type="int(11)")
    @TableField(value = "huodong_kucun_number")

    private Integer huodongKucunNumber;


    /**
     * 活动热度
     */
    @ColumnInfo(comment="活动热度",type="int(11)")
    @TableField(value = "huodong_clicknum")

    private Integer huodongClicknum;


    /**
     * 活动状态
     */
    @ColumnInfo(comment="活动状态",type="int(11)")
    @TableField(value = "status_types")

    private Integer statusTypes;


    /**
     * 报名截止时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="报名截止时间",type="timestamp")
    @TableField(value = "jiezhi_time")

    private Date jiezhiTime;


    /**
     * 活动介绍
     */
    @ColumnInfo(comment="活动介绍",type="longtext")
    @TableField(value = "huodong_content")

    private String huodongContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "huodong_delete")

    private Integer huodongDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间     homeMain
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：活动编号
	 */
    public String getHuodongUuidNumber() {
        return huodongUuidNumber;
    }
    /**
	 * 设置：活动编号
	 */

    public void setHuodongUuidNumber(String huodongUuidNumber) {
        this.huodongUuidNumber = huodongUuidNumber;
    }
    /**
	 * 获取：活动名称
	 */
    public String getHuodongName() {
        return huodongName;
    }
    /**
	 * 设置：活动名称
	 */

    public void setHuodongName(String huodongName) {
        this.huodongName = huodongName;
    }
    /**
	 * 获取：活动照片
	 */
    public String getHuodongPhoto() {
        return huodongPhoto;
    }
    /**
	 * 设置：活动照片
	 */

    public void setHuodongPhoto(String huodongPhoto) {
        this.huodongPhoto = huodongPhoto;
    }
    /**
	 * 获取：活动地点
	 */
    public String getHuodongAddress() {
        return huodongAddress;
    }
    /**
	 * 设置：活动地点
	 */

    public void setHuodongAddress(String huodongAddress) {
        this.huodongAddress = huodongAddress;
    }
    /**
	 * 获取：活动时间
	 */
    public String getHuodongShijian() {
        return huodongShijian;
    }
    /**
	 * 设置：活动时间
	 */

    public void setHuodongShijian(String huodongShijian) {
        this.huodongShijian = huodongShijian;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：活动类型
	 */
    public Integer getHuodongTypes() {
        return huodongTypes;
    }
    /**
	 * 设置：活动类型
	 */

    public void setHuodongTypes(Integer huodongTypes) {
        this.huodongTypes = huodongTypes;
    }
    /**
	 * 获取：可报名人数
	 */
    public Integer getHuodongKucunNumber() {
        return huodongKucunNumber;
    }
    /**
	 * 设置：可报名人数
	 */

    public void setHuodongKucunNumber(Integer huodongKucunNumber) {
        this.huodongKucunNumber = huodongKucunNumber;
    }
    /**
	 * 获取：活动热度
	 */
    public Integer getHuodongClicknum() {
        return huodongClicknum;
    }
    /**
	 * 设置：活动热度
	 */

    public void setHuodongClicknum(Integer huodongClicknum) {
        this.huodongClicknum = huodongClicknum;
    }
    /**
	 * 获取：活动状态
	 */
    public Integer getStatusTypes() {
        return statusTypes;
    }
    /**
	 * 设置：活动状态
	 */

    public void setStatusTypes(Integer statusTypes) {
        this.statusTypes = statusTypes;
    }
    /**
	 * 获取：报名截止时间
	 */
    public Date getJiezhiTime() {
        return jiezhiTime;
    }
    /**
	 * 设置：报名截止时间
	 */

    public void setJiezhiTime(Date jiezhiTime) {
        this.jiezhiTime = jiezhiTime;
    }
    /**
	 * 获取：活动介绍
	 */
    public String getHuodongContent() {
        return huodongContent;
    }
    /**
	 * 设置：活动介绍
	 */

    public void setHuodongContent(String huodongContent) {
        this.huodongContent = huodongContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getHuodongDelete() {
        return huodongDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setHuodongDelete(Integer huodongDelete) {
        this.huodongDelete = huodongDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间     homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间     homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Huodong{" +
            ", id=" + id +
            ", huodongUuidNumber=" + huodongUuidNumber +
            ", huodongName=" + huodongName +
            ", huodongPhoto=" + huodongPhoto +
            ", huodongAddress=" + huodongAddress +
            ", huodongShijian=" + huodongShijian +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", huodongTypes=" + huodongTypes +
            ", huodongKucunNumber=" + huodongKucunNumber +
            ", huodongClicknum=" + huodongClicknum +
            ", statusTypes=" + statusTypes +
            ", jiezhiTime=" + DateUtil.convertString(jiezhiTime,"yyyy-MM-dd") +
            ", huodongContent=" + huodongContent +
            ", huodongDelete=" + huodongDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
