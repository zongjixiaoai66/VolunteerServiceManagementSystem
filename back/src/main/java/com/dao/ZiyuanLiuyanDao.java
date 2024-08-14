package com.dao;

import com.entity.ZiyuanLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZiyuanLiuyanView;

/**
 * 资源留言 Dao 接口
 *
 * @author 
 */
public interface ZiyuanLiuyanDao extends BaseMapper<ZiyuanLiuyanEntity> {

   List<ZiyuanLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
