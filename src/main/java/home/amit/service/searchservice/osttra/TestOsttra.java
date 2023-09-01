package home.amit.service.searchservice.osttra;
/*
User :- AmitSingh
Date :- 8/28/2023
Time :- 11:15 AM
Year :- 2023
*/

//Implelement a Custom Thread Pool which will have 5 threads and it will take LinkedList and print numbers from LinkedList

import java.util.*;

public class TestOsttra {
    private final WorkerThread[] workers;

    public TestOsttra(int numThreads) {
        workers = new WorkerThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            workers[i] = new WorkerThread();
            workers[i].start();
        }
    }

    public static void main(String[] args) {

        List<Integer> mylist = new LinkedList<>();
        TestOsttra testOsttra = new TestOsttra(5);
        LinkedList<UserAction> userActionList= new LinkedList<>();
        UserAction user1= new UserAction("Sid","Action 1");
        UserAction user2= new UserAction("Sid","Action 2");
        UserAction user3= new UserAction("Sid","Action 3");
        UserAction user4= new UserAction("Sid1","Action 1");
        UserAction user5= new UserAction("Sid1","Action 2");
        UserAction user6= new UserAction("Sid","Action 6");
        UserAction user7= new UserAction("Sid","Action 7");
        UserAction user8= new UserAction("Sid","Action 8");
        UserAction user9= new UserAction("Sid","Action 9");
        UserAction user10= new UserAction("Sid","Action 10");
        userActionList.add(user1);
        userActionList.add(user2);
        userActionList.add(user3);
        userActionList.add(user4);
        userActionList.add(user5);
        userActionList.add(user6);
        userActionList.add(user7);
        userActionList.add(user8);
        userActionList.add(user9);
        userActionList.add(user10);

       for (int i = 0; i < 5; i++) {
            testOsttra.submit(new UserActionPrinter(userActionList));
            }
   }

    public void submit(Runnable task) {
        int i=0;
        for (WorkerThread worker : workers) {
            worker.addTask(task);
        }
    }

}



