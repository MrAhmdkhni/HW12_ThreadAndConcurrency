package question_1;

import question_1.EvenThread;
import question_1.OddThread;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        EvenThread evenThread = new EvenThread();
        OddThread oddThread = new OddThread();
        evenThread.setNumber(20);
        oddThread.setNumber(20);
        evenThread.start();
        oddThread.start();
        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(CommonResource.getResource());


    }
}

/*try {
            evenThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        try {
            oddThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }*/

