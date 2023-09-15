public class Main {
    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();

        bst.add(10);
        Integer removedData = bst.remove(10);
        System.out.println("Removed: " + removedData);

        System.out.println(bst.size());
    }
}