public class MyMainClass {
    public static void main(String args[]) {
        Moniteur mn=new Moniteur();
        RequestRelease request1=new RequestRelease(mn);
        RequestRelease request2=new RequestRelease(mn);
        RequestRelease request3=new RequestRelease(mn);

        request1.start();
        request2.start();
        request3.start();


    }
}
