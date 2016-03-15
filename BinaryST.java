import java.util.ArrayList;

/**
 * Created by Danny on 3/2/2016.
 */
public class BinaryST {
    BinaryST(){

    }
    public ArrayList<Integer> nodeDataArr = new ArrayList<>();

    public BinaryST(Node newRoot){

        root = newRoot;
    }

    public BinaryST(String nodeString){
        String[] strList =nodeString.split(",");
        for(String str : strList){
            //System.out.println(str);
            break;
        }
        int[] intList = new int[strList.length];
        int counter = 0;
        for(String str : strList){
            intList[counter] = Integer.parseInt(str);
            counter += 1;
            //System.out.println(intList[counter]);
        }
        this.root = new Node(intList[0]);
        for(int i=1;i<intList.length;i++){
            Node toPlace = new Node(intList[i]);
            //System.out.println(toPlace.getData());
            placeNode(toPlace, root);

        }

    }
    public BinaryST(char arg){
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
                placeNode(insertNode, root);
            }
        } else if(arg == 's'){
            // searching exercise with 100 nodes
            double randomNum = (double)Math.random() * 50000;
            root = new Node((int)randomNum);
            for(int i=0;i<100;i++){
                randomNum = (double)Math.random() * 50000;
                int number = (int) randomNum;
                nodeDataArr.add(number);
                insertNode = new Node(number);
                placeNode(insertNode, root);
            }

        } else if(arg == 'r'){
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

    public Node find(int x, Node curNode){
        // we have to find the node containing x
        if(curNode == null){
            throw new RuntimeException("Item not found!");
        }
        else if(curNode.data == x){
            return curNode;
        }
        else {
            if(x > curNode.data){
                find(x, curNode.right);
            } else {
                find(x, curNode.left);
            }

        }
        return null;
    }


    Node root;


}
