package com.javaedge.ad.mysql.listener;

import com.javaedge.ad.mysql.dto.BinlogRowData;

/**
 * 监听器
 *
 * @author sss
 * @date 2019-02-25
 */
public interface Ilistener {

    /**
     * 对应不同表定义不同的数据更新方法,即注册不同的监听器.
     */
    void register();

    /**
     * 事件监听
     *
     * @param eventData 对应于源码中的Event对象.
     */
    void onEvent(BinlogRowData eventData);
}
