package net.thumbtack.tyunkov.secondLesson;

import java.util.Scanner;

class RankingRect {
    Rectangle[] rectangle;
    public RankingRect(int count) {
        rectangle = new Rectangle[count];
        for(int i = 0; i < count; i++) {
            Scanner scanner = new Scanner(System.in);
            rectangle[i] = new Rectangle(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
    }

    public Rectangle[] getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle[] rectangle) {
        this.rectangle = rectangle;
    }
}



public class SecondLesson {
    public static void main( String[] args ) {
        int area = 0;
        Scanner scanner = new Scanner(System.in);
        Rectangle mainRectangle = new Rectangle(0, 0, 100, 100);
        RankingRect rankingRect = new RankingRect(scanner.nextInt());
        //mainRectangle.printCoordinatesVertices();
        Rectangle[] rect = rankingRect.getRectangle();
        /*for(int i = 0; i < rect.length; i++) {
            System.out.println();
            rect[i].printCoordinatesVertices();
            System.out.println();
        }*/
        for(int i = 0; i < rect.length - 1 ; i++) {
            for(int j = i + 1; j < rect.length; j++) {
                area += rect[i].findAreaIntersection(rect[j]);
            }
        }
        System.out.println(area);
    }
}
