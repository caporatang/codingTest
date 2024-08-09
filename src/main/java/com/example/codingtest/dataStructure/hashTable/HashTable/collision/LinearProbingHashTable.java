package com.example.codingtest.dataStructure.hashTable.HashTable.collision;

/**
 * packageName : com.example.codingtest.dataStructure.hashTable.HashTable.collision
 * fileName : LinearProbingHashTable
 * author : taeil
 * date : 8/9/24
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 8/9/24        taeil                   최초생성
 */
public class LinearProbingHashTable {
    public Slot[] hashTable;

    public LinearProbingHashTable(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunc(String key) {
        // 최대한 충돌이 없게끔 hash 함수를 정의하는것이 중요하다.
        int keyNumber = 0;
        for (int i = 0; i < key.length(); i++) {
            keyNumber += key.charAt(i);
        }

        return (keyNumber) % 200;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if(this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            } else {
                Integer currAddress = address + 1; // 다음 주소를 현재 주소로 할당
                while (this.hashTable[currAddress] != null) { // 해당 Slot이 있는지부터 체크
                    if (this.hashTable[currAddress].key == key) { // 현재 주소의 Key값이 내가 찾고싶은 Key인지를 체크
                        this.hashTable[currAddress].value = value; // 맞다면 값을 업데이트한다.
                        return true;
                    } else {
                        // Key가 동일하지 않은 경우 다음 주소로 이동
                        // 순회하다가 HashTable의 길이를 초과하는 경우 false를 반환한다.
                        currAddress++;
                        if(currAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                }
                this.hashTable[currAddress] = new Slot(key, value);
                return true;
            }

        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if(this.hashTable[address].key == key) {
                return this.hashTable[address].value;
            } else {
                Integer currAddress = address;
                while (this.hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key == key) {
                        return this.hashTable[currAddress].value;
                    } else {
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return null;
                        }
                    }
                }
                return null;
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        LinearProbingHashTable linearProbingHashTable = new LinearProbingHashTable(200);
        linearProbingHashTable.saveData("kim taeil", "01092851101");
        linearProbingHashTable.saveData("kim kim", "01092851104");
        linearProbingHashTable.saveData("kim tttt", "01092851105");

        System.out.println(linearProbingHashTable.getData("kim taeil"));
        System.out.println(linearProbingHashTable.getData("kim kim"));
        System.out.println(linearProbingHashTable.getData("kim tttt"));

        System.out.println("=============== 해쉬함수 재정의 테스트 ===============");
        System.out.println(linearProbingHashTable.hashFunc("kim taeil"));
        System.out.println(linearProbingHashTable.hashFunc("kim gugu"));
        System.out.println(linearProbingHashTable.hashFunc("kim gogo"));
    }


}