package com.example.demo.middleProject;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

@Component
public class LibraryManagementSystem implements LibraryManaging, UserManaging, InitializingBean, DisposableBean {
    ArrayList<Book> library;
    ArrayList<User> userList;
    Scanner sc;
    FileHandler fh;
    Boolean loop = true;
    int currentMenu;
    public void setUserList(ArrayList<User> userList) { this.userList = userList; }
    public void setLibrary(ArrayList<Book> library) { this.library = library;  }
    public void setSc(Scanner sc) {
        this.sc = sc;
    }
    public void setFh(FileHandler fh) {
        this.fh = fh;
    }
    public void popUserMenu(){
        int selected;
        fh.setTarget("UserTable");
        System.out.println("1.로그인\t2.회원가입\t0.종료\t");
        selected = sc.nextInt();
        switch (selected){
            case 1:
                if (userLogin()){
                    System.out.println("로그인 성공!");
                    popLibraryMenu();
                    return;
                }else{
                    System.out.println("로그인 실패!");
                    popUserMenu();
                }
            case 2:
                userJoin();
            case 0:
                loop = false;
        }
    }
    public void popLibraryMenu(){
        fh.setTarget("LibraryTable");
        System.out.println("----------------도서관리 시스템----------------");
        System.out.println("1.도서검색\t2.도서대여\t3.도서반납\t4.도서예약\t0.종료");
        currentMenu = sc.nextInt();
        switch (currentMenu){
            case 1:
                searching();
                return;
            case 2:
                lending();
                return;
            case 3:
                returning();
                return;
            case 4:
                reserving();
                return;
            case 0:
                loop = false;
                return;
        }
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("----------------도서관리 시스템 종료----------------");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("----------------도서관리 시스템 시작----------------");
    }
    @Override
    public void searching() {
        System.out.println("----------------도서검색 서비스입니다.----------------");
        for(int i = 0; i < library.size(); i ++){
            System.out.println(library.get(i).title + "/" + library.get(i).author);
        }
    }
    @Override
    public void lending() {
        System.out.println("----------------도서대여 서비스입니다.----------------");

    }
    @Override
    public void returning() {
        System.out.println("----------------도서반납 서비스입니다.----------------");

    }
    @Override
    public void reserving() {
        System.out.println("----------------도서예약 서비스입니다.----------------");

    }
    @Override
    public void userJoin() {
        String ID;
        String password;
        String name;
        String phoneNum;
        String address;
        Optional<String> owner = null;
        System.out.print("\n아이디를 입력해주세요. : ");
        ID = sc.next();
        System.out.print("비밀번호를 입력해주세요. : ");
        password = sc.next();
        System.out.print("이름을 입력해주세요. : ");
        name = sc.next();
        System.out.print("휴대폰번호를 입력해주세요. : ");
        phoneNum = sc.next();
        System.out.print("주소를 입력해주세요. : ");
        address = sc.next();
        User user = new User(ID,password,name,phoneNum,address,owner);
        fh.userJoin(user);
        popUserMenu();
    }
    @Override
    public Boolean userLogin() {
        String userID;
        String userPwd;
        System.out.print("\n아이디를 입력해주세요. : ");
        userID = sc.next();
        System.out.println();
        System.out.print("비밀번호를 입력해주세요. : ");
        userPwd = sc.next();
        return getDB(userID,userPwd);
    }
    @Override
    public Boolean getDB(String userID,String userPwd){
        for(int i = 0; i < userList.size(); i++) {
            if (userList.get(i).ID.equals(userID) && userList.get(i).password.equals(userPwd)) return true;
        }
        return false;
    }
}
