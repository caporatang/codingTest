package com.example.codingtest.dataStructure.hashTable.HashTable.collision;

import com.example.codingtest.dataStructure.hashTable.HashTable.BasicHashTable;

/**
 * packageName : com.example.codingtest.dataStructure.hashTable.HashTable.collision
 * fileName : ChaningHashTable
 * author : taeil
 * date : 8/9/24
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 8/9/24        taeil                   최초생성
 */
public class ChaningHashTable {
    public Slot[] hashTable;

    public ChaningHashTable(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;
        Slot next;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public Integer hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        // 주소를 가져오는 부분까지는 동일
        Integer address = this.hashFunc(key);

        if(this.hashTable[address] != null) {
            // 해당 Slot에 해당하는 주소가 있다 -> 그럼 충돌이 일어났기 떄문에 링크드리스트를 만들어 연결해서 저장해야 한다.

            // 링크드리스트 순회할때와 동일하게 일단 head node를 할당하고 시작한다. -> head 부터 하나씩 찾아야 하기 때문이지.
            Slot findSlot = this.hashTable[address];
            Slot prevSlot = this.hashTable[address];

            while (findSlot != null) {
                if (findSlot.key == key) {
                    // 헤드에 있는 Key와 내가 찾는 Key가 동일하다면 value만 업데이트 하면 되는거다.
                    findSlot.value = value;
                    return true;
                } else {
                    // 동일하지 않다면 순회해야 한다.
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            // while문이 끝났다 -> 주소에 해당하는 Key가 없으므로 새로운 Slot을 추가한다.
            // 마지막에 체크한 주소값의 정보는 prevSlot이 가지고 있다 -> prevSlot 다음 Slot에 새로운 데이터를 추가한다.
            prevSlot.next = new Slot(key, value);


        } else {
            this.hashTable[address] = new ChaningHashTable.Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            while (findSlot != null) {
                if(findSlot.key == key) {
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        ChaningHashTable chaningHashTable = new ChaningHashTable(20);
        chaningHashTable.saveData("kim taeil", "01092851101");
        chaningHashTable.saveData("kim kim", "01092851104");
        chaningHashTable.saveData("kim tttt", "01092851105");

        System.out.println(chaningHashTable.getData("kim taeil"));
        System.out.println(chaningHashTable.getData("kim kim"));
        System.out.println(chaningHashTable.getData("kim tttt"));
    }
}