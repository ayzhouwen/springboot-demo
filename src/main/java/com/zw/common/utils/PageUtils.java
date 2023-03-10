package com.zw.common.utils;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.zw.common.domain.page.PageDomain;
import com.zw.common.domain.page.TableSupport;
import com.zw.common.utils.sql.SqlUtil;

/**
 * 分页工具类
 *
 * @author kingsmartsi
 */
public class PageUtils extends PageHelper {
    /**
     * 设置请求分页数据
     */
    public static void startPage() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (ObjectUtil.isNotNull(pageNum) && ObjectUtil.isNotNull(pageSize)) {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            Boolean reasonable = pageDomain.getReasonable();
            PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
        }
    }

    /**
     * 清理分页的线程变量
     */
    public static void clearPage() {
        PageHelper.clearPage();
    }
}
