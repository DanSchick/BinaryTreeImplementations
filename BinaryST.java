
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

    public void inOrder(Node parent){
        if(parent.getLChild() != null){
            inOrder(parent.getLChild());
        }
        System.out.print(parent.getData() + ", ");
        if(parent.getRChild() != null){
            inOrder(parent.getRChild());
        }
    }

    public void postOrder(Node parent){
        if(parent.getLChild() != null){
            postOrder(parent.getLChild());
        } if(parent.getRChild() != null){
            postOrder(parent.getRChild());
        }
        System.out.print(parent.getData() + ", ");
    }

    public void preOrder(Node parent){
        System.out.print(parent.getData() + ", ");
        if(parent.getLChild() != null){ // if there's at least one child
            if (parent.getLChild().getLChild() != null || parent.getLChild().getRChild() != null){
                preOrder(parent.getLChild());
            } else {
                System.out.print(parent.getLChild().getData() + ", ");
            }
        } if(parent.getRChild() != null){
            if(parent.getRChild().getLChild() != null || parent.getRChild().getRChild() != null){
                preOrder(parent.getRChild());
            } else {
                System.out.print(parent.getRChild().getData() + ", ");
            }
        }

    }

    public void printTree(Node t){
        if(t != null){
            printTree(t.getLChild());
            System.out.println(t.getData());
            printTree(t.getRChild());
        }

    }

    public void printChildren(Node parent){
        System.out.println("Right: "+ parent.getRChild().getData()+ "Left: "+ parent.getLChild().getData());
    }


    private void placeNode(Node given, Node parent){
        if(given.getData() <= parent.getData()){
            // it should be left child
            if(parent.getLChild() == null){
                parent.setLChild(given);
                given.setParent(parent);
            } else {
                placeNode(given, parent.getLChild());
            }
        } else if(given.getData() > parent.getData()){
            if(parent.getRChild() == null){
                parent.setRChild(given);
                given.setParent(parent);
            } else {
                placeNode(given, parent.getRChild());
            }

        }


    }


    Node root;


}
