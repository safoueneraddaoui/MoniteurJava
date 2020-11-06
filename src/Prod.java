public class Prod extends Thread{
    ProdCons PC;
    Prod (ProdCons PC) {
        this.PC=PC;
    }
    public void run() {
        try {
            System.out.println("prod run");
                int m = (int) (1000 * Math.random());
                PC.put(m);
                Thread.sleep((int)(1000*Math.random()));
        } catch(InterruptedException e) {}
    }
}
