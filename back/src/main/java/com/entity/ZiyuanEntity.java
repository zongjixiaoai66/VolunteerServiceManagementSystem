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
 * 志愿资源
 *
 * @author 
 * @email
 */
@TableName("ziyuan")
public class ZiyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZiyuanEntity() {

	}

	public ZiyuanEntity(T t) {
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
     * 资源编号
     */
    @ColumnInfo(comment="资源编号",type="varchar(200)")
    @TableField(value = "ziyuan_uuid_number")

    private String ziyuanUuidNumber;


    /**
     * 资源名称
     */
    @ColumnInfo(comment="资源名称",type="varchar(200)")
    @TableField(value = "ziyuan_name")

    private String ziyuanName;


    /**
     * 资源照片
     */
    @ColumnInfo(comment="资源照片",type="varchar(200)")
    @TableField(value = "ziyuan_photo")

    private String ziyuanPhoto;


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
     * 资源类型
     */
    @ColumnInfo(comment="资源类型",type="int(11)")
    @TableField(value = "ziyuan_types")

    private Integer ziyuanTypes;


    /**
     * 资源介绍
     */
    @ColumnInfo(comment="资源介绍",type="longtext")
    @TableField(value = "ziyuan_content")

    private String ziyuanContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "ziyuan_delete")

    private Integer ziyuanDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：资源编号
	 */
    public String getZiyuanUuidNumber() {
        return ziyuanUuidNumber;
    }
    /**
	 * 设置：资源编号
	 */

    public void setZiyuanUuidNumber(String ziyuanUuidNumber) {
        this.ziyuanUuidNumber = ziyuanUuidNumber;
    }
    /**
	 * 获取：资源名称
	 */
    public String getZiyuanName() {
        return ziyuanName;
    }
    /**
	 * 设置：资源名称
	 */

    public void setZiyuanName(String ziyuanName) {
        this.ziyuanName = ziyuanName;
    }
    /**
	 * 获取：资源照片
	 */
    public String getZiyuanPhoto() {
        return ziyuanPhoto;
    }
    /**
	 * 设置：资源照片
	 */

    public void setZiyuanPhoto(String ziyuanPhoto) {
        this.ziyuanPhoto = ziyuanPhoto;
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
	 * 获取：资源类型
	 */
    public Integer getZiyuanTypes() {
        return ziyuanTypes;
    }
    /**
	 * 设置：资源类型
	 */

    public void setZiyuanTypes(Integer ziyuanTypes) {
        this.ziyuanTypes = ziyuanTypes;
    }
    /**
	 * 获取：资源介绍
	 */
    public String getZiyuanContent() {
        return ziyuanContent;
    }
    /**
	 * 设置：资源介绍
	 */

    public void setZiyuanContent(String ziyuanContent) {
        this.ziyuanContent = ziyuanContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getZiyuanDelete() {
        return ziyuanDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setZiyuanDelete(Integer ziyuanDelete) {
        this.ziyuanDelete = ziyuanDelete;
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
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Ziyuan{" +
            ", id=" + id +
            ", ziyuanUuidNumber=" + ziyuanUuidNumber +
            ", ziyuanName=" + ziyuanName +
            ", ziyuanPhoto=" + ziyuanPhoto +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", ziyuanTypes=" + ziyuanTypes +
            ", ziyuanContent=" + ziyuanContent +
            ", ziyuanDelete=" + ziyuanDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
