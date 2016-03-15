import java.util.Scanner;

/**
 * @author Danny
 */
public class main {
    public static void main(String[] args){


        System.out.println("EXERCISE 1: TRAVERSAL\n\nEnter the nodes to be placed, seperated by a comma: ");
        Scanner reader = new Scanner(System.in);
        String str = reader.nextLine();

        BinaryST tree = new BinaryST(str);

        System.out.println("Pre order: ");
        tree.preOrder(tree.root);
        System.out.println("\nIn Order: ");
        tree.inOrder(tree.root);
        System.out.println("\nPostOrder: ");
        tree.postOrder(tree.root);





        // This will calculate the runtime for various insertions
        System.out.println("\n\nCACLULATING EXERCISE 2");
        System.out.println("\n*******************************************************\n\nEXERCISE 2 RESULTS: ");

        // INSERTIONS FOR BST
        long startTime = System.nanoTime();
        tree = new BinaryST('i');
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
        System.out.println("\nTime taken for inserting into a AVL Tree by increasing number: " + seconds + "s");

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
        System.out.println("\nTime taken for inserting into a Splay Tree by increasing number: " + seconds + "s");

        startTime = System.nanoTime();
        splayTree = new SplayTree('r');
        elapsedTime = System.nanoTime() - startTime;
        seconds = (double)elapsedTime / 1000000000.0;
        System.out.println("Time taken for inserting into a Splay Tree by random number: " + seconds + "s");





        //******************************************
        // THIS IS FOR EXERCISE 3: SEARCHING
        //******************************************
        System.out.println("\n***************************************************************************************\n\nExercise 3:");

        // BST SEARCHING

        // size 1000
        tree = new BinaryST('S');
        startTime = System.nanoTime();
        for(int i=0;i<1000;i++){
            tree.find(tree.nodeDataArr.get(i), tree.root);
        }
        elapsedTime = System.nanoTime() - startTime;
        seconds = (double)elapsedTime / 1000000000.0;
        System.out.println("Time taken for searching each element of a 1000 size BST: " + seconds + "s");

        // size 100
        tree = new BinaryST('s');
        startTime = System.nanoTime();
        for(int i=0;i<100;i++){
            // we searching this node 100 times using a nested for loop
            for(int j=0;j<100;j++) {
                tree.find(tree.nodeDataArr.get(i), tree.root);
            }
        }
        elapsedTime = System.nanoTime() - startTime;
        seconds = (double)elapsedTime / 1000000000.0;
        System.out.println("Time taken for searching each element 100 times of a 100 size BST: " + seconds + "s");


        // AVL TREE SEARCHING
        // size 1000
        avlTree = new AvlTree('S');
        startTime = System.nanoTime();
        for(int i=0;i<1000;i++){
            avlTree.find(avlTree.nodeDataArr.get(i));
        }
        elapsedTime = System.nanoTime() - startTime;
        seconds = (double)elapsedTime / 1000000000.0;
        System.out.println("\nTime taken for searching each element of a 1000 size AVL Tree: " + seconds + "s");

        // size 100
        avlTree = new AvlTree('s');
        startTime = System.nanoTime();
        for(int i=0;i<100;i++){
            // we searching this node 100 times using a nested for loop
            for(int j=0;j<100;j++) {
                avlTree.find(avlTree.nodeDataArr.get(i));
            }
        }
        elapsedTime = System.nanoTime() - startTime;
        seconds = (double)elapsedTime / 1000000000.0;
        System.out.println("Time taken for searching each element 100 times of a 100 size AVL Tree: " + seconds + "s");


        // SPLAY TREE
        // size 1000
        splayTree = new SplayTree('S');
        startTime = System.nanoTime();
        for(int i=0;i<1000;i++){
            splayTree.find(splayTree.nodeDataArr.get(i));
        }
        elapsedTime = System.nanoTime() - startTime;
        seconds = (double)elapsedTime / 1000000000.0;
        System.out.println("\nTime taken for searching each element of a 1000 size Splay Tree: " + seconds + "s");

        // size 100
        splayTree = new SplayTree('S');
        startTime = System.nanoTime();
        for(int i=0;i<100;i++){
            // we searching this node 100 times using a nested for loop
            for(int j=0;j<100;j++) {
                splayTree.find(splayTree.nodeDataArr.get(i));
            }
        }
        elapsedTime = System.nanoTime() - startTime;
        seconds = (double)elapsedTime / 1000000000.0;
        System.out.println("Time taken for searching each element 100 times of a 100 size Splay Tree: " + seconds + "s");







    }
}
