package com.example.TestTaskForJavaCandidate.config.migration;

public class V1_InitUsersTable extends MigrationBase {

    @Override
    protected void execute() {
        jdbcTemplate.execute(
                """
                            CREATE TABLE public.users (
                            id UUID PRIMARY KEY,
                            username VARCHAR(100) NOT NULL,
                            name VARCHAR(100) NOT NULL,
                            surname VARCHAR(100) NOT NULL
                        );
                        """
        );
    }
}
