package com.bookxchange;


import com.bookxchange.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
@EnableSwagger2
public class BookExchangeApplication extends SpringBootServletInitializer {


    NotificationService ns;

    @Autowired
    public BookExchangeApplication(NotificationService ns) {
        this.ns = ns;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookExchangeApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder builder){
        return builder.sources(BookExchangeApplication.class);
    }

    @Scheduled(fixedRateString = "${notification.check.every}")
    void notificationCronJob(){

        ns.checkForNotifications();

        System.out.println("Notification Cron Running... " + new Date());
    }


}
