package com.entity.model;

import com.entity.JunazhengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 捐赠信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JunazhengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 标题
     */
    private String junazhengName;


    /**
     * 捐赠类型
     */
    private Integer junazhengTypes;


    /**
     * 凭证
     */
    private String junazhengFile;


    /**
     * 详情内容
     */
    private String junazhengText;


    /**
     * 活动报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 报名状态
     */
    private Integer junazhengYesnoTypes;


    /**
     * 审核回复
     */
    private String junazhengYesnoText;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
