package com.vijayhealth.config;

import com.vijayhealth.utill.Constants;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class TriggerInitializer implements InitializingBean {


    private final ResourceLoader resourceLoader;
    private final JdbcTemplate jdbcTemplate;

    public TriggerInitializer(ResourceLoader resourceLoader, JdbcTemplate jdbcTemplate) {
        this.resourceLoader = resourceLoader;
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void afterPropertiesSet() {
        createUserDetailTrigger();
        createBookDetailTrigger();
    }

    private void createUserDetailTrigger() {
        try {
            Resource resource = resourceLoader.getResource(Constants.USER_DETAIL_TRIGGERS);
            InputStream inputStream = resource.getInputStream();
            String triggerSql = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            if (isTriggerExists("user_detail_res_id_trigger")) {
                jdbcTemplate.execute(triggerSql);
                System.out.println("user_detail_trigger created successfully.");
            } else {
                System.out.println("user_detail_trigger already exists.Skipping trigger creation.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createBookDetailTrigger() {
        try {
            Resource resource = resourceLoader.getResource(Constants.BOOK_DETAIL_TRIGGERS);
            InputStream inputStream = resource.getInputStream();
            String triggerSql = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            if (isTriggerExists("book_detail_res_id_trigger")) {
                jdbcTemplate.execute(triggerSql);
                System.out.println("book_detail_trigger created successfully.");
            } else {
                System.out.println("book_detail_trigger already exists.Skipping trigger creation.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public boolean isTriggerExists(String triggerName) {
            try {
                Integer result = jdbcTemplate.queryForObject(Constants.QUERY, Integer.class, triggerName);
                return result == null;
            } catch (EmptyResultDataAccessException e) {
                return true;
            }
        }
}
