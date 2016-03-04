/**
 * Created by Danny on 3/2/2016.
 */
public class main {
    public static void main(String[] args){
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
    }
}
