import java.util.ArrayList;

/**
 * Tree to decode morse
 * @author Gabriel Martins Figueiredo
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {


    private TreeNode<String> root = null;
    String letterSearched = "";

    /**
     * Standard constructor
     */
    public MorseCodeTree() {
        buildTree();
    }


    /**
     * getter for root
     * @return root
     */
    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    /**
     * setter for root
     * @param newNode a TreeNode<T> that will be the new root
     */
    @Override
    public void setRoot(TreeNode<String> newNode) {
        this.root = newNode;
    }

    /**
     * Adds result to the correct position in the tree based on the code
     * @param code the code for the new node to be added
     * @param letter
     * @return
     */
    @Override
    public MorseCodeTree insert(String code, String letter) {
        addNode(root,code,letter);
        return this;
    }

    /**
     * This is a recursive method that adds element to the correct position
     * in the tree based on the code.
     * @param root the root of the tree for this particular recursive instance of addNode
     * @param code the code for this particular recursive instance of addNode
     * @param letter the data of the new TreeNode to be added
     */
    @Override
    public void addNode(TreeNode<String> root, String code, String letter) {

        if (code.length() == 1){
            TreeNode<String> node = new TreeNode<String>(letter);

            if (code.equals(".")){
                root.setLeftChild(node);
            }
            else if (code.equals("-")){
                root.setRightChild(node);
            }
            return;
        }

        else if (code.length()>1) {
            String newCode = code.substring(1);

            if (code.charAt(0) == '.') {
                addNode(root.getLeftChild(), newCode, letter);
            }
            else if (code.charAt(0) == '-') {
                addNode(root.getRightChild(), newCode, letter);
            }
        }
    }

    /**
     * Fetch the data in the tree based on the code
     * @param code the code that describes the traversals within the tree
     * @return
     */
    @Override
    public String fetch(String code) {
        String letter;
        letter = fetchNode(root, code);
        return letter;
    }

    /**
     * This is the recursive method that fetches the data of the TreeNode
     * that corresponds with the code
     * @param root the root of the tree for this particular recursive instance of addNode
     * @param code the code for this particular recursive instance of fetchNode
     * @return
     */
    @Override
    public String fetchNode(TreeNode<String> root, String code) {

        if (code.length() == 1){

            if (code.equals(".")){
                letterSearched = root.getLeftChild().getData();
            }
            else if (code.equals("-")){
                letterSearched = root.getRightChild().getData();
            }
        }

        else if (code.length() > 1) {

            String newCode = code.substring(1);

            if (code.charAt(0) == '.') {
                fetchNode(root.getLeftChild(), newCode);
            }
            else if (code.charAt(0) == '-') {
                fetchNode(root.getRightChild(), newCode);
            }
        }

        return letterSearched;
    }

    /**
     * UNSUPPORTED OPERATION
     * @param data data of node to be deleted
     * @return
     * @throws UnsupportedOperationException
     */
    @Override
    public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * UNSUPPORTED OPERATION
     * @return
     * @throws UnsupportedOperationException
     */
    @Override
    public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Builds the tree by inserting the letters
     */
    @Override
    public void buildTree() {
        root = new TreeNode<String>("");
        insert(".", "e");
        insert("-", "t");
        insert("..", "i");
        insert(".-", "a");
        insert("-.", "n");
        insert("--", "m");
        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---", "o");
        insert("....", "h");
        insert("...-", "v");
        insert("..-.", "f");
        insert(".-..", "l");
        insert(".--.", "p");
        insert(".---", "j");
        insert("-...", "b");
        insert("-..-", "x");
        insert("-.-.", "c");
        insert("-.--", "y");
        insert("--..", "z");
        insert("--.-", "q");
    }

    /**
     * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
     * @return an ArrayList of the items in the linked Tree
     */
    @Override
    public ArrayList<String> toArrayList() {

        ArrayList<String> arrayListTree = new ArrayList<String>();
        LNRoutputTraversal(root, arrayListTree);
        return arrayListTree;

    }

    /**
     * The recursive method to put the contents of the linked converter tree in an ArrayList<T>
     * LNR (Inorder)
     * @param root the root of the tree for this particular recursive instance
     * @param list the ArrayList that will hold the contents of the tree in LNR order
     */
    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {

        if (root == null){
            return;
        }

        else {
            LNRoutputTraversal(root.getLeftChild(), list);
            list.add(root.getData());
            LNRoutputTraversal(root.getRightChild(), list);
        }
    }

}
