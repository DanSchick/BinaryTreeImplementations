/**
 * Created by Danny on 3/2/2016.
 */
public class Node {
    public Node(){
        this.left = null;
        this.right = null;
        this.data = 0;
    }
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

    public int data;
    public int height;
    public Node right;
    public Node left;
    public Node parent;

}