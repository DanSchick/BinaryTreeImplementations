/**
 *  Java Program to Implement SplayTree
 **/

/** Class SplayTree **/
class SplayTree
{
    private Node root;

    /** Constructor **/
    public SplayTree()
    {
        root = null;
    }

    public SplayTree(char args){
        Node insertNode;
        if(args == 'r'){
            // randomized inputs
            double randomNum = (double)Math.random() * 50000;
            root = new Node((int)randomNum);
            for(int i=0;i<50000;i++){
                randomNum = (double)Math.random() * 50000;
                insert((int)randomNum);
            }
        } else if(args == 'i'){
            // increasing input nodes
            root = new Node(1);
            for(int i=1;i<50000;i++){
                insertNode = new Node(i);
                insert(i);
            }
        }
    }

    /** Function to check if tree is empty **/
    public boolean isEmpty()
    {
        return root == null;
    }

    /** clear tree **/
    public void clear()
    {
        root = null;
    }

    /** function to insert.data */
    public void insert(int ele)
    {
        Node z = root;
        Node p = null;
        while (z != null)
        {
            p = z;
            if (ele < p.data)
                z = z.right;
            else
                z = z.left;
        }
        z = new Node();
        z.data = ele;
        z.parent = p;
        if (p == null)
            root = z;
        else if (ele < p.data)
            p.right = z;
        else
            p.left = z;
        Splay(z);
    }
    /** rotate **/
    public void makeLeftChildParent(Node c, Node p)
    {
        if ((c == null) || (p == null) || (p.left != c) || (c.parent != p))
            throw new RuntimeException("WRONG");

        if (p.parent != null)
        {
            if (p == p.parent.left)
                p.parent.left = c;
            else
                p.parent.right = c;
        }
        if (c.right != null)
            c.right.parent = p;

        c.parent = p.parent;
        p.parent = c;
        p.left = c.right;
        c.right = p;
    }

    /** rotate **/
    public void makeRightChildParent(Node c, Node p)
    {
        if ((c == null) || (p == null) || (p.right != c) || (c.parent != p))
            throw new RuntimeException("WRONG");
        if (p.parent != null)
        {
            if (p == p.parent.left)
                p.parent.left = c;
            else
                p.parent.right = c;
        }
        if (c.left != null)
            c.left.parent = p;
        c.parent = p.parent;
        p.parent = c;
        p.right = c.left;
        c.left = p;
    }

    /** function splay **/
    private void Splay(Node x)
    {
        while (x.parent != null)
        {
            Node Parent = x.parent;
            Node GrandParent = Parent.parent;
            if (GrandParent == null)
            {
                if (x == Parent.left)
                    makeLeftChildParent(x, Parent);
                else
                    makeRightChildParent(x, Parent);
            }
            else
            {
                if (x == Parent.left)
                {
                    if (Parent == GrandParent.left)
                    {
                        makeLeftChildParent(Parent, GrandParent);
                        makeLeftChildParent(x, Parent);
                    }
                    else
                    {
                        makeLeftChildParent(x, x.parent);
                        makeRightChildParent(x, x.parent);
                    }
                }
                else
                {
                    if (Parent == GrandParent.left)
                    {
                        makeRightChildParent(x, x.parent);
                        makeLeftChildParent(x, x.parent);
                    }
                    else
                    {
                        makeRightChildParent(Parent, GrandParent);
                        makeRightChildParent(x, Parent);
                    }
                }
            }
        }
        root = x;
    }




    /** Functions to search for an.data **/
    public boolean search(int val)
    {
        return findNode(val) != null;
    }
    private Node findNode(int ele)
    {
        Node z = root;
        while (z != null)
        {
            if (ele < z.data)
                z = z.right;
            else if (ele > z.data)
                z = z.left;
            else
                return z;
        }
        return null;
    }

}

