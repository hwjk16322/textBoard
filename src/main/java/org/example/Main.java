package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==프로그램 시작==");
        System.out.println("스캐너 입력받기");
        List<Article> registed = new ArrayList<>();
        List<Member> memberList = new ArrayList<>();
        int registedNumber = 0;
        while (true) {
            System.out.print("명령어 ) ");
            String command = sc.nextLine().trim();
            System.out.println("입력된 명령어 : " + command);

            if (command.equals("종료")) {
                System.out.println("==프로그램 끝==");
                break;
            }
            if (command.equals("등록")) {
                registedNumber++;
                System.out.printf("제목 입력 ) ");
                String title = sc.nextLine();
                System.out.printf("내용 입력 ) ");
                String content = sc.nextLine();
                Article article = new Article(registedNumber, title, content);
                registed.add(article);

                System.out.println("제목 : " + title + "\n내용 : " + content + "\n" + registedNumber + "번 게시물이 등록되었습니다.");
            }
            if (command.equals("목록")) {
                System.out.println("번호 / 제목 / 내용");
                for (int i = 0; i < registed.size(); i++) {

                    System.out.println(registed.get(i).id + " / " + registed.get(i).title + " / " + registed.get(i).content);
                }
            }
            if (command.equals("삭제")) {
                System.out.printf("삭제 번호) ");
                long id = Long.parseLong(sc.nextLine());

                for (int i = 0; i < registed.size(); i++) {
                    Article article = registed.get(i);
                    if (article.getId() == id) {
                        registed.remove(article);
                        System.out.println(id + "번 게시글이 삭제 되었습니다.");
                    } else {
                        System.out.println("일치 하는 아이디가 없습니다");
                    }
                }
            }

            if (command.equals("수정")) {
                System.out.printf("수정 번호) ");
                long id = Long.parseLong(sc.nextLine());

                long foundIndex = -1;

                for (int i = 0; i < registed.size(); i++) {
                    Article article = registed.get(i);
                    if (article.getId() == id) {
                        foundIndex = id;

                        System.out.printf("기존 제목: %s\n", article.getTitle());
                        String title = sc.nextLine();
                        article.setTitle(title);

                        System.out.printf("기존 내용: %s\n", article.getContent());
                        String content = sc.nextLine();
                        article.setContent(content);

                        break;
                    }
                }

                if (foundIndex == -1) {
                    System.out.println(id + "번째 게시물은 존재하지 않습니다.");
                } else {
                    System.out.println(id + "번째 게시글이 수정 되었습니다.");
                }
            }

            if (command.equals("회원가입")) {
                String userId;
                while (true) {
                    boolean checkId = false;
                    System.out.println("사용할 아이디 입력");
                    System.out.printf("입력 ) ");
                    userId = sc.nextLine();
                    for (int i = 0; i < memberList.size(); i++) {
                        if (userId.equals(memberList.get(i).getUserId())) {
                            System.out.println("이미 사용중인 아이디입니다.");
                            checkId = true;
                        }

                    }
                    if (checkId == true) {
                        continue;
                    }
                    break;
                }

                while (true) {
                    System.out.println("사용할 비밀번호 입력");
                    System.out.printf("입력 ) ");
                    String userPW = sc.nextLine();
                    System.out.println("비밀번호 확인");
                    System.out.printf("입력 ) ");
                    String userPWCheck = sc.nextLine();
                    if (userPW.equals(userPWCheck)) {
                        Member member = new Member(userId, userPW);
                        memberList.add(member);
                        break;
                    } else {
                        System.out.println("비밀번호가 다릅니다. 다시 입력해주세요");
                    }
                }
                System.out.println("회원가입이 완료되었습니다.");
            }
        }
    }
}