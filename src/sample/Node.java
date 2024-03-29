package sample;


import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class Node {
    private int data;
    public Node left;
    public Node right;

    private StackPane stack;
    private Circle circle;
    private Text label;

    private StackPane arrayStack;
    private Rectangle arrayBox;
    private Text arrayLabel;

    public Node(int data){
        this.data = data;

        circle = new Circle(40, Color.NAVY);
        label = new Text(data + "");
        label.setFill(Color.WHITE);
        label.setFont(Font.font ("Verdana", 24));
        label.setBoundsType(TextBoundsType.VISUAL);
        stack = new StackPane();
        stack.getChildren().addAll(circle, label);

        arrayBox = new Rectangle(40, 40, Color.LIGHTGRAY);
        arrayLabel = new Text(data + "");
        label.setFill(Color.WHITE);
        arrayStack = new StackPane();
        arrayStack.getChildren().addAll(arrayBox, arrayLabel);
    }

    public Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;

        circle = new Circle(40, Color.NAVY);
        label = new Text(data + "");
        label.setFill(Color.WHITE);
        label.setFont(Font.font ("Verdana", 24));
        label.setBoundsType(TextBoundsType.VISUAL);
        stack = new StackPane();
        stack.getChildren().addAll(circle, label);

        arrayBox = new Rectangle(40, 40, Color.LIGHTGRAY);
        arrayLabel = new Text(data + "");
        label.setFill(Color.WHITE);
        arrayStack = new StackPane();
        arrayStack.getChildren().addAll(arrayBox, arrayLabel);
    }

    public int getData(){
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }
    public Circle getCircle() {
        return circle;
    }

    public Text getLabel() {
        return label;
    }

    public Node getLeft(Node node) {
        return node.left;
    }

    public Node getRight(Node node){
        return node.right;
    }

    public StackPane getStack() {
        return stack;
    }

    public void setStack(StackPane pane) {
        stack = pane;
    }

    public StackPane getArrayStack() {
        return arrayStack;
    }

    public void setArrayStack(StackPane pane) {
        arrayStack = pane;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public void setLabel(Text label) {
        this.label = label;
    }

    public void setArrayBox(Rectangle arrayBox) {
        this.arrayBox = arrayBox;
    }

    public void setArrayLabel(Text arrayLabel) {
        this.arrayLabel = arrayLabel;
    }

    public Rectangle getArrayBox() {
        return arrayBox;
    }

    public Text getArrayLabel() {
        return arrayLabel;
    }

    public String toString() {
        return data + "";
    }
}
