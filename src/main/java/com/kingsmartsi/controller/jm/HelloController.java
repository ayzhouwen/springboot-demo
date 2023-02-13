package com.kingsmartsi.controller.jm;

import cn.hutool.core.date.DateUtil;
import com.kingsmartsi.common.controller.BaseController;
import com.kingsmartsi.common.domain.AjaxResult;
import com.kingsmartsi.common.domain.page.TableDataInfo;
import com.kingsmartsi.common.utils.CacheUtil;
import com.kingsmartsi.service.rc.RcSuService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 接口测试
 *
 * @author kingsmartsi
 */
@RestController
@RequestMapping("/hello")
public class HelloController extends BaseController {
    @Resource
    private RcSuService rcSuService;
    @Resource
    private CacheUtil cacheUtil;
    @Value("${server.port}")
    private int port;
    @GetMapping("test")
    public AjaxResult getInfo() throws InterruptedException {
        Thread.sleep(1000*3);
        return AjaxResult.success("返回数据成功,服务端口:"+port);
    }
    @GetMapping("testDb")
    public TableDataInfo testDb(){
        startPage();
        return getDataTable(rcSuService.list());
    }
    @GetMapping("testCache")
    public AjaxResult testCache()  {
        Map map=new LinkedHashMap();
        map.put("张三",1);
        map.put("李四",2);
        cacheUtil.setCacheObject("myobj",map);
        cacheUtil.setCacheObject("mytime", DateUtil.now());
        String v=cacheUtil.getCacheObject("mytime");
        Map v1=cacheUtil.getCacheObject("myobj");
        return AjaxResult.success("缓存数据 mytime:"+v+"  ,myobj:"+v1);
    }


}
