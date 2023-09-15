import java.util.NoSuchElementException;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     * <p>
     * This must be done recursively.
     * <p>
     * The new data should become a leaf in the tree.
     * <p>
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     * <p>
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        if (data == null) throw new IllegalArgumentException("Error: data must be valid!");
        else {
            rAddData(root, data);
        }
    }

    /**
     * Recursively adds the data to the BST if no duplicate is found.
     *
     * @param root root or current node
     * @param data data to be added
     * @return BSTNode for recursion
     */
    private BSTNode<T> rAddData(BSTNode<T> root, T data) {
        if(root == null){
            size++;
            return new BSTNode<>(data);
        } else if (root.getData().compareTo(data) < 0) {
            root.setLeft(rAddData(root.getLeft(), data));
        }
        else if (root.getData().compareTo(data) > 0){
            root.setRight(rAddData(root.getRight(), data));
        }
        return root;
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     * <p>
     * This must be done recursively.
     * <p>
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     * <p>
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     * <p>
     * Hint: Should you use value equality or reference equality?
     * <p>
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        if (data == null) throw new IllegalArgumentException("Error: data must be valid!");
        else{
            BSTNode<T> dummyNode = new BSTNode<>(null);
            root = rRemoveData(root, data, dummyNode);
            return dummyNode.getData();
        }
    }

    private BSTNode<T> rRemoveData(BSTNode<T> root, T data, BSTNode<T> dummyNode){
        if (root == null) throw new NoSuchElementException("Error: data not found.");
        else if (data.compareTo(root.getData()) < 0){
            root.setLeft(rRemoveData(root, data, dummyNode));
        }
        else if (data.compareTo(root.getData()) > 0){
            root.setRight(rRemoveData(root, data, dummyNode));
        }
        else {
            dummyNode.setData(root.getData());
            size--;
            return removeData(root);
        }
        return root;
    }

    private BSTNode<T> removeData(BSTNode<T> root){
        if (root.getLeft() == null && root.getRight() == null){
            return null;
        }
        else if (root.getLeft() != null){
            return root.getLeft();
        }
        else if (root.getRight() != null){
            return root.getRight();
        }
        else {
            BSTNode<T> secondDummy = new BSTNode<>(null);
            root.setRight(rRemoveSuccessor(root.getRight(), secondDummy));
        }
        return root;
    }

    private BSTNode<T> rRemoveSuccessor(BSTNode<T> root, BSTNode<T> secondDummy){
        if (root.getLeft() == null){
            //TODO: remove successor
        }
        else {
            rRemoveSuccessor(root.getLeft(), secondDummy);
        }
    }

    /**
     * Returns the root of the tree.
     * <p>
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     * <p>
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}