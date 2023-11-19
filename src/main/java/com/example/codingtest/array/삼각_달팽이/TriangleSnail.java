package com.example.codingtest.array.삼각_달팽이;

public class TriangleSnail {
    // 삼각 달팽이
    // 정수 n이 매개변수로 주어짐
    // 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후,
    // 첫 행부터 마지막 행까지 모두  순서대로 합친 새로운 배열을 return

    public class Solution {
        public int[] solution(int n) {
            int[][] triangle = new int[n][n];
            int v = 1;
            int x = 0;
            int y = 0;

            while (true) {
                // 아래로 이동
                while (true) {
                    triangle[y][x] = v++;
                    if (y + 1 == n || triangle[y + 1][x] != 0) break;
                    y += 1;
                }
                if (x + 1 == n || triangle[y][x + 1] != 0) break;
                x += 1;

                // 오른쪽으로 이동
                while (true) {
                    triangle[y][x] = v++;
                    if (x + 1 == n || triangle[y][x + 1] != 0) break;
                    x += 1;
                }
                if (triangle[y - 1][x - 1] != 0) break;
                x -= 1;
                y -= 1;

                // 왼쪽 위로 이동
                while (true) {
                    triangle[y][x] = v++;
                    if (triangle[y - 1][x - 1] != 0) break;
                    x -= 1;
                    y -= 1;
                }
                if (y + 1 == n || triangle[y + 1][x] != 0) break;
                y += 1;
            }

            int[] result = new int[v - 1];
            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    result[index++] = triangle[i][j];
                }
            }

            return result;
        }
    }
    // ㅇ ㅏ ..드럽게 어렵다
}
