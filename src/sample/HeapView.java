package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class HeapView extends Pane{
    private Heap heap = new Heap();
    private final double vGap = 50; // Gap between two levels in a tree

    HeapView(Heap heap){
        this.heap = heap;
        heap.add(3);
        //setStatus("empty heap");
    }
    public void setStatus(String msg) {
        getChildren().add(new Text(20, 20, msg));
    }

    public void displayHeap() {
        this.getChildren().clear(); // Clear the pane
        if (heap.getRoot() != 0) {
            // Display tree recursively
            displayHeap(heap.getRootNode(), getWidth() / 2, vGap,
                    getWidth() / 4);
        }
    }
    //wrong hai change karo
    public void displayHeap(Node root, double x, double y, double hGap){
        root = heap.getRootNode();
        if(heap.getLeftChild(root.getData()) != 0){
            getChildren().add(new Line(x - hGap, y + vGap, x, y));
            displayHeap(root.left, x - hGap, y + vGap, hGap / 2);
        }
        if (heap.getRightChild(root.getData()) != 0) {
            getChildren().add(new Line(x + hGap, y + vGap, x, y));
            displayHeap(root.right, x + hGap, y + vGap, hGap / 2);
        }

        // Tree node radius
        double radius = 15;
        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle,
                new Text(x - 4, y + 4, root.getData() + ""));
    }

}
