package com.example.demo.middleProject;

import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

@Component
public class FileHandler {
    private String target;
    FileWriter fw = null;
    BufferedWriter bw = null;
    FileReader fr = null;
    BufferedReader br = null;
    public void userJoin(User user){
        try{
            fw = new FileWriter(target,true);
            bw = new BufferedWriter(fw);
            bw.write(user.ID + "/" + user.password + "/" + user.name + "/" + user.address + "/" + user.phoneNum + "/" + user.bookID);
            bw.newLine();
            bw.flush();
            System.out.println("회원가입 완료!");
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try { fw.close(); }catch (IOException e) {}
            try { bw.close(); }catch (IOException e) {}
        }
    }
    public ArrayList<User> getUserList(){
        ArrayList<User> userList = new ArrayList<>();
        try {
            fr = new FileReader(target);
            br = new BufferedReader(fr);
            String readLine = null;
            while((readLine = br.readLine()) != null){
                String arr[] = readLine.split("/");
                if (arr.length > 0){
                    User user = new User(arr[0],arr[1],arr[2],arr[3],arr[4], compresString(arr[5]));
                    userList.add(user);
                }
            }
            return userList;
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { fr.close(); }catch (IOException e) {}
            try { br.close(); }catch (IOException e) {}
        }
        return userList;
    }
    public ArrayList<Book> getBookList(){
        ArrayList<Book> bookList = new ArrayList<Book>();
        try {
            fr = new FileReader("LibraryTables");
            br = new BufferedReader(fr);
            String readLine = null;
            String content = null;
            Boolean usable = true;
            ArrayList<String> comments = new ArrayList<>();
            ArrayList<String> reservation = new ArrayList<>();
            while((readLine = br.readLine()) != null) {
                String arr[] = readLine.split("/");
                String strArr[] = readLine.split("\"");
                String title = arr[2];
                if (strArr.length >= 3){
                    title = strArr[1];
                }
                if (arr.length > 0) {
                    if (arr[6].equals("true")) { usable = true; } else { usable = false; }
                    comments = compresString(arr[7]);
                    reservation = compresString(arr[8]);
                    Book book = new Book(arr[0], arr[1], title, arr[3], arr[4], arr[5], usable, comments, reservation);
                    bookList.add(book);
                }
            }
            return bookList;
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { fr.close(); }catch (IOException e) {}
            try { br.close(); }catch (IOException e) {}
        }
        return bookList;
    }
    public String emitString(ArrayList<String> strArr){
        String element = "";
        for(int i = 0; i < strArr.size(); i++){
            element +=strArr.get(i) + "'";
        }
        return "[" + element + "]";
    }
    public ArrayList<String> compresString(String str){
        ArrayList<String> stringList = new ArrayList<>();
        str = str.replace("[","");
        str = str.replace("]","");
        String arr[] = str.split("'");
        for(int i = 0; i < arr.length; i++){
            if(!arr[i].equals(""))
                stringList.add(arr[i]);
        }
        return stringList;
    }
    public void saveContext(ArrayList<Book> bookList,ArrayList<User> userList){
        try {
            fw = new FileWriter("LibraryTables");
            bw = new BufferedWriter(fw);
            for(int i = 0; i < bookList.size(); i++){
                bw.write(bookList.get(i).ID + "/" + bookList.get(i).ISBN + "/" + bookList.get(i).title + "/" + bookList.get(i).author + "/" + bookList.get(i).publisher + "/" + bookList.get(i).pubDate + "/" + bookList.get(i).usable + "/" + emitString(bookList.get(i).comments) + "/" + emitString(bookList.get(i).reservation) + "/");
                bw.newLine();
                bw.flush();
            }
            fw = new FileWriter("UserTable");
            bw = new BufferedWriter(fw);
            for(int i = 0;i < userList.size(); i++){
                User user = userList.get(i);
                bw.write(user.ID + "/" + user.password + "/" + user.name + "/" + user.address + "/" + user.phoneNum + "/" + emitString(user.bookID));
                bw.newLine();
                bw.flush();
            }
        }catch (IOException e) {
            e.printStackTrace();
       } finally {
            try { fw.close(); }catch (IOException e) {}
            try { bw.close(); }catch (IOException e) {}
        }
    }
    public void setTarget(String target) { this.target = target; }
}
