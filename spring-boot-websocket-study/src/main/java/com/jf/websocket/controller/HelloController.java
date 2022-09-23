package com.jf.websocket.controller;

import com.jf.websocket.ws.WebSocketServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author 江峰
 * @create 2020-03-31   14:56
 */

@RestController
public class HelloController {

    // @Autowired
    // private WebSocketServer webSocketServer;

    @RequestMapping("/hello")
    public String hello() {
        try {
            String userId = "11";
            WebSocketServer.sendInfo("发送消息给" + userId, userId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "hello";
    }
}
