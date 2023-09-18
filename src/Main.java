public class Main {
    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();

        bst.add(10);
        bst.add(8);
        System.out.println(bst.remove(8));

        System.out.println(bst.size());
    }
}