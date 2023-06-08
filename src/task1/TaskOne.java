package task1;


//Первая задачка по многопоточке:
//Необходимо создать новый поток и воспроизвести все его состояния, выведя их в консоль.
//Необходимые состояния:
//- NEW,
//- RUNNABLE,
//- BLOCKED,
//- WAITING,
//- TIMED_WAITING,
//- TERMINATED;
public class TaskOne {

    public static void main(String[] args) {
        printNewThread();
        printRunnableThread();
        printBlockedThread();
        printWaitingThread();
        printTimedWaitingThread();
        printTerminatedThread();
    }

    private static void printNewThread(){
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        System.out.println(newThread.getState());
    }

    private static void printRunnableThread(){
        Thread runnableThread = new Thread(() -> System.out.println(Thread.currentThread().getState()));
        runnableThread.start();
    }

    private static void printBlockedThread(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                blockingMethod();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                blockingMethod();
            }
        });

        t1.start();
        try {
            Thread.sleep(10);
            t2.start();
            Thread.sleep(10);
            System.out.println(t2.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static synchronized void blockingMethod(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printWaitingThread(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        this.wait();
                    } catch (InterruptedException ignored) {

                    }
                }
            }
        });

        t1.start();
        try {
            Thread.sleep(100);
            System.out.println(t1.getState());
            t1.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printTimedWaitingThread(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        this.wait(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t1.start();
        try {
            Thread.sleep(100);
            System.out.println(t1.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printTerminatedThread(){
        Thread terminatedThread = new Thread(() -> {});

        terminatedThread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(terminatedThread.getState());

    }
}
