package services;

import container.AutoConnect;
import org.springframework.stereotype.Service;
import repositories.TestRepository;

@Service
public class TestService {

    private int a;

    @AutoConnect
    private TestRepository testRepository;

    public TestService(TestRepository testRepository,int a) {
        this.a = a;
        this.testRepository = testRepository;
    }

    public TestService() {
    }

    public void setTestRepository(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public TestRepository getTestRepository() {
        return testRepository;
    }

    public int getA() {
        return a;
    }
}
