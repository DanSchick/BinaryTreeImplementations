/**
 * Created by Danny on 3/2/2016.
 */
public class Node {
    public Node(int givenData){
        this.left = null;
        this.right = null;
        this.data = givenData;
    }
    public Node(int givenData, Node LChild, Node RChild){
        this.left = LChild;
        this.right = RChild;
        this.data = givenData;
    }
    public int getData(){
        return data;
    }
    public void setData(int givenData){
        data = givenData;
    }
    public Node getParent(){
        return parent;
    }
    public void setParent(Node givenParent){
        this.parent = givenParent;
    }
    public Node getRChild(){
        return right;
    }
    public Node getLChild(){
        return left;
    }
    public void setRChild(Node child){
        right = child;
    }
    public void setLChild(Node child){
        left = child;
    }

    public int data;

    public int height;
    public Node right;
    public Node left;
    private Node parent;

}