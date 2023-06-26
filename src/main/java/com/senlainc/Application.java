package com.senlainc;

import com.senlainc.container.IocContainer;
import com.senlainc.services.TestService;


public class Application {

    public static void main(String[] args) {
        IocContainer iocContainer = new IocContainer("C:\\Program Files\\Java\\Projects\\intern\\src\\main\\java");
        try {
            TestService testService = iocContainer.getBean("TestService", TestService.class);
            System.out.println(testService);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        iocContainer.close();
    }
}
