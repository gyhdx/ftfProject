package com.ftf.ftfProject.service;

import com.ftf.ftfProject.entity.Logger;

import java.util.List;

public interface LoggerService {
    int gstLogCount();

    void addLogger(String userId, String s);

    List<Logger> gatAllLog();
}
