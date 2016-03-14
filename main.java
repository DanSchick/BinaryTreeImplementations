/**
 * Created by Danny on 3/2/2016.
 */
public class main {
    public static void main(String[] args){
        // This will calculate the runtime for various insertions

        // INSERTIONS FOR BST
        long startTime = System.nanoTime();
        BinaryST tree = new BinaryST('i');
        long elapsedTime = System.nanoTime() - startTime;
        double seconds = (double)elapsedTime / 1000000000.0;
        System.out.println("Time taken for inserting into a BST by increasing number: " + seconds + "s");

        startTime = System.nanoTime();
        tree = new BinaryST('r');
        elapsedTime = System.nanoTime() - startTime;
        seconds = (double)elapsedTime / 1000000000.0;
        System.out.println("Time taken for inserting into a BST by random number: " + seconds + "s");

        // INSERTIONS FOR AVL TREE

        startTime = System.nanoTime();
        AvlTree avlTree = new AvlTree('i');
        elapsedTime = System.nanoTime() - startTime;
        seconds = (double)elapsedTime / 1000000000.0;
        System.out.println("Time taken for inserting into a AVL Tree by increasing number: " + seconds + "s");

        startTime = System.nanoTime();
        avlTree = new AvlTree('r');
        elapsedTime = System.nanoTime() - startTime;
        seconds = (double)elapsedTime / 1000000000.0;
        System.out.println("Time taken for inserting into a AVL Tree by random number: " + seconds + "s");

        // INSERTIONS FOR SPLAY TREE

        startTime = System.nanoTime();
        SplayTree splayTree = new SplayTree('i');
        elapsedTime = System.nanoTime() - startTime;
        seconds = (double)elapsedTime / 1000000000.0;
        System.out.println("Time taken for inserting into a Splay Tree by increasing number: " + seconds + "s");

        startTime = System.nanoTime();
        splayTree = new SplayTree('r');
        elapsedTime = System.nanoTime() - startTime;
        seconds = (double)elapsedTime / 1000000000.0;
        System.out.println("Time taken for inserting into a Splay Tree by random number: " + seconds + "s");
    }
}
