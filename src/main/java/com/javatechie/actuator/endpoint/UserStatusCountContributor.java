package com.javatechie.actuator.endpoint;

import com.javatechie.actuator.dao.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserStatusCountContributor implements InfoContributor {

    @Autowired
    private UserDatabase database;

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Long> userStatusMap=new HashMap<>();
        userStatusMap.put("active",database.getUserStatusCountByStatus("active"));
        userStatusMap.put("inActive",database.getUserStatusCountByStatus("inActive"));
        builder.withDetail("userStatus",userStatusMap);
    }
}
