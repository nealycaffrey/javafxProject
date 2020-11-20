package sample;

import java.util.ArrayList;

public class Heap {
    private final ArrayList<Node> nodes;

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

    public boolean search(int data){
        for(Node node: nodes){
            if(node.getData() == data){
                return true;
            }
        }
        return false;
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

    //private Node getSmallerChild(int index){
       // return nodes.get(getSmallerIndex(index));
   // }

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

    public int getLeftChild(int index) {
        return (2*index)+1;
    }

    public int getRightChild(int index) {
        return (2*index)+2;
    }

    public ArrayList<Node> getNodes(){
        return nodes;
    }

    public int getRoot(){
        return nodes.get(0).getData();
    }

    public Node getRootNode(){
        return nodes.get(0);
    }

    public int getTreeHeight() {
        return (int) (Math.log(nodes.size()) / Math.log(2));
    }

    public int size(){
        return nodes.size();
    }
    //iske niche sab bakwaas
    public Node getLeft(Node node){
        return node.left;
    }

    public Node getRight(Node node){
        return node.right;
    }

    public java.util.ArrayList<Node> path(Node node){
        java.util.ArrayList<Node> list = new java.util.ArrayList<>();
        Node current = getRootNode();
        while(current != null){
            list.add(current);
            if(node.getData() < current.getData()){//or the opposite i didnt really use brain here
                current = getLeft(current);
            } else if(node.getData() > current.getData()){
                current = getRight(current);
            } else
                break;
        }
        return list;
    }

    //yaha tak

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
