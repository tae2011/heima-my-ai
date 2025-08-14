package com.itheima.myai.repository;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.util.List;


public interface ChatHistoryRepository {
    /**
     * 保存會話記錄
     *
     * @param type
     * @param chatId
     */
    void save(String type,String chatId);


    /**
     * 获取会话ID列表
     * @param type 业务类型，如：chat、service、pdf
     * @return 会话ID列表
     */
    List<String> getChatIds(String type);
}
