package repositories;

import container.AutoConnect;
import models.Test;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {

    @AutoConnect
    private Test test;

    public TestRepository(Test test) {
        this.test = test;
    }
}
