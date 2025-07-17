package com.luv2code.springcoredemo.config;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    // define bean for our sad fortune service
    // @Bean
    // public FortuneService sadFortuneService() {
    //     return new SadFortuneService();
    // }

    // define bean for our swim coach and inject dependency
    // @Bean
    // public Coach swimCoach() {
    //     return new SwimCoach(sadFortuneService());
    // }


    //👉bean id is swimCoach with lowercase 's';
    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
