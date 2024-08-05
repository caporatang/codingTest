package com.example.codingtest.programmers_book.chapter3.array;

public class 거리두기_확인하기_LV2 {
    // 개발자를 희망하는 죠르디는 카카오에 면접을 보러왔다.
    // 코로나 바이러스 감염 예방을 위해 응시자들은 거리를 둬서 대기를 해야하는데
    // 개발 직군 면접인 만큼 아래와 같은 규칙으로 대기실에 거리를 두고 앉도록 안내하고 있다.

    // 1. 대기실은 5개이며, 각 대기실은 5x5 크기이다.
    // 2. 거리두기를 위하여 응시자들끼리 맨해튼 거리가 2 이하로 앉지 말아 주세요
    // 3. 단 응시자가 앉아 있는 자리 사이가 파티션으로 막혀 있을 경우에는 허용한다.
    // ㅎ므.........흐...................................이ㅏ해가 잘 안되는데


    private static final int dx[] = {0, -1, 1, 0};
    private static final int dy[] = {-1, 0, 0, 1};

    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            if (d == exclude) continue;

            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length)
                continue;
            if (room[ny][nx] == 'P') return true;
        }
        return false;
    }

    private boolean isDistanced(char[][] room, int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length)
                continue;

            switch (room[ny][nx]) {
                case 'P': return false;
                case 'O':
                    if (isNextToVolunteer(room, nx, ny, 3- d)) return false;
                    break;
            }
        }
        return true;
    }

    private boolean isDistanced(char[][] room) {
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] != 'P') continue;
                if (!isDistanced(room, x, y)) return false;
            }
        }
        return true;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < answer.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }
            if (isDistanced(room)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
}




