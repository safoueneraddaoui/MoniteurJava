public class MainClass {
    public static void main(String args[]) {
        ProdCons pc = new ProdCons();
        Prod producteur = new Prod(pc);
        Cons consommateur = new Cons(pc);
        producteur.start();
        consommateur.start();
    }
}
