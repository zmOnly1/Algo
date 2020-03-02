package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/11.
 */
public class RandomList {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> existNode = new HashMap<>();
        RandomListNode cHead = new RandomListNode(pHead.label);
        existNode.put(pHead, cHead);
        RandomListNode cCurrent = cHead;
        while (pHead.next != null) {
            RandomListNode next = pHead.next;
            RandomListNode random = pHead.random;

            cCurrent.next = getOrCreateIfNotExist(existNode, next);
            cCurrent.random = getOrCreateIfNotExist(existNode, random);

            cCurrent = cCurrent.next;
            pHead = pHead.next;
        }
        if(pHead.random != null){
            cCurrent.random = getOrCreateIfNotExist(existNode, pHead.random);
        }
        return cHead;
    }

    private RandomListNode getOrCreateIfNotExist(Map<RandomListNode, RandomListNode> existNode, RandomListNode node) {
        if(node == null){
            return null;
        }
        RandomListNode newNode;
        if (existNode.containsKey(node)) {
            newNode = existNode.get(node);
        } else {
            newNode = new RandomListNode(node.label);
            existNode.put(node, newNode);
        }
        return newNode;
    }

    class RandomListNode {

        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

}
