package question_1;

import java.util.ArrayList;

public class OddThread extends Thread {

    private int number;
    private ArrayList<Integer> oddNumbers = new ArrayList<>();

    @Override
    public void run(){
        for (int i = 0; i <= number; i++) {
            if ( i % 2 != 0)
                oddNumbers.add(i);
        }

        System.out.println(oddNumbers);

        synchronized (CommonResource.getResource()) {
            for (Integer oddNumber : oddNumbers) {
                while (CommonResource.getResource().size() % 2 == 0) {
                    try {
                        CommonResource.getResource().wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                CommonResource.getResource().add(oddNumber);
                CommonResource.getResource().notify();
            }
        }
    }


    public void setNumber(int number) {
        this.number = number;
    }

    /*public void add() {
        synchronized (CommonResource.getResource()) {
            for (Integer oddNumber : oddNumbers) {
                while (CommonResource.getResource().size() % 2 == 0) {
                    try {
                        CommonResource.getResource().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                CommonResource.getResource().add(oddNumber);
                CommonResource.getResource().notify();
            }
        }
    }*/
}


/*public void oddNumber(Integer limit){
        for (int i = 0; i <= limit; i++) {
            if ( i % 2 != 0)
                oddNumbers.add(i);
        }
        System.out.println(oddNumbers);
    }*/