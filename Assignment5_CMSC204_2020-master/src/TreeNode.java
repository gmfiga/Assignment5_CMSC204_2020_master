
/**
 * Class for tree node with right and lefr child references
 * @author Gabriel Martins Figueiredo
 */
public class TreeNode<T> {

    private T data;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    /**
     * Constructor
     * @param dataNode - data for the node
     */
    public TreeNode(T dataNode) {
        this.data = dataNode;
        leftChild = null;
        rightChild = null;
    }

    /**
     * Constructor for deep copies
     * @param node
     */
    public TreeNode(TreeNode<T> node) {
        this.data = node.data;
        this.rightChild = node.rightChild;
        this.leftChild = node.leftChild;
    }

    /**
     * getter for data
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * getter for left child
     * @return left child
     */
    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    /**
     * setter for left child
     * @param leftChild
     */
    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * getter for right child
     * @return right child
     */
    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    /**
     * setter for right child
     * @param rightChild
     */
    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}
