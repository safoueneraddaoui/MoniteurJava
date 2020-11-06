import java.util.concurrent.locks.*;

public class ProdCons {
    //declaration des variables
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    private int[] items = new int[100];
    int in=1, out=1, count=0, taille=100;

    public void put(int x) throws InterruptedException {
        lock.lock();
        try {

            if (count == taille) // si tampon plein alors attendre
                notFull.await();
            items[in] = x;
            in = (in + 1) % taille;
            count = count + 1;
            notEmpty.signal();
            System.out.println(Thread.currentThread().getName() +
                    " vient de produire " + x);
        } finally {
            lock.unlock();
        }
    }

        public int take()throws InterruptedException {
            lock.lock();
            try {
                if (count == 0) //si tampon vide alors attende
                    notEmpty.await();
                int x = items[out];
                out = (out +1)% taille;
                count= count -1;
                notFull.signal();
                System.out.println(Thread.currentThread().getName() +" vient de consommer " + x) ;
                return x;
            } finally {
                lock.unlock();
            }
        }
    }
