package com.entity.vo;

import com.entity.ZiyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 志愿资源
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("ziyuan")
public class ZiyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 资源编号
     */

    @TableField(value = "ziyuan_uuid_number")
    private String ziyuanUuidNumber;


    /**
     * 资源名称
     */

    @TableField(value = "ziyuan_name")
    private String ziyuanName;


    /**
     * 资源照片
     */

    @TableField(value = "ziyuan_photo")
    private String ziyuanPhoto;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 资源类型
     */

    @TableField(value = "ziyuan_types")
    private Integer ziyuanTypes;


    /**
     * 资源介绍
     */

    @TableField(value = "ziyuan_content")
    private String ziyuanContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "ziyuan_delete")
    private Integer ziyuanDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：资源编号
	 */
    public String getZiyuanUuidNumber() {
        return ziyuanUuidNumber;
    }


    /**
	 * 获取：资源编号
	 */

    public void setZiyuanUuidNumber(String ziyuanUuidNumber) {
        this.ziyuanUuidNumber = ziyuanUuidNumber;
    }
    /**
	 * 设置：资源名称
	 */
    public String getZiyuanName() {
        return ziyuanName;
    }


    /**
	 * 获取：资源名称
	 */

    public void setZiyuanName(String ziyuanName) {
        this.ziyuanName = ziyuanName;
    }
    /**
	 * 设置：资源照片
	 */
    public String getZiyuanPhoto() {
        return ziyuanPhoto;
    }


    /**
	 * 获取：资源照片
	 */

    public void setZiyuanPhoto(String ziyuanPhoto) {
        this.ziyuanPhoto = ziyuanPhoto;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：资源类型
	 */
    public Integer getZiyuanTypes() {
        return ziyuanTypes;
    }


    /**
	 * 获取：资源类型
	 */

    public void setZiyuanTypes(Integer ziyuanTypes) {
        this.ziyuanTypes = ziyuanTypes;
    }
    /**
	 * 设置：资源介绍
	 */
    public String getZiyuanContent() {
        return ziyuanContent;
    }


    /**
	 * 获取：资源介绍
	 */

    public void setZiyuanContent(String ziyuanContent) {
        this.ziyuanContent = ziyuanContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getZiyuanDelete() {
        return ziyuanDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setZiyuanDelete(Integer ziyuanDelete) {
        this.ziyuanDelete = ziyuanDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
