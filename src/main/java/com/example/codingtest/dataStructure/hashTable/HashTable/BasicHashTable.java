package com.example.codingtest.dataStructure.hashTable.HashTable;

/**
 * packageName : com.example.codingtest.dataStructure.hashTable.HashTable
 * fileName : BasicHashTable
 * author : taeil
 * date : 8/9/24
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 8/9/24        taeil                   최초생성
 */
public class BasicHashTable {
    public Slot[] hashTable;

    public BasicHashTable(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String value;
        Slot(String value) {
            this.value = value;
        }
    }

    /*
    * 간단한 hash Function
    * Key가 문자열일 때, 문자열의 앞 글자를 숫자로 변환해서, Division 기법을 사용하여, Key에 대한 주소(인덱스)를 계산한다.
    * Division 기법 : 가장 간단한 해쉬 함수 중 하나로, 나누기를 통해, 나머지 값을 사용하는 기법이다.
    */
    public Integer hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {

        // 저장 해야되니까 일단 key에 맞는 주소 가져오기
        Integer address = this.hashFunc(key);

        // 주소가 null이 아니면, hashTable은 이미 만들어짐 -> Data가 이미 저장 된적이 있다 -> value만 바꿔주기
        if(this.hashTable[address] != null) {
            this.hashTable[address].value = value;
        } else {
            // null이면 새로운 slot 객체 생성
            this.hashTable[address] = new Slot(value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            return this.hashTable[address].value;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        BasicHashTable basicHashTable = new BasicHashTable(20);
        basicHashTable.saveData("kim taeil", "01092851101");
        basicHashTable.saveData("park taeil", "01092851104");
        basicHashTable.saveData("choi taeil", "01092851105");

        System.out.println(basicHashTable.getData("park taeil"));
        System.out.println(basicHashTable.getData("kim taeil"));
        System.out.println(basicHashTable.getData("choi taeil"));
    }
}