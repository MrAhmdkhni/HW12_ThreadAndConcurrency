package question_2;

public class TestDeadlock {

    public static void main(String[] args) {
        final String lockOne = "lock one";
        final String lockTwo = "lock two";

        // threadOne tries to lock lockOne then lockTwo
        Thread threadOne = new Thread(() -> {
            synchronized (lockOne) {
                System.out.println("lock one acquired, waiting to acquire lock two.");

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                synchronized (lockTwo) {
                    System.out.println("lock two acquired");
                    System.out.println("executing first thread.");
                }
            }
        });

        // threadTwo tries to lock lockTwo then lockOne
        Thread threadTwo = new Thread() {
            public void run() {
                synchronized (lockTwo) {
                    System.out.println("lock two acquired, waiting to acquire lock one.");

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    synchronized (lockOne) {
                        System.out.println("lock one acquired");
                        System.out.println("executing second thread.");
                    }
                }
            }
        };
        threadOne.start();
        threadTwo.start();
    }
}
