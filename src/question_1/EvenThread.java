package question_1;

import java.util.ArrayList;

public class EvenThread extends Thread {

    private int number;
    private ArrayList<Integer> evenNumbers = new ArrayList<>();

    @Override
    public void run() {
        for (int i = 0; i <= number; i++) {
            if ( i % 2 == 0)
                evenNumbers.add(i);
        }

        System.out.println(evenNumbers);

        synchronized (CommonResource.getResource()) {
            for (Integer evenNumber : evenNumbers) {
                while (CommonResource.getResource().size() % 2 != 0) {
                    try {
                        CommonResource.getResource().wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                CommonResource.getResource().add(evenNumber);
                CommonResource.getResource().notify();
            }
        }
    }

    public void setNumber(int number) {
        this.number = number;
    }

}

/*public void evenNumber(Integer limit){
        for (int i = 0; i <= limit; i++) {
            if ( i % 2 == 0)
                evenNumbers.add(i);
        }
        System.out.println(evenNumbers);
    }*/