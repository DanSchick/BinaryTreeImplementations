import java.util.ArrayList;

/**
 * Implements an AVL tree.
 */
public class AvlTree
{

    public ArrayList<Integer> nodeDataArr = new ArrayList<>();
    /**
     * Construct the tree.
     */
    public AvlTree(char arg)
    {
        Node insertNode;
        if(arg == 'S'){
            // searching exercise with 1000 nodes
            double randomNum = (double)Math.random() * 50000;
            root = new Node((int)randomNum);
            for(int i=0;i<1000;i++){
                randomNum = (double)Math.random() * 50000;
                int num = (int)randomNum;
                nodeDataArr.add(num);
                insertNode = new Node(num);
                insert(insertNode.data, root);
            }
        } else if(arg == 's') {
            // searching exercise with 100 nodes
            double randomNum = (double) Math.random() * 50000;
            root = new Node((int) randomNum);
            for (int i = 0; i < 100; i++) {
                randomNum = (double) Math.random() * 50000;
                int number = (int) randomNum;
                nodeDataArr.add(number);
                insertNode = new Node(number);
                insert(insertNode.data, root);
            }
        }
            else if(arg == 'r'){
            // randomized inputs
            double randomNum = (double)Math.random() * 50000;
            root = new Node((int)randomNum);
            for(int i=0;i<50000;i++){
                randomNum = (double)Math.random() * 50000;
                insert((int)randomNum, root);
            }
        } else if(arg == 'i'){
            // increasing input nodes
            root = new Node(1);
            for(int i=2;i<50000;i++){
                insertNode = new Node(i);
                insert(i,root);
            }
        }
    }

    /**
     * Insert into the tree; duplicates are ignored.
     */
    public void insert( Comparable x )
    {
        root = insert( x, root );
    }

    /**
     * Find an item in the tree.
     */
    public Comparable find( Comparable x )
    {
        return dataAt( find( x, root ) );
    }

    /**
     * Internal method to get data field.
     */
    private Comparable dataAt( Node t )
    {
        return t == null ? null : t.data;
    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the tree.
     * @return the new root.
     */
    private Node insert( Comparable x, Node t )
    {
        if( t == null )
            t = new Node( (int)x, null, null );
        else if( x.compareTo( t.data ) < 0 )
        {
            t.left = insert( x, t.left );
            if( height( t.left ) - height( t.right ) == 2 )
                if( x.compareTo( t.left.data ) < 0 )
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t );
        }
        else if( x.compareTo( t.data ) > 0 )
        {
            t.right = insert( x, t.right );
            if( height( t.right ) - height( t.left ) == 2 )
                if( x.compareTo( t.right.data ) > 0 )
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        else
            ;  // Duplicate; do nothing
        t.height = max( height( t.left ), height( t.right ) ) + 1;
        return t;
    }



    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the tree.
     * @return node containing the matched item.
     */
    private Node find( Comparable x, Node t )
    {
        while( t != null )
            if( x.compareTo( t.data ) < 0 )
                t = t.left;
            else if( x.compareTo( t.data ) > 0 )
                t = t.right;
            else
                return t;    // Match

        return null;   // No match
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the tree.
     */
    private void printTree( Node t )
    {
        if( t != null )
        {
            printTree( t.left );
            System.out.println( t.data );
            printTree( t.right );
        }
    }

    /**
     * Return the height of node t, or -1, if null.
     */
    private static int height( Node t )
    {
        return t == null ? -1 : t.height;
    }

    /**
     * Return maximum of lhs and rhs.
     */
    private static int max( int lhs, int rhs )
    {
        return lhs > rhs ? lhs : rhs;
    }

    /**
     * Rotate a subtree with left child
     */
    private static Node rotateWithLeftChild( Node k2 )
    {
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = max( height( k1.left ), k2.height ) + 1;
        return k1;
    }

    /**
     * Rotate a subtree with right child
     */
    private static Node rotateWithRightChild( Node k1 )
    {
        Node k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = max( height( k2.right ), k1.height ) + 1;
        return k2;
    }

    /**
     * Double rotate with left child
     */
    private static Node doubleWithLeftChild( Node k3 )
    {
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
    }

    /**
     * Double rotate with right child
     */
    private static Node doubleWithRightChild( Node k1 )
    {
        k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }

    /** The tree root. */
    private Node root;

}