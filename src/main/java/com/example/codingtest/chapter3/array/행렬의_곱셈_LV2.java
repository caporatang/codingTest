package com.example.codingtest.chapter3.array;

public class 행렬의_곱셈_LV2 {
    // 2차원 행렬 arr1 과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수를 리턴
    // 제한 조건
    // 1. 행렬 arr1, arr2의 행과 열의 길이는 2이상 100 이하입니다
    // 2. 행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
    // 3. 곱할 수 있는 배열만 주어집니다
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] arr = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 0;
                for (int k = 0; k < arr1[i].length; k++) {
                    arr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return arr;
    }
}
