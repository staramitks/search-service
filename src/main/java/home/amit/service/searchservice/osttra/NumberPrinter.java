package home.amit.service.searchservice.osttra;
/*
User :- AmitSingh
Date :- 8/28/2023
Time :- 11:35 AM
Year :- 2023
*/

import java.util.LinkedList;

public class NumberPrinter implements Runnable {

    private final LinkedList<Integer> numbersList;

    public NumberPrinter(LinkedList<Integer> inList) {
        this.numbersList = inList;
    }

    @Override
    public void run() {

        synchronized (numbersList) {
            if (!numbersList.isEmpty()) {
                int number = numbersList.removeFirst();
                System.out.println(Thread.currentThread().getName() + " : " + number);
            }

        }
    }
}
