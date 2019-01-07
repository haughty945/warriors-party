package com.mine.warriorsserverwebsocket.serverImpl;

import com.mine.warriorsserverwebsocket.pojo.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    @Autowired
    private SimpMessagingTemplate template;

    public void sendMessage() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(200);
            template.convertAndSend("/topic/getResponse", new ResponseMessage("Welcome,mine-lee !" + i));
        }
    }
}
