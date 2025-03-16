package com.vijayhealth.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SequenceInitializer implements InitializingBean {

    private final JdbcTemplate jdbcTemplate;

    public SequenceInitializer(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public void afterPropertiesSet() throws Exception {
        createSequenceUserDetails();
        createSequenceBook();
    }

    private void createSequenceUserDetails() {
        String sequenceName = "res_id_sequence_user_detail";
        if (sequenceExists(sequenceName)) {
            String sql = "CREATE SEQUENCE " + sequenceName + " START 1 INCREMENT 1";
            jdbcTemplate.execute(sql);
            System.out.println("SEQUENCE " + sequenceName + " create Sequence MilestoneMovementQuestionsCategory successfully.");
        } else {
            System.out.println("SEQUENCE " + sequenceName + " already exists. Skipping create Sequence MilestoneMovementQuestionsCategory creation.");
        }
    }

    private void createSequenceBook() {
        String sequenceName = "res_id_sequence_book_detail";
        if (sequenceExists(sequenceName)) {
            String sql = "CREATE SEQUENCE " + sequenceName + " START 1 INCREMENT 1";
            jdbcTemplate.execute(sql);
            System.out.println("SEQUENCE " + sequenceName + " create Sequence MilestoneMovementQuestionsCategory successfully.");
        } else {
            System.out.println("SEQUENCE " + sequenceName + " already exists. Skipping create Sequence MilestoneMovementQuestionsCategory creation.");
        }
    }

    private boolean sequenceExists(String sequenceName) {
        String sql = "SELECT 1 FROM information_schema.sequences WHERE sequence_name = ?";
        return !jdbcTemplate.queryForRowSet(sql, sequenceName).next();
    }
}
