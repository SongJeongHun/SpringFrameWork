package com.example.demo.middleProject;

import org.springframework.stereotype.Component;

import java.io.*;
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
            bw.write(user.ID + "/" + user.password + "/" + user.name + "/" + user.address + "/" + user.phoneNum + "/" + user.bookID + "/");
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
        ArrayList<User> userList = new ArrayList<User>();
        try {
            fr = new FileReader(target);
            br = new BufferedReader(fr);
            String readLine = null;
            while((readLine = br.readLine()) != null){
                String arr[] = readLine.split("/");
                if (arr.length > 0){
                    if (arr[5] == "null"){
                        arr[5] = null;
                    }
                    User user = new User(arr[0],arr[1],arr[2],arr[3],arr[4], Optional.ofNullable(arr[5]));
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
            fr = new FileReader("books.txt");
            br = new BufferedReader(fr);
            String readLine = null;
            while((readLine = br.readLine()) != null){
                String arr[] = readLine.split(",");
                if (arr.length > 0){
                    Book book = new Book(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],true,new ArrayList<String>(),new ArrayList<String>());
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
    public String getTarget() { return target; }
    public void setTarget(String target) { this.target = target; }
}
