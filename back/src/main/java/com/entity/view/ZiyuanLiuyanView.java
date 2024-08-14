package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZiyuanLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 资源留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("ziyuan_liuyan")
public class ZiyuanLiuyanView extends ZiyuanLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 用户
		/**
		* 用户名称
		*/

		@ColumnInfo(comment="用户名称",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 用户类型
		*/
		@ColumnInfo(comment="用户类型",type="int(11)")
		private Integer yonghuTypes;
			/**
			* 用户类型的值
			*/
			@ColumnInfo(comment="用户类型的字典表值",type="varchar(200)")
			private String yonghuValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;
	//级联表 志愿资源
		/**
		* 资源编号
		*/

		@ColumnInfo(comment="资源编号",type="varchar(200)")
		private String ziyuanUuidNumber;
		/**
		* 资源名称
		*/

		@ColumnInfo(comment="资源名称",type="varchar(200)")
		private String ziyuanName;
		/**
		* 资源照片
		*/

		@ColumnInfo(comment="资源照片",type="varchar(200)")
		private String ziyuanPhoto;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 资源类型
		*/
		@ColumnInfo(comment="资源类型",type="int(11)")
		private Integer ziyuanTypes;
			/**
			* 资源类型的值
			*/
			@ColumnInfo(comment="资源类型的字典表值",type="varchar(200)")
			private String ziyuanValue;
		/**
		* 资源介绍
		*/

		@ColumnInfo(comment="资源介绍",type="longtext")
		private String ziyuanContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer ziyuanDelete;



	public ZiyuanLiuyanView() {

	}

	public ZiyuanLiuyanView(ZiyuanLiuyanEntity ziyuanLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, ziyuanLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 用户

		/**
		* 获取： 用户名称
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户名称
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}
		/**
		* 获取： 用户类型
		*/
		public Integer getYonghuTypes() {
			return yonghuTypes;
		}
		/**
		* 设置： 用户类型
		*/
		public void setYonghuTypes(Integer yonghuTypes) {
			this.yonghuTypes = yonghuTypes;
		}


			/**
			* 获取： 用户类型的值
			*/
			public String getYonghuValue() {
				return yonghuValue;
			}
			/**
			* 设置： 用户类型的值
			*/
			public void setYonghuValue(String yonghuValue) {
				this.yonghuValue = yonghuValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}
	//级联表的get和set 志愿资源

		/**
		* 获取： 资源编号
		*/
		public String getZiyuanUuidNumber() {
			return ziyuanUuidNumber;
		}
		/**
		* 设置： 资源编号
		*/
		public void setZiyuanUuidNumber(String ziyuanUuidNumber) {
			this.ziyuanUuidNumber = ziyuanUuidNumber;
		}

		/**
		* 获取： 资源名称
		*/
		public String getZiyuanName() {
			return ziyuanName;
		}
		/**
		* 设置： 资源名称
		*/
		public void setZiyuanName(String ziyuanName) {
			this.ziyuanName = ziyuanName;
		}

		/**
		* 获取： 资源照片
		*/
		public String getZiyuanPhoto() {
			return ziyuanPhoto;
		}
		/**
		* 设置： 资源照片
		*/
		public void setZiyuanPhoto(String ziyuanPhoto) {
			this.ziyuanPhoto = ziyuanPhoto;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}
		/**
		* 获取： 资源类型
		*/
		public Integer getZiyuanTypes() {
			return ziyuanTypes;
		}
		/**
		* 设置： 资源类型
		*/
		public void setZiyuanTypes(Integer ziyuanTypes) {
			this.ziyuanTypes = ziyuanTypes;
		}


			/**
			* 获取： 资源类型的值
			*/
			public String getZiyuanValue() {
				return ziyuanValue;
			}
			/**
			* 设置： 资源类型的值
			*/
			public void setZiyuanValue(String ziyuanValue) {
				this.ziyuanValue = ziyuanValue;
			}

		/**
		* 获取： 资源介绍
		*/
		public String getZiyuanContent() {
			return ziyuanContent;
		}
		/**
		* 设置： 资源介绍
		*/
		public void setZiyuanContent(String ziyuanContent) {
			this.ziyuanContent = ziyuanContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getZiyuanDelete() {
			return ziyuanDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setZiyuanDelete(Integer ziyuanDelete) {
			this.ziyuanDelete = ziyuanDelete;
		}


	@Override
	public String toString() {
		return "ZiyuanLiuyanView{" +
			", ziyuanUuidNumber=" + ziyuanUuidNumber +
			", ziyuanName=" + ziyuanName +
			", ziyuanPhoto=" + ziyuanPhoto +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", ziyuanContent=" + ziyuanContent +
			", ziyuanDelete=" + ziyuanDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
