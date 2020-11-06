public class Cons extends Thread{
    ProdCons PC;
    Cons (ProdCons PC) {
        this.PC=PC;
    }
    public void run() {
        try {
            System.out.println("cons run");
                int m = PC.take() ;
                Thread.sleep((int)(1000*Math.random()));
        } catch(InterruptedException e) {}
    }
}
