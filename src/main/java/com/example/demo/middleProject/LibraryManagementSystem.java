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
    User currentUser;
    int userIndex;
    Scanner sc;
    FileHandler fh;
    Boolean loop = true;
    int currentMenu;
    public void setUserList(ArrayList<User> userList) { this.userList = userList; }
    public void setLibrary(ArrayList<Book> library) { this.library = library;  }
    public void setCurrentUser(User user){ this.currentUser = user; }
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
                    System.out.println("로그인 성공, 어서오세요 " + currentUser.name + " 님 !");
                    popLibraryMenu();
                    break;
                }else{
                    System.out.println("로그인 실패!");
                    popUserMenu();
                    break;
                }
            case 2:
                userJoin();
                break;
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
                break;
            case 2:
                lending();
                break;
            case 3:
                returning();
                break;
            case 4:
                reserving();
                break;
            case 0:
                loop = false;
                break;
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
        int menu;
        System.out.println("----------------도서검색 서비스입니다.----------------");
        System.out.println("1.도서검색\t2.전체보기\t3.대여가능도서보기");
        menu = sc.nextInt();
        switch(menu){
            case 1:
                System.out.println("제목을 입력해 주세요 : ");
                String title = sc.next();
                ArrayList<Book> result = searchingByTitle(title);
                if(result.size() != 0){
                    System.out.println("검색결과 " + result.size() + "개가 있습니다.");
                    for(int i = 0 ; i < result.size(); i++){
                        String usable = "대여 가능";
                        if(result.get(i).usable == false){
                            usable = "대여 불가";
                        }
                        System.out.println(result.get(i).ID + "\t" + result.get(i).ISBN + "\t" + result.get(i).title + "\t" + result.get(i).author + "\t" + result.get(i).publisher + "\t" + usable);
                    }
                    popLibraryMenu();
                }else{
                    System.out.println("검색결과가 없습니다.");
                    popLibraryMenu();
                }
                break;
            case 2:
                for(int i  = 0 ; i < library.size(); i++){
                    String usable = "대여 가능";
                    if(library.get(i).usable == false){
                        usable = "대여 불가";
                    }
                    System.out.println(library.get(i).ID + "\t" + library.get(i).ISBN + "\t" + library.get(i).title + "\t" + library.get(i).author + "\t" + library.get(i).publisher + "\t" + usable);
                }
                popLibraryMenu();
                break;
            case 3:
                for(int i  = 0 ; i < library.size(); i++){
                    if(library.get(i).usable == true){
                        System.out.println(library.get(i).ID + "\t" + library.get(i).ISBN + "\t" + library.get(i).title + "\t" + library.get(i).author + "\t" + library.get(i).publisher + "\t");
                    }
                }
                popLibraryMenu();
                break;
        }
    }
    public ArrayList<Book> searchingByTitle(String title){
        ArrayList<Book> result = new ArrayList<>();
        for(int i = 0; i < library.size();i++ ) {
            if (library.get(i).title.contains(title)) {
                result.add(library.get(i));
            }
        }
        return result;
    }
    public int searchingByNum(String num){
        int result = -1;
        for(int i = 0; i < library.size();i++ ) {
            if (library.get(i).ID.equals(num)) {
                result = i;
            }
        }
        return result;
    }
    @Override
    public void lending() {
        int menu;
        System.out.println("----------------도서대여 서비스입니다.----------------");
        System.out.println("현재 빌리신 책은 " + currentUser.bookID.size() + " 개 입니다.");
        System.out.println("1.도서대여\t2.대여가능횟수조회");
        menu = sc.nextInt();
        switch (menu){
            case 1:
                if(currentUser.bookID.size() >= 5){
                    System.out.println("5권 이상은 빌릴수 없습니다. 반납후 이용해주세요.");
                    popLibraryMenu();
                    break;
                }
                String bookNum;
                System.out.println("빌리실 책의 번호를 입력해주세요 : ");
                bookNum = sc.next();
                int index = searchingByNum(bookNum);
                if(index == -1){
                    System.out.println("잘못된 번호입니다.");
                    popLibraryMenu();
                    break;
                }else{
                    if(library.get(index).usable){
                        int confirm;
                        System.out.println("대여 가능한 책입니다. 빌리시겠습니까 ?");
                        System.out.println("1.확인\t2.취소");
                        confirm = sc.nextInt();
                        if(confirm == 1){
                            System.out.println("대여완료!");
                            library.get(index).usable = false;
                            userList.get(userIndex).bookID.add(library.get(index).title + "/" + bookNum);
                            currentUser = userList.get(userIndex);
                            popLibraryMenu();
                            break;
                        }else{
                            System.out.println("취소되었습니다.");
                            popLibraryMenu();
                            break;
                        }
                    }else{
                        System.out.println("이미 대여된 책입니다.");
                        popLibraryMenu();
                        break;
                    }
                }
            case 2:
                System.out.println(5 - currentUser.bookID.size() + " 권 대여 가능합니다.");
                popLibraryMenu();
                break;
        }
    }
    @Override
    public void returning() {
        int menu;
        System.out.println("----------------도서반납 서비스입니다.----------------");
        if(currentUser.bookID.size() == 0){
            System.out.println("반납할 책이 없습니다.");
            popLibraryMenu();
            return;
        }
        for(int i = 0; i < currentUser.bookID.size(); i++){
            System.out.print("[ " + i + " ] ");
            System.out.println(currentUser.bookID.get(i));
        }
        System.out.println("반납 하실 책의 번호를 입력해주세요(0 ~ 4) : ");
        menu = sc.nextInt();
        String bookNum = currentUser.bookID.get(menu).split("/")[1];
        currentUser.bookID.remove(menu);
        library.get(searchingByNum(bookNum)).usable = true;
        System.out.println("반납완료!");
        popLibraryMenu();
    }
    @Override
    public void reserving() {
        String menu;
        System.out.println("----------------도서예약 서비스입니다.----------------");
        System.out.println("1.예약가능 도서확인");
        for(int i = 0 ; i < library.size(); i++){
            if(!library.get(i).usable){
                System.out.print("[ " + library.get(i).ID+ " ] ");
                System.out.println(library.get(i).ISBN +"\t"+ library.get(i).title + "\t" + library.get(i).author + "\t" + library.get(i).publisher);
            }
        }
        System.out.println("예약할 책의 번호를 입력해주세요 :");
        menu = sc.next();
        library.get(searchingByNum(menu)).reservation.add(currentUser.ID);
        System.out.println("예약 완료!");
        popLibraryMenu();
    }
    @Override
    public void userJoin() {
        String ID;
        String password;
        String name;
        String phoneNum;
        String address;
        ArrayList<String> owner = new ArrayList<>();
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
            if (userList.get(i).ID.equals(userID) && userList.get(i).password.equals(userPwd)) {
                setCurrentUser(userList.get(i));
                userIndex = i;
                return true;
            }
        }
        return false;
    }
}
