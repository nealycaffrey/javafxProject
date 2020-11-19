package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Heap {
    private ArrayList<Node> nodes;

    public Heap() {
        nodes = new ArrayList<>();
    }


    public void add(int data){
        Node node = new Node(data);
        nodes.add(node);
        int index = nodes.size() - 1;
        while(index > 0) {
            if((nodes.get(index).getData() < nodes.get(getParent(index)).getData())) {
                swap(index, getParent(index));
                index = getParent(index);
            } else {
                break;
            }
        }
    }

    public void remove() {
        swap(0, nodes.size()-1);
        nodes.remove(nodes.size()-1);
        int current = 0;
        while(getLeftChild(current) < nodes.size() && getRightChild(current) < nodes.size() ) {
            int leftChild = getLeftChild(current);
            int rightChild = getRightChild(current);
            int greaterChild = (nodes.get(leftChild).getData() <  nodes.get(rightChild).getData()) ? leftChild : rightChild;
            if(nodes.get(greaterChild).getData() <  nodes.get(current).getData()) {
                swap(greaterChild, current);
                current = greaterChild;
            } else {
                break;
            }
        }
    }

    public Node getNode(int index){
        return nodes.get(index);
    }

    public void swap(int a, int b){
        Node node1 = nodes.get(a);
        Node node2 = nodes.get(b);
        int temp = node1.getData();
        node1.setData(node2.getData());
        node2.setData(temp);
    }

    public static int getParent(int index) {
        return (int) Math.floor((index - 1)/2.0);
    }

    private int getSmallerIndex(int index){
        if(index * 2 >= nodes.size()-2){
            return index * 2;
        }
        if(nodes.get(2*index).getData() > nodes.get(index*2 + 1).getData()){
            return index * 2 + 1;
        } else {
            return index * 2;
        }
    }

    private Node getSmallerChild(int index){
        return nodes.get(getSmallerIndex(index));
    }

    private static ArrayList<String> tempStringArray = new ArrayList<>();

    public void preOrder(int index) {
        if(index > nodes.size() - 1) {
            return;
        }
        tempStringArray.add(String.valueOf(nodes.get(index)));
        preOrder(getLeftChild(index));
        preOrder(getRightChild(index));
    }

    public String[] preOrderToString() {
        tempStringArray = new ArrayList<>();
        preOrder(0);
        return tempStringArray.toArray(new String[0]);
    }

    public static int getLeftChild(int index) {
        return (2*index)+1;
    }

    public static int getRightChild(int index) {
        return (2*index)+2;
    }

    public ArrayList<Node> getNodes(){
        return nodes;
    }
    public int getTreeHeight() {
        return (int) (Math.log(nodes.size()) / Math.log(2));
    }



    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(6);
        heap.remove();
        for(int i=0; i< heap.nodes.size(); i++){
            System.out.print(heap.nodes.get(i).getData() + " ");
        }
        System.out.println();
        System.out.println(heap.getTreeHeight());

    }

}
