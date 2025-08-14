package com.itheima.myai.controller;

import com.itheima.myai.repository.ChatHistoryRepository;
import com.itheima.myai.tools.CourseTools;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/ai")
public class CustomerServiceController {

    private  ChatClient serviceChatClient;

    @Resource
    private  ChatHistoryRepository chatHistoryRepository;


    // 构造函数中使用 @Qualifier 指定 bean 名称
    public CustomerServiceController(@Qualifier("serviceClient") ChatClient chatClient) {
        this.serviceChatClient = chatClient;
    }

    @RequestMapping(value = "/service", produces = "text/html;charset=utf-8")
    public Flux<String> service(String prompt, String chatId) {
        // 1.保存会话id
        chatHistoryRepository.save("service", chatId);
        // 2.请求模型
        return serviceChatClient.prompt()
                .user(prompt)
                .advisors(a -> a.param("chat_memory_conversation_id", chatId))
                .stream()
                .content();
    }
}