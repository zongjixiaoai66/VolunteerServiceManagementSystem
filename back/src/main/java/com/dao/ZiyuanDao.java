package com.dao;

import com.entity.ZiyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZiyuanView;

/**
 * 志愿资源 Dao 接口
 *
 * @author 
 */
public interface ZiyuanDao extends BaseMapper<ZiyuanEntity> {

   List<ZiyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
