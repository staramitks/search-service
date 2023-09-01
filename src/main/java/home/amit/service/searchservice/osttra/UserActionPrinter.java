package home.amit.service.searchservice.osttra;
/*
User :- AmitSingh
Date :- 8/28/2023
Time :- 11:35 AM
Year :- 2023
*/

import java.util.LinkedList;

public class UserActionPrinter implements Runnable {

    private final LinkedList<UserAction> userActionList;

    public UserActionPrinter(LinkedList<UserAction> inList) {
        this.userActionList = inList;
    }

    @Override
    public void run() {

        synchronized (userActionList) {
            if (!userActionList.isEmpty()) {
                UserAction userAction = userActionList.removeFirst();
                System.out.println(Thread.currentThread().getName() + " : " + userAction);
            }

        }
    }
}
