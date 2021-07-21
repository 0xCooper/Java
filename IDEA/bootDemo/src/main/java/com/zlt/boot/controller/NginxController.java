package com.zlt.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@CrossOrigin
public class NginxController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("GetServerInfo")
    public  String GetServerIp(){
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "<h1>"+"http://"+address.getHostAddress() +":"+this.serverPort+"</h1>";
    }

}
