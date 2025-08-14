package com.itheima.myai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;


public interface ChatService {
    public ChatClient getChatClient(OllamaChatModel model);
}
