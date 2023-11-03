package com.home.task.infrastructure.adapter;

import com.home.task.infrastructure.entity.AssignmentEntity;
import com.home.task.infrastructure.repository.AssignmentJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import javax.sql.DataSource;

@DataJpaTest
@EnableJpaRepositories(basePackages = {"com.home.task.infrastructure.repository"})
@EntityScan("com.home.task.infrastructure.entity")
public class AssignmentRepositoryAdapterTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private AssignmentJpaRepository assignmentJpaRepository;

    /*@Test
    @Sql("insert into assignment(id,name,description,status) values(1,'kkk','rrrrr',1)")*/
    @Test
    public void test() {
        Assertions.assertNotNull(dataSource);
    }

    @Test
    public void test2() {
        assignmentJpaRepository.save(new AssignmentEntity());
        assignmentJpaRepository.save(new AssignmentEntity());
        var list = assignmentJpaRepository.findAll();
        Assertions.assertEquals(2, list.size());

    }

    @Configuration
    static class DaoTestConfig {
    }
}
