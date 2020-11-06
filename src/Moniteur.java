import java.util.concurrent.locks.*;

public class Moniteur {
    final Lock lock = new ReentrantLock();
    private int nbCellule = 100;
    private final Condition notFull=lock.newCondition();

    public void Request(int x)throws InterruptedException
    {
        lock.lock();
        try
        {
            while(x>nbCellule)
            {
                notFull.signal();
                System.out.println("Waiting ");
                notFull.await();

            }
            System.out.println("test");
            nbCellule=nbCellule-x;
            System.out.println(Thread.currentThread().getName()+"vient d'ajouter'" + x );
        }
        finally
        {lock.unlock();}
    }
    public void Release(int x)throws InterruptedException
    {
        lock.lock();
        try
        {
            nbCellule=nbCellule+x;
            notFull.signal();
            System.out.println(Thread.currentThread().getName()+"vient de supprimer"+x);
        }
        finally
        {lock.unlock();}
    }


}