public class Main {
    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();

        bst.add(10);
        bst.add(6);
        bst.add(12);

        System.out.println(bst.size());
    }
}