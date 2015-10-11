package net.thumbtack.tyunkov.secondLesson;

/**
 * Created by dmitry on 11.10.15.
 */
public class Rectangle {
    private int x1, y1, x2, y2;
    /*private Point2D bottomLeft = new Point2D(0,0);
    private Point2D topRight = new Point2D(0,0);*/

    public Rectangle(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Rectangle(int width, int height){
        x2 = width;
        y2 = height;
    }

    public Rectangle(){
        x2 = 1;
        y2 = 1;
    }

    public void printCoordinatesVertices(){
        System.out.println("bottom-left (" + x1 + ", " + y1 + ")");
        System.out.println("top-left (" + x1 + ", " + y2 + ")");
        System.out.println("top-right (" + x2 + ", " + y2 + ")");
        System.out.println("bottom-right (" + x2 + ", " + y1 + ")");
    }

    public void moveTo(int dx, int dy){
        x1 += dx;
        x2 += dx;
        y1 += dy;
        y2 += dy;
    }

    public void reduction(int nx, int ny){
        x2 /= nx;
        y2 /= ny;
    }

    public int area(){
        int area;
        area = (x2-x1)*(y2-y1);
        return area;
    }

    public boolean isInside(int x, int y){
        return (((x>x1&&x<x2)&&(y>y1&&y<y2)));
    }

    public boolean isIntersection(Rectangle rectangle){
        return (((rectangle.x1<x2&&rectangle.x1>x1)||(rectangle.x2<x2&&rectangle.x2>x1))&&((rectangle.y1<y2&&rectangle.y1>y1)||(rectangle.y2<y2&&rectangle.y2>y1)));
    }

    public int findAreaIntersection(Rectangle rectangle) {
        int area = 0;
        if ((rectangle.getX1()<x2&&rectangle.getX1()>x1)&&(rectangle.getY1()<y2&&rectangle.getY1()>y1)){
            area = (x2 - rectangle.getX1())*(y2 - rectangle.getY1());
        }
        else if ((rectangle.getX1()<x2&&rectangle.getX1()>x1)&&(rectangle.getY2()<y2&&rectangle.getY2()>y1)){
            area = (x2 - rectangle.getX1())*(rectangle.getY2() - y1);
        }
        else if ((rectangle.getX2()<x2&&rectangle.getX2()>x1)&&(rectangle.getY1()<y2&&rectangle.getY1()>y1)){
            area = (rectangle.getX2() - x1)*(y2 - rectangle.getY1());
        }
        else if ((rectangle.getX2()<x2&& rectangle.getX2()>x1)&&(rectangle.getY2()<y2&&rectangle.getY2()>y1)){
            area = (rectangle.getX2() - x1)*(rectangle.getY2() - y1);
        }
        return area;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
}
