package com.itheima.myai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{

    @Override
    public ChatClient getChatClient(OllamaChatModel model) {
         return ChatClient.builder(model).build();
    }
}
