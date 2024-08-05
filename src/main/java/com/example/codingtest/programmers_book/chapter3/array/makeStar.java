package com.example.codingtest.programmers_book.chapter3.array;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * packageName : com.example.codingtest.array
 * fileName : makeStar
 * author : taeil
 * date : 2023/10/29
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/10/29        taeil                   최초생성
 */
public class makeStar {
    // Ax + By + C = 0 으로 표현할 수 있는 N개의 직선이 주어질 떄 , 이 직선의 교점 중 정수 좌표에 별을 그리자.

    // 제한사항
    // 1. line의 세로(행) 길이는 2 이상 1000 이하인 자연수
    // line의 가로(열) 길이는 3
    // A, B, C 는 -100000 이상 100000 이하인 정수
    // 무수히 많은 교점이 생기는 직선 쌍은 주어지지 않음
    // 정답은 1000 * 1000 이내에서 표현.
    // 별이 한 개 이상 그려지는 입력만 주어짐.

    // 드럽게 어렵네.. -> 다른 방법..도 찾아보자 있을거임..2차원 배열 말고..


    private static class Point {
        public final long x, y;

        private Point (long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        if (x % 1 != 0 || y % 1 != 0) return null;
        return new Point((long) x, (long) y);
    }


    private Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        for (Point p : points) {
            if(p.x < x) x = p.x;
            if(p.y < y) y = p.y;
        }
        return new Point(x, y);
    }

    private Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for(Point p : points) {
            if(p.x < x) x = p.x;
            if(p.y < y) y = p.y;
        }
        return new Point(x, y);
    }


    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line.length; j++) {
                Point intersection = intersection(line[i][0],line[i][1],line[i][2],
                                                    line[j][0],line[j][1],line[j][2]);

                if(intersection != null) {
                    points.add(intersection);
                }
            }
        }

        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);

        int width = (int) (maximum.x - minimum.x + 1);
        int height = (int) (maximum.y - minimum.y + 1);

        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        for (Point p : points) {
            int x = (int) (p.x - minimum.x);
            int y = (int) (maximum.y - p.y);
            arr[y][x] = '*';
        }

        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }
        return result;
    }

}