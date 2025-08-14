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
public class ChatController {
  /*  @Resource
    private OllamaChatModel chatModel;
    @Resource
    private ChatService chatService;*/

    @Autowired
    @Qualifier("chatClient")
    private  ChatClient chatClient;

    @Autowired
    private  ChatHistoryRepository chatHistoryRepository;


  /*  public ChatController(@Qualifier("chatClient") ChatClient chatClient, ChatHistoryRepository chatHistoryRepository) {
        this.chatHistoryRepository = chatHistoryRepository;
        this.chatClient = chatClient;
    }*/

    @RequestMapping(value = "/chat", produces = "text/html;charset=utf-8")
    public Flux<String> chat(String prompt,String chatId){
//        ChatClient chatClient = chatService.getChatClient(chatModel);
        //保存回话id
        chatHistoryRepository.save("chat",chatId);
        long begin = System.currentTimeMillis();
        Flux<String> content = chatClient.prompt()
                .user(prompt)
                .advisors(a -> a.param("chat_memory_conversation_id",chatId))
                .stream()
                .content();
        long end = System.currentTimeMillis();
        System.out.println("耗时"+ String.valueOf(end-begin) + "ms");
        return content;

    }
}
