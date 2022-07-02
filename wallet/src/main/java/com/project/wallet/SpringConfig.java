package com.project.wallet;

import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
//    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(EntityManager em) {
//        this.dataSource = dataSource;
        this.em = em;
    }
}
