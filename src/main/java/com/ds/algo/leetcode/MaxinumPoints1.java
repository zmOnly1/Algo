package com.ds.algo.leetcode;

/**
 * Created by zm on 2020/2/24.
 */
public class MaxinumPoints1 {

    public static void main(String[] args) {
        MaxinumPoints1 maxinumPoints = new MaxinumPoints1();
        //[(1,1),(1,1),(2,2),(2,2)]
        //Point[] points = new Point[] {new Point(0, 0), new Point(1, 1), new Point(1, -1)}; // 2
        //Point[] points = new Point[] {new Point(0, 0), new Point(0, 0)}; // 2
        Point[] points = new Point[] {new Point(1, 1), new Point(1, 1), new Point(1, 1)}; // 2
        //Point[] points = new Point[] {new Point(0, 9), new Point(138, 429), new Point(115, 359), new Point(115, 359), new Point(-30, -102), new Point(230, 709), new Point(-150, -686), new Point(-135, -613), new Point(-60, -248), new Point(-161, -481), new Point(207, 639), new Point(23, 79), new Point(-230, -691), new Point(-115, -341), new Point(92, 289), new Point(60, 336), new Point(-105, -467), new Point(135, 701), new Point(-90, -394), new Point(-184, -551), new Point(150, 774)}; // 12
        //Point[] points = new Point[] {new Point(1, 1), new Point(1, 1), new Point(2, 2), new Point(2, 2)}; // 4
        System.out.println(maxinumPoints.maxPoints(points));
    }

    //对于给定的n个位于同一二维平面上的点，求最多能有多少个点位于同一直线上
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int maxPointsSameLine = 0;
        for (int i = 0, len = points.length; i < len; i++) {
            int samePointCnt = 1;
            for (int j = i + 1; j < len; j++) {
                int cnt = samePointCnt + 1;
                if (isSamePoint(points[i], points[j])) {
                    samePointCnt++;
                    if (samePointCnt > maxPointsSameLine) {
                        maxPointsSameLine = samePointCnt;
                    }
                    continue;
                }
                for (int k = j + 1; k < len; k++) {
                    Point[] threePoint = new Point[] {points[i], points[j], points[k]};
                    if (sameLine(threePoint)) {
                        cnt++;
                    }
                }
                if (cnt > maxPointsSameLine) {
                    maxPointsSameLine = cnt;
                }

            }
        }
        return maxPointsSameLine;
    }

    private boolean isSamePoint(Point p1, Point p2) {
        return p1.x == p2.x && p1.y == p2.y;
    }

    private boolean sameLine(Point[] threePoints) {
        Point p1 = threePoints[0];
        Point p2 = threePoints[1];
        Point p = threePoints[2];
        return ((p2.y - p1.y) * (p.x - p1.x) == (p2.x - p1.x) * (p.y - p1.y)) &&
                   ((p.y - p2.y) * (p.x - p1.x) == (p.x - p2.x) * (p.y - p1.y));
    }

    static class Point {

        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }

        @Override
        public String toString() {
            return "Point{" +
                       "x=" + x +
                       ", y=" + y +
                       '}';
        }
    }

}
