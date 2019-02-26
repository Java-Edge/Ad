package com.javaedge.ad.sender;

import com.javaedge.ad.mysql.dto.MySqlRowData;

/**
 * @author sss
 * @date 2019-02-26
 */
public interface ISender {

    /**
     * 发送消息到 MQ
     *
     * @param rowData
     */
    void sender(MySqlRowData rowData);
}
