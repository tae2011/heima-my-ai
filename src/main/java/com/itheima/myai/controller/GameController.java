package com.itheima.myai.controller;

import com.itheima.myai.repository.ChatHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


//@RequiredArgsConstructor
@RestController
@RequestMapping("/ai")
public class GameController {

    @Autowired
    @Qualifier("gameChatClient")
    private  ChatClient  gameChatClient;

//    public GameController(@Qualifier("gameChatClient") ChatClient chatClient) {
//        this.gameChatClient = chatClient;
//    }


    @RequestMapping(value = "/game", produces = "text/html;charset=utf-8")
    public Flux<String> chat(String prompt, String chatId){
        long begin = System.currentTimeMillis();
        Flux<String> content = gameChatClient.prompt()
                .user(prompt)
                .advisors(a -> a.param("chat_memory_conversation_id",chatId))
                .stream()
                .content();
        long end = System.currentTimeMillis();
        System.out.println("耗时"+ String.valueOf(end-begin) + "ms");
        return content;

    }
}

