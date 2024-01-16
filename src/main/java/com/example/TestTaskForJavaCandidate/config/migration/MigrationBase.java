package com.example.TestTaskForJavaCandidate.config.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public abstract class MigrationBase extends BaseJavaMigration {

    protected JdbcTemplate jdbcTemplate;
    private static final Logger log = LoggerFactory.getLogger(MigrationBase.class);

    @Override
    public void migrate(Context context) {
        this.jdbcTemplate = new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true));

        try {
            log.info("Migration {} has started", this.getClass().getSimpleName());
            execute();
            log.info("Migration {} has finished", this.getClass().getSimpleName());
        } catch (Exception e) {
            log.error("Migration {} failed: {}", this.getClass().getSimpleName(), e.getMessage());
            throw new RuntimeException(e);
        }
    }

    protected abstract void execute();
}
