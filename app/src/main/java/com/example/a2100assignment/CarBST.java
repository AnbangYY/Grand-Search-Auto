package com.example.a2100assignment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class CarBST<T extends Comparable<T>> {

    Node<T> root;
    ArrayList<T> sorted = new ArrayList<>();

    public CarBST() {
        root = null;
    }

    public CarBST(Node root){
        this.root = root;
    }

    public T Maximum() {
        Node<T> local = root;
        if (local == null)
            return null;
        while (local.getRight() != null)
            local = local.getRight();
        return local.getData();
    }

    public T Minimum() {
        Node<T> local = root;
        if (local == null)
            return null;
        while (local.getLeft() != null) {
            local = local.getLeft();
        }
        return local.getData();
    }

    private int depth(){
        return depth(root);
    }

    private int depth(Node<T> node) {
        if (node == null)
            return 0;
        return node.getDepth();
        // 1 + Math.max(depth(node.getLeft()), depth(node.getRight()));
    }
    public ArrayList<T> smallToBig(){
        return smallToBig(root);
    }



    public ArrayList<T> smallToBig(Node<T> node){
        if(node!=null){
            smallToBig(node.getLeft());
            sorted.add((node.getData()));
            smallToBig(node.getRight());

        }
        return sorted;
    }

    public ArrayList<T> bigToSmall() {
        return bigToSmall(root);
    }

    public ArrayList<T> bigToSmall(Node<T> node){
        if(node!=null){
            bigToSmall(node.getRight());
            sorted.add((node.getData()));
            bigToSmall(node.getLeft());
        }
        return sorted;
    }

    public Node<T> insert(T data) {
        root = insert(root, data);
        switch (balanceNumber(root)) {
            case 1:
                root = rotateLeft(root);
                break;
            case -1:
                root = rotateRight(root);
                break;
            default:
                break;
        }
        return root;
    }
    public Node<T> greaterCut(T data){
        Node<T> duplicate = root;
        duplicate = greaterCut(duplicate, data);
        return duplicate;
    }



    public Node<T> greaterCut(Node<T> node, T data){
        if(node.getData().compareTo(data)>0){
            node=node.getRight();
            greaterCut(node.getRight(), data);
        }
        else{
            return node;
        }
        return null;
    }

    public Node<T> smallerCut(T data){
        Node<T> duplicate = root;
        duplicate = smallerCut(duplicate, data);
        return duplicate;
    }

    public Node<T> smallerCut(Node<T> node, T data){
        if(node.getData().compareTo(data)<0){
            node=node.getLeft();
            greaterCut(node.getLeft(), data);
        }
        else{
            return node;
        }
        return null;
    }

    public Boolean isEmpty(){
        return this.root==null;
    }

    public Node<T> insert(Node<T> node, T data) {
        if (node == null)
            return new Node<T>(data);
        if (node.getData().compareTo(data) > 0) {
            node = new Node<T>(node.getData(), insert(node.getLeft(), data),
                    node.getRight());
            // node.setLeft(insert(node.getLeft(), data));
        } else if (node.getData().compareTo(data) <=0) {
            // node.setRight(insert(node.getRight(), data));
            node = new Node<T>(node.getData(), node.getLeft(), insert(
                    node.getRight(), data));
        }
        // After insert the new node, check and rebalance the current node if
        // necessary.
        switch (balanceNumber(node)) {
            case 1:
                node = rotateLeft(node);
                break;
            case -1:
                node = rotateRight(node);
                break;
            default:
                return node;
        }
        return node;
    }

    private int balanceNumber(Node<T> node) {
        int L = depth(node.getLeft());
        int R = depth(node.getRight());
        if (L - R >= 2)
            return -1;
        else if (L - R <= -2)
            return 1;
        return 0;
    }


    private Node<T> rotateLeft(Node<T> node) {
        Node<T> q = node;
        Node<T> p = q.getRight();
        Node<T> c = q.getLeft();
        Node<T> a = p.getLeft();
        Node<T> b = p.getRight();
        q = new Node<T>(q.getData(), c, a);
        p = new Node<T>(p.getData(), q, b);
        return p;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> q = node;
        Node<T> p = q.getLeft();
        Node<T> c = q.getRight();
        Node<T> a = p.getLeft();
        Node<T> b = p.getRight();
        q = new Node<T>(q.getData(), b, c);
        p = new Node<T>(p.getData(), a, q);
        return p;
    }

    private int countNode(){
        return countNode(root);
    }


    private int countNode(Node<T> node){
        if(node==null){
            return 0;
        }
        else{
            int count = 1;
            count+=countNode(node.getLeft());
            count+=countNode(node.getRight());
            return count;
        }
    }

    public boolean search(T data) {
        Node<T> local = root;
        while (local != null) {
            if (local.getData().compareTo(data) == 0)
                return true;
            else if (local.getData().compareTo(data) > 0)
                local = local.getLeft();
            else
                local = local.getRight();
        }
        return false;
    }

    public String toString() {
        return root.toString();
    }


@Test
public void checkAVLTree(){
    ArrayList<Car> GTAcars = new ArrayList<>();
    try {

        BufferedReader b = new BufferedReader(new FileReader("C:\\Users\\75564\\AndroidStudioProjects\\2100Assignment\\app\\src\\main\\assets\\GTACars.json"));
        JsonReader jsonReader = new JsonReader(b);
        Gson gson = new Gson();
        final Type CUS_LIST_TYPE = new TypeToken<ArrayList<Car>>() {
        }.getType();
        GTAcars = gson.fromJson(jsonReader, CUS_LIST_TYPE);
    } catch (Exception e) {
        e.printStackTrace();
    }
    CarBST<Car> tree = new CarBST<>();

    for (Car c:GTAcars
         ) {
        tree.insert(c);
    }

    assertEquals(459, GTAcars.size());
    boolean b = tree.isEmpty();
    assertEquals(459, tree.countNode());

}
}
