
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 志愿资源
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/ziyuan")
public class ZiyuanController {
    private static final Logger logger = LoggerFactory.getLogger(ZiyuanController.class);

    private static final String TABLE_NAME = "ziyuan";

    @Autowired
    private ZiyuanService ziyuanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//广场论坛
    @Autowired
    private HuodongService huodongService;//志愿活动
    @Autowired
    private HuodongCollectionService huodongCollectionService;//活动收藏
    @Autowired
    private HuodongLiuyanService huodongLiuyanService;//活动留言
    @Autowired
    private HuodongYuyueService huodongYuyueService;//活动报名
    @Autowired
    private JunazhengService junazhengService;//捐赠信息
    @Autowired
    private NewsService newsService;//公告通知
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZiyuanCollectionService ziyuanCollectionService;//资源收藏
    @Autowired
    private ZiyuanLiuyanService ziyuanLiuyanService;//资源留言
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("ziyuanDeleteStart",1);params.put("ziyuanDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = ziyuanService.queryPage(params);

        //字典表数据转换
        List<ZiyuanView> list =(List<ZiyuanView>)page.getList();
        for(ZiyuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZiyuanEntity ziyuan = ziyuanService.selectById(id);
        if(ziyuan !=null){
            //entity转view
            ZiyuanView view = new ZiyuanView();
            BeanUtils.copyProperties( ziyuan , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZiyuanEntity ziyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,ziyuan:{}",this.getClass().getName(),ziyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZiyuanEntity> queryWrapper = new EntityWrapper<ZiyuanEntity>()
            .eq("ziyuan_name", ziyuan.getZiyuanName())
            .eq("zan_number", ziyuan.getZanNumber())
            .eq("cai_number", ziyuan.getCaiNumber())
            .eq("ziyuan_types", ziyuan.getZiyuanTypes())
            .eq("ziyuan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZiyuanEntity ziyuanEntity = ziyuanService.selectOne(queryWrapper);
        if(ziyuanEntity==null){
            ziyuan.setZanNumber(1);
            ziyuan.setCaiNumber(1);
            ziyuan.setZiyuanDelete(1);
            ziyuan.setInsertTime(new Date());
            ziyuan.setCreateTime(new Date());
            ziyuanService.insert(ziyuan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZiyuanEntity ziyuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,ziyuan:{}",this.getClass().getName(),ziyuan.toString());
        ZiyuanEntity oldZiyuanEntity = ziyuanService.selectById(ziyuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(ziyuan.getZiyuanPhoto()) || "null".equals(ziyuan.getZiyuanPhoto())){
                ziyuan.setZiyuanPhoto(null);
        }
        if("".equals(ziyuan.getZiyuanContent()) || "null".equals(ziyuan.getZiyuanContent())){
                ziyuan.setZiyuanContent(null);
        }

            ziyuanService.updateById(ziyuan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZiyuanEntity> oldZiyuanList =ziyuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ZiyuanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ZiyuanEntity ziyuanEntity = new ZiyuanEntity();
            ziyuanEntity.setId(id);
            ziyuanEntity.setZiyuanDelete(2);
            list.add(ziyuanEntity);
        }
        if(list != null && list.size() >0){
            ziyuanService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ZiyuanEntity> ziyuanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZiyuanEntity ziyuanEntity = new ZiyuanEntity();
//                            ziyuanEntity.setZiyuanUuidNumber(data.get(0));                    //资源编号 要改的
//                            ziyuanEntity.setZiyuanName(data.get(0));                    //资源名称 要改的
//                            ziyuanEntity.setZiyuanPhoto("");//详情和图片
//                            ziyuanEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            ziyuanEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            ziyuanEntity.setZiyuanTypes(Integer.valueOf(data.get(0)));   //资源类型 要改的
//                            ziyuanEntity.setZiyuanContent("");//详情和图片
//                            ziyuanEntity.setZiyuanDelete(1);//逻辑删除字段
//                            ziyuanEntity.setInsertTime(date);//时间
//                            ziyuanEntity.setCreateTime(date);//时间
                            ziyuanList.add(ziyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //资源编号
                                if(seachFields.containsKey("ziyuanUuidNumber")){
                                    List<String> ziyuanUuidNumber = seachFields.get("ziyuanUuidNumber");
                                    ziyuanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> ziyuanUuidNumber = new ArrayList<>();
                                    ziyuanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("ziyuanUuidNumber",ziyuanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //资源编号
                        List<ZiyuanEntity> ziyuanEntities_ziyuanUuidNumber = ziyuanService.selectList(new EntityWrapper<ZiyuanEntity>().in("ziyuan_uuid_number", seachFields.get("ziyuanUuidNumber")).eq("ziyuan_delete", 1));
                        if(ziyuanEntities_ziyuanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZiyuanEntity s:ziyuanEntities_ziyuanUuidNumber){
                                repeatFields.add(s.getZiyuanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [资源编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        ziyuanService.insertBatch(ziyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<ZiyuanView> returnZiyuanViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("ziyuanYesnoTypes",2);
        PageUtils pageUtils = ziyuanCollectionService.queryPage(params1);
        List<ZiyuanCollectionView> collectionViewsList =(List<ZiyuanCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(ZiyuanCollectionView collectionView:collectionViewsList){
            Integer ziyuanTypes = collectionView.getZiyuanTypes();
            if(typeMap.containsKey(ziyuanTypes)){
                typeMap.put(ziyuanTypes,typeMap.get(ziyuanTypes)+1);
            }else{
                typeMap.put(ziyuanTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("ziyuanTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("ziyuanYesnoTypes",2);
            PageUtils pageUtils1 = ziyuanService.queryPage(params2);
            List<ZiyuanView> ziyuanViewList =(List<ZiyuanView>)pageUtils1.getList();
            returnZiyuanViewList.addAll(ziyuanViewList);
            if(returnZiyuanViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("ziyuanYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = ziyuanService.queryPage(params);
        if(returnZiyuanViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnZiyuanViewList.size();//要添加的数量
            List<ZiyuanView> ziyuanViewList =(List<ZiyuanView>)page.getList();
            for(ZiyuanView ziyuanView:ziyuanViewList){
                Boolean addFlag = true;
                for(ZiyuanView returnZiyuanView:returnZiyuanViewList){
                    if(returnZiyuanView.getId().intValue() ==ziyuanView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnZiyuanViewList.add(ziyuanView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnZiyuanViewList = returnZiyuanViewList.subList(0, limit);
        }

        for(ZiyuanView c:returnZiyuanViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnZiyuanViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = ziyuanService.queryPage(params);

        //字典表数据转换
        List<ZiyuanView> list =(List<ZiyuanView>)page.getList();
        for(ZiyuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZiyuanEntity ziyuan = ziyuanService.selectById(id);
            if(ziyuan !=null){


                //entity转view
                ZiyuanView view = new ZiyuanView();
                BeanUtils.copyProperties( ziyuan , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ZiyuanEntity ziyuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,ziyuan:{}",this.getClass().getName(),ziyuan.toString());
        Wrapper<ZiyuanEntity> queryWrapper = new EntityWrapper<ZiyuanEntity>()
            .eq("ziyuan_uuid_number", ziyuan.getZiyuanUuidNumber())
            .eq("ziyuan_name", ziyuan.getZiyuanName())
            .eq("zan_number", ziyuan.getZanNumber())
            .eq("cai_number", ziyuan.getCaiNumber())
            .eq("ziyuan_types", ziyuan.getZiyuanTypes())
            .eq("ziyuan_delete", ziyuan.getZiyuanDelete())
//            .notIn("ziyuan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZiyuanEntity ziyuanEntity = ziyuanService.selectOne(queryWrapper);
        if(ziyuanEntity==null){
                ziyuan.setZanNumber(1);
                ziyuan.setCaiNumber(1);
            ziyuan.setZiyuanDelete(1);
            ziyuan.setInsertTime(new Date());
            ziyuan.setCreateTime(new Date());
        ziyuanService.insert(ziyuan);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

