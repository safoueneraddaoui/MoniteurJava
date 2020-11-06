public class RequestRelease extends Thread{
    Moniteur Monit;
    public RequestRelease(Moniteur Mo)
    {
        this.Monit=Mo;
    }
    public void run()
    {
        try
        {
            while(true)
            {
                int m=(int)(100*(Math.random()));
                Monit.Request(m);
                Thread.sleep((int)(1000*Math.random()));
                Monit.Release(m);
            }
        }
        catch (InterruptedException e) {
        }
    }

}

