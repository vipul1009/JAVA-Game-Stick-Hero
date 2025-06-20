//package com.example.javafx;
//
//import java.io.FileOutputStream;
//import java.io.ObjectInputStream;
//import java.io.Serializable;
//
//public class ObjectSerialize throws IOException {
//        ObjectOutputStream out = null;
//        Score sc = new Score();
//
//        try {
//        out = new ObjectOutputStream(new FileOutputStream("ForScore.txt"));
//        out.writeObject(sc);
//        } catch (IOException e) {
//        e.printStackTrace();
//        } finally {
//        try {
//        if (out != null) {
//        out.close();
//        }
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//}
