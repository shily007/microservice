package com.dy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dy.fsg.uid.UidGenerator;

@Service
public class UidGenService {
    @Resource(name = "cachedUidGenerator")
    private UidGenerator uidGenerator;

    public long getUid() {
        return uidGenerator.getUID();
    }
}
