package com.kingsmartsi.controller.msg;

import cn.hutool.core.date.DateUtil;
import com.kingsmartsi.common.controller.BaseController;
import com.kingsmartsi.common.domain.AjaxResult;
import com.kingsmartsi.common.domain.page.TableDataInfo;
import com.kingsmartsi.common.utils.CacheUtil;
import com.kingsmartsi.service.rc.RcSuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 心跳相关
 *
 * @author kingsmartsi
 */
@RestController
@RequestMapping("/heartbeat")
@Slf4j
public class HeartbeatController extends BaseController {
    @Value("${server.port}")
    private int port;
    @GetMapping("/iotService")
    public AjaxResult iotService()  {
        return AjaxResult.success();
    }


}
