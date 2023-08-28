package home.amit.service.searchservice.osttra;
/*
User :- AmitSingh
Date :- 8/28/2023
Time :- 11:15 AM
Year :- 2023
*/

//Implelement a Custom Thread Pool which will have 5 threads and it will take LinkedList and print numbers from LinkedList

import java.util.LinkedList;
import java.util.List;

public class TestOsttra {
    private  WorkerThread[] workers;
    public TestOsttra(int numThreads)
    {
        workers=new WorkerThread[numThreads];
        for (int i=0; i<numThreads ;i++)
        {
            workers[i]=new WorkerThread();
            workers[i].start();
        }
    }

    public void submit(Runnable task)
    {
        for (WorkerThread worker: workers)
        {
            worker.addTask(task);
        }
    }


    public static void main(String[] args) {

        List<Integer> mylist= new LinkedList<>();
        TestOsttra testOsttra= new TestOsttra(5);

        for (int i=0;i<10;i++)
        {
            mylist.add(i);
        }

        for (int i=0; i<5; i++)
        {
            testOsttra.submit(new NumberPrinter((LinkedList<Integer>) mylist));
        }

    }

}



