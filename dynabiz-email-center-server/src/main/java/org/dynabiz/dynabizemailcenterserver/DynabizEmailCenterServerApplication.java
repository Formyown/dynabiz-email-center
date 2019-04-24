package org.dynabiz.dynabizemailcenterserver;

import org.dynabiz.dynabizemailcenterserver.configuration.EnableMailCenterServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableMailCenterServer
@SpringBootApplication
public class DynabizEmailCenterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynabizEmailCenterServerApplication.class, args);
    }

}
