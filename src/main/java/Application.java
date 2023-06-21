import container.IocContainer;
import services.ActorService;

public class Application {

    public static void main(String[] args) {
        IocContainer iocContainer = new IocContainer("/home/user/IdeaProjects/Intern/src/main/java");
        try {
            System.out.println(iocContainer.getBean("ActorService", ActorService.class));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        iocContainer.close();
    }
}
