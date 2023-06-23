package repositories;

import container.AutoConnect;
import models.Test;
import models.Test1;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {

    @AutoConnect
    private Test1 test1;

    @AutoConnect
    private Test test;

    public TestRepository(Test test, Test1 test1) {
        this.test1 = test1;
        this.test = test;
    }
}
