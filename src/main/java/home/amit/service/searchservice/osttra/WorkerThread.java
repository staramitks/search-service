package home.amit.service.searchservice.osttra;
/*
User :- AmitSingh
Date :- 8/28/2023
Time :- 11:23 AM
Year :- 2023
*/



import java.util.LinkedList;

public class WorkerThread extends Thread{

    private LinkedList<Runnable> takQueue= new LinkedList<>();



    private boolean running=true;

    @Override
    public void run()
    {
        while (running)
        {
            Runnable task;
            synchronized (takQueue){

                while(takQueue.isEmpty())
                {
                    try {

                        takQueue.wait();
                    }
                    catch (InterruptedException e)
                    {
                        Thread.currentThread().interrupt();
                        return;
                    }


                }
                task=takQueue.poll();
             }
            task.run();

        }
    }

    public void addTask(Runnable task)
    {
        synchronized (takQueue)
        {

            takQueue.add(task);
            takQueue.notify();
        }
        Thread t = new Thread(task);
        t.start();

    }

public void stopThread()
{
    running=false;
    interrupt();

}

}
