
/**
 * Created by Danny on 3/2/2016.
 */
public class BinaryST {
    BinaryST(){

    }
    public BinaryST(Node newRoot){
        root = newRoot;
    }
    public BinaryST(char arg){
        Node insertNode;
        if(arg == 'r'){
            // randomized inputs
            double randomNum = (double)Math.random() * 50000;
            root = new Node((int)randomNum);
            for(int i=0;i<50000;i++){
                randomNum = (double)Math.random() * 50000;
                insertNode = new Node((int)randomNum);
                placeNode(insertNode, root);
            }
        } else if(arg == 'i'){
            // increasing input nodes
            root = new Node(1);
            for(int i=2;i<50000;i++){
                insertNode = new Node(i);
                placeNode(insertNode,root);
            }
        }

    }

    public void inOrder(Node givenParent){
        if(givenParent.left != null){
            inOrder(givenParent.left);
        }
        System.out.print(givenParent.data + ", ");
        if(givenParent.right != null){
            inOrder(givenParent.right);
        }
    }

    public void postOrder(Node givenParent){
        if(givenParent.left != null){
            postOrder(givenParent.left);
        } if(givenParent.right != null){
            postOrder(givenParent.right);
        }
        System.out.print(givenParent.data + ", ");
    }

    public void preOrder(Node givenParent){
        System.out.print(givenParent.data + ", ");
        if(givenParent.left != null){ // if there's at least one child
            if (givenParent.left.left != null || givenParent.left.right != null){
                preOrder(givenParent.left);
            } else {
                System.out.print(givenParent.left.data + ", ");
            }
        } if(givenParent.right != null){
            if(givenParent.right.left != null || givenParent.right.right != null){
                preOrder(givenParent.right);
            } else {
                System.out.print(givenParent.right.data + ", ");
            }
        }

    }

    public void printTree(Node t){
        if(t != null){
            printTree(t.left);
            System.out.println(t.data);
            printTree(t.right);
        }

    }

    public void printChildren(Node givenParent){
        System.out.println("Right: "+ givenParent.right.data+ "Left: "+ givenParent.left.data);
    }


    private void placeNode(Node given, Node givenParent){
        if(given.data <= givenParent.data){
            // it should be left child
            if(givenParent.left == null){
                givenParent.left = given;
                given.parent = givenParent;
            } else {
                placeNode(given, givenParent.left);
            }
        } else if(given.data > givenParent.data){
            if(givenParent.right == null){
                givenParent.right = given;
                given.parent = givenParent;
            } else {
                placeNode(given, givenParent.right);
            }

        }


    }


    Node root;


}
