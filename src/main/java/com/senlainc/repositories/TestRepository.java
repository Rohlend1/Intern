package com.senlainc.repositories;

import com.senlainc.container.AutoConnect;
import com.senlainc.models.Test;
import com.senlainc.models.Test1;
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
