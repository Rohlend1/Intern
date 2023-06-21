package services;

import container.AutoConnect;
import org.springframework.stereotype.Service;
import repositories.TestRepository;

@Service
public class TestService1 {
    @AutoConnect
    private TestRepository testRepository;

    public TestService1(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public TestRepository getTestRepository() {
        return testRepository;
    }
}
