package com.dao;

import com.entity.ZiyuanCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZiyuanCollectionView;

/**
 * 资源收藏 Dao 接口
 *
 * @author 
 */
public interface ZiyuanCollectionDao extends BaseMapper<ZiyuanCollectionEntity> {

   List<ZiyuanCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
