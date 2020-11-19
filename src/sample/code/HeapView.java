package sample.code;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class HeapView extends Pane{
    private Heap heap = new Heap();
    private double radius = 15; // Tree node radius
    private double vGap = 50; // Gap between two levels in a tree

    HeapView(Heap heap){
        this.heap = heap;
        setStatus("empty heap");
    }
    public void setStatus(String msg) {
        getChildren().add(new Text(20, 20, msg));
    }

    public void displayHeap() {
        this.getChildren().clear(); // Clear the pane
        if (heap.getRoot() != 0) {
            // Display tree recursively
            displayHeap(heap.getRoot(), getWidth() / 2, vGap,
                    getWidth() / 4);
        }
    }

    public void displayHeap(int root, double x, double y, double hGap){
        root = heap.getRoot();
        if(heap.getLeftChild(root) != 0){
            getChildren().add(new Line(x - hGap, y + vGap, x, y));
            displayHeap(heap.getLeftChild(root), x - hGap, y + vGap, hGap / 2);
        }
        if (heap.getRightChild(root) != 0) {
            getChildren().add(new Line(x + hGap, y + vGap, x, y));
            displayHeap(heap.getRightChild(root), x + hGap, y + vGap, hGap / 2);
        }

        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle,
                new Text(x - 4, y + 4, heap.getNode(root).getData() + ""));
    }

    public static void main(String[] args){

    }
}
