package com.example.codingtest.programmers_book.chapter4.string;

/**
 * packageName : com.example.codingtest.chapter4.string
 * fileName : 시저_암호
 * author : taeil
 * date : 12/5/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 12/5/23        taeil                   최초생성
 */
public class 시저_암호 {
    // 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고한다.
    // "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 된다. "z"는 1만큼 밀면 "a"

    // 제한 사항
    // 공백은 밀어도 공백이다.
    // s는 알파벳 소문자, 대문자, 공백으로만 구성되어 있다.
    // s의 길이는 8000 이하임
    // n은 1 이상, 25이하인 자연수입니다.

    // 코드 풀이 흐름
    // 1. 입력 문자열의 모든 문자에 대해 반복
    // A. 알파벳이 아닌 경우 문자를 그대로 이어 붙이기
    // B. 알파벳인 경우 n만큼 밀어 이어 붙이기

    private char push(char c, int n) {
        // 입력 문자를 n만큼 민 문자를 반환하는 메서드
        if (!Character.isAlphabetic(c)) return c;
            // c를 n만큼 밀어 반환한다.

            // Z까지 간다면 0으로 돌아와야한다.
            // position을 계산하고 offset으로 나머지를 연산해서 리턴한다
            int offset = Character.isUpperCase(c) ? 'A' : 'a';
            int position = c - offset;
            position = (position + n) % ('Z' - 'A' + 1);
            return (char) (offset + position);
    }

    public String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            // c를 n 만큼 민 문자를 builder에 이어 붙이기
            builder.append(push(c, n));
        }
        return builder.toString();
    }
}