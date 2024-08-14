package com.entity.vo;

import com.entity.JunazhengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 捐赠信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("junazheng")
public class JunazhengVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 标题
     */

    @TableField(value = "junazheng_name")
    private String junazhengName;


    /**
     * 捐赠类型
     */

    @TableField(value = "junazheng_types")
    private Integer junazhengTypes;


    /**
     * 凭证
     */

    @TableField(value = "junazheng_file")
    private String junazhengFile;


    /**
     * 详情内容
     */

    @TableField(value = "junazheng_text")
    private String junazhengText;


    /**
     * 活动报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 报名状态
     */

    @TableField(value = "junazheng_yesno_types")
    private Integer junazhengYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "junazheng_yesno_text")
    private String junazhengYesnoText;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：标题
	 */
    public String getJunazhengName() {
        return junazhengName;
    }


    /**
	 * 获取：标题
	 */

    public void setJunazhengName(String junazhengName) {
        this.junazhengName = junazhengName;
    }
    /**
	 * 设置：捐赠类型
	 */
    public Integer getJunazhengTypes() {
        return junazhengTypes;
    }


    /**
	 * 获取：捐赠类型
	 */

    public void setJunazhengTypes(Integer junazhengTypes) {
        this.junazhengTypes = junazhengTypes;
    }
    /**
	 * 设置：凭证
	 */
    public String getJunazhengFile() {
        return junazhengFile;
    }


    /**
	 * 获取：凭证
	 */

    public void setJunazhengFile(String junazhengFile) {
        this.junazhengFile = junazhengFile;
    }
    /**
	 * 设置：详情内容
	 */
    public String getJunazhengText() {
        return junazhengText;
    }


    /**
	 * 获取：详情内容
	 */

    public void setJunazhengText(String junazhengText) {
        this.junazhengText = junazhengText;
    }
    /**
	 * 设置：活动报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：活动报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getJunazhengYesnoTypes() {
        return junazhengYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setJunazhengYesnoTypes(Integer junazhengYesnoTypes) {
        this.junazhengYesnoTypes = junazhengYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getJunazhengYesnoText() {
        return junazhengYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setJunazhengYesnoText(String junazhengYesnoText) {
        this.junazhengYesnoText = junazhengYesnoText;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
