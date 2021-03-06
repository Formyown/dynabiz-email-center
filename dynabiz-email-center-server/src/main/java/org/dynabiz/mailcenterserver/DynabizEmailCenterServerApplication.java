package org.dynabiz.mailcenterserver;

import org.dynabiz.mailcenterserver.configuration.EnableMailCenterServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableMailCenterServer
@SpringBootApplication
public class DynabizEmailCenterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynabizEmailCenterServerApplication.class, args);
    }

}
