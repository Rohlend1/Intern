import container.IocContainer;
import services.TestService;


public class Application {

    public static void main(String[] args) {
        IocContainer iocContainer = new IocContainer("/home/user/IdeaProjects/Intern/src/main/java");
        try {
            TestService testService = iocContainer.getBean("TestService", TestService.class);
            System.out.println(testService.getA());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        iocContainer.close();
    }
}
