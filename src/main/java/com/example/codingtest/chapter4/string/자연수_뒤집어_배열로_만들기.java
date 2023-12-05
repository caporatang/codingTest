package com.example.codingtest.chapter4.string;

/**
 * packageName : com.example.codingtest.chapter4.string
 * fileName : 자연수_뒤집어_배열로_만들기
 * author : taeil
 * date : 12/5/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 12/5/23        taeil                   최초생성
 */
public class 자연수_뒤집어_배열로_만들기 {
    // 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴
    // ex) n이 12345 라면 [5,4,3,2,1]

    // 1. 입력받은 숫자를 문자열로 변환합니다.
    // 2. 문자열을 뒤집습니다.
    // 3. 뒤집힌 문자열을 문자의 배열로 변환합니다.
    // 4. 배열의 각 문자를 정수로 변환합니다.

    public int[] solution(long n) {
        // 입력받은 숫자를 문자열로 변환한다. -> 숫자를 문자열로
        String str = Long.toString(n);

        // 문자열을 뒤집기 ~
        String reversed = new StringBuilder(str).reverse().toString();
        // 뒤집힌 문자열을 문자의 배열로 변환
        char[] arr = reversed.toCharArray();

        // 배열로 변환..!
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i] - '0';
        }
        return result;
    }
}