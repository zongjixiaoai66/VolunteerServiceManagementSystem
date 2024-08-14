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
 * 捐赠信息
 *
 * @author 
 * @email
 */
@TableName("junazheng")
public class JunazhengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JunazhengEntity() {

	}

	public JunazhengEntity(T t) {
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
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 标题
     */
    @ColumnInfo(comment="标题",type="varchar(200)")
    @TableField(value = "junazheng_name")

    private String junazhengName;


    /**
     * 捐赠类型
     */
    @ColumnInfo(comment="捐赠类型",type="int(11)")
    @TableField(value = "junazheng_types")

    private Integer junazhengTypes;


    /**
     * 凭证
     */
    @ColumnInfo(comment="凭证",type="varchar(200)")
    @TableField(value = "junazheng_file")

    private String junazhengFile;


    /**
     * 详情内容
     */
    @ColumnInfo(comment="详情内容",type="longtext")
    @TableField(value = "junazheng_text")

    private String junazhengText;


    /**
     * 活动报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="活动报名时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "junazheng_yesno_types")

    private Integer junazhengYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "junazheng_yesno_text")

    private String junazhengYesnoText;


    /**
     * 创建时间  listShow
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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：标题
	 */
    public String getJunazhengName() {
        return junazhengName;
    }
    /**
	 * 设置：标题
	 */

    public void setJunazhengName(String junazhengName) {
        this.junazhengName = junazhengName;
    }
    /**
	 * 获取：捐赠类型
	 */
    public Integer getJunazhengTypes() {
        return junazhengTypes;
    }
    /**
	 * 设置：捐赠类型
	 */

    public void setJunazhengTypes(Integer junazhengTypes) {
        this.junazhengTypes = junazhengTypes;
    }
    /**
	 * 获取：凭证
	 */
    public String getJunazhengFile() {
        return junazhengFile;
    }
    /**
	 * 设置：凭证
	 */

    public void setJunazhengFile(String junazhengFile) {
        this.junazhengFile = junazhengFile;
    }
    /**
	 * 获取：详情内容
	 */
    public String getJunazhengText() {
        return junazhengText;
    }
    /**
	 * 设置：详情内容
	 */

    public void setJunazhengText(String junazhengText) {
        this.junazhengText = junazhengText;
    }
    /**
	 * 获取：活动报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：活动报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getJunazhengYesnoTypes() {
        return junazhengYesnoTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setJunazhengYesnoTypes(Integer junazhengYesnoTypes) {
        this.junazhengYesnoTypes = junazhengYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getJunazhengYesnoText() {
        return junazhengYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setJunazhengYesnoText(String junazhengYesnoText) {
        this.junazhengYesnoText = junazhengYesnoText;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Junazheng{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", junazhengName=" + junazhengName +
            ", junazhengTypes=" + junazhengTypes +
            ", junazhengFile=" + junazhengFile +
            ", junazhengText=" + junazhengText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", junazhengYesnoTypes=" + junazhengYesnoTypes +
            ", junazhengYesnoText=" + junazhengYesnoText +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
