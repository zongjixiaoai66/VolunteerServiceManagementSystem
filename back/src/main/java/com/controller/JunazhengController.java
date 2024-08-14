
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
 * 捐赠信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/junazheng")
public class JunazhengController {
    private static final Logger logger = LoggerFactory.getLogger(JunazhengController.class);

    private static final String TABLE_NAME = "junazheng";

    @Autowired
    private JunazhengService junazhengService;


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
    private NewsService newsService;//公告通知
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZiyuanService ziyuanService;//志愿资源
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
        CommonUtil.checkMap(params);
        PageUtils page = junazhengService.queryPage(params);

        //字典表数据转换
        List<JunazhengView> list =(List<JunazhengView>)page.getList();
        for(JunazhengView c:list){
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
        JunazhengEntity junazheng = junazhengService.selectById(id);
        if(junazheng !=null){
            //entity转view
            JunazhengView view = new JunazhengView();
            BeanUtils.copyProperties( junazheng , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(junazheng.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody JunazhengEntity junazheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,junazheng:{}",this.getClass().getName(),junazheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            junazheng.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JunazhengEntity> queryWrapper = new EntityWrapper<JunazhengEntity>()
            .eq("yonghu_id", junazheng.getYonghuId())
            .eq("junazheng_name", junazheng.getJunazhengName())
            .eq("junazheng_types", junazheng.getJunazhengTypes())
            .in("junazheng_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JunazhengEntity junazhengEntity = junazhengService.selectOne(queryWrapper);
        if(junazhengEntity==null){
            junazheng.setInsertTime(new Date());
            junazheng.setJunazhengYesnoTypes(1);
            junazheng.setCreateTime(new Date());
            junazhengService.insert(junazheng);
            return R.ok();
        }else {
            if(junazhengEntity.getJunazhengYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(junazhengEntity.getJunazhengYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JunazhengEntity junazheng, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,junazheng:{}",this.getClass().getName(),junazheng.toString());
        JunazhengEntity oldJunazhengEntity = junazhengService.selectById(junazheng.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            junazheng.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(junazheng.getJunazhengFile()) || "null".equals(junazheng.getJunazhengFile())){
                junazheng.setJunazhengFile(null);
        }
        if("".equals(junazheng.getJunazhengText()) || "null".equals(junazheng.getJunazhengText())){
                junazheng.setJunazhengText(null);
        }
        if("".equals(junazheng.getJunazhengYesnoText()) || "null".equals(junazheng.getJunazhengYesnoText())){
                junazheng.setJunazhengYesnoText(null);
        }

            junazhengService.updateById(junazheng);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody JunazhengEntity junazhengEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,junazhengEntity:{}",this.getClass().getName(),junazhengEntity.toString());

        JunazhengEntity oldJunazheng = junazhengService.selectById(junazhengEntity.getId());//查询原先数据

//        if(junazhengEntity.getJunazhengYesnoTypes() == 2){//通过
//            junazhengEntity.setJunazhengTypes();
//        }else if(junazhengEntity.getJunazhengYesnoTypes() == 3){//拒绝
//            junazhengEntity.setJunazhengTypes();
//        }
        junazhengService.updateById(junazhengEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JunazhengEntity> oldJunazhengList =junazhengService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        junazhengService.deleteBatchIds(Arrays.asList(ids));

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
            List<JunazhengEntity> junazhengList = new ArrayList<>();//上传的东西
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
                            JunazhengEntity junazhengEntity = new JunazhengEntity();
//                            junazhengEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            junazhengEntity.setJunazhengName(data.get(0));                    //标题 要改的
//                            junazhengEntity.setJunazhengTypes(Integer.valueOf(data.get(0)));   //捐赠类型 要改的
//                            junazhengEntity.setJunazhengFile(data.get(0));                    //凭证 要改的
//                            junazhengEntity.setJunazhengText(data.get(0));                    //详情内容 要改的
//                            junazhengEntity.setInsertTime(date);//时间
//                            junazhengEntity.setJunazhengYesnoTypes(Integer.valueOf(data.get(0)));   //报名状态 要改的
//                            junazhengEntity.setJunazhengYesnoText(data.get(0));                    //审核回复 要改的
//                            junazhengEntity.setCreateTime(date);//时间
                            junazhengList.add(junazhengEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        junazhengService.insertBatch(junazhengList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = junazhengService.queryPage(params);

        //字典表数据转换
        List<JunazhengView> list =(List<JunazhengView>)page.getList();
        for(JunazhengView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JunazhengEntity junazheng = junazhengService.selectById(id);
            if(junazheng !=null){


                //entity转view
                JunazhengView view = new JunazhengView();
                BeanUtils.copyProperties( junazheng , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(junazheng.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R add(@RequestBody JunazhengEntity junazheng, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,junazheng:{}",this.getClass().getName(),junazheng.toString());
        Wrapper<JunazhengEntity> queryWrapper = new EntityWrapper<JunazhengEntity>()
            .eq("yonghu_id", junazheng.getYonghuId())
            .eq("junazheng_name", junazheng.getJunazhengName())
            .eq("junazheng_types", junazheng.getJunazhengTypes())
            .eq("junazheng_text", junazheng.getJunazhengText())
            .in("junazheng_yesno_types", new Integer[]{1,2})
            .eq("junazheng_yesno_text", junazheng.getJunazhengYesnoText())
//            .notIn("junazheng_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JunazhengEntity junazhengEntity = junazhengService.selectOne(queryWrapper);
        if(junazhengEntity==null){
            junazheng.setInsertTime(new Date());
            junazheng.setJunazhengYesnoTypes(1);
            junazheng.setCreateTime(new Date());
        junazhengService.insert(junazheng);

            return R.ok();
        }else {
            if(junazhengEntity.getJunazhengYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(junazhengEntity.getJunazhengYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

