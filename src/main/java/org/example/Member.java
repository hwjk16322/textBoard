package org.example;

public class Member {
    String userId;
    String UserPW;



    public Member(String userid , String userpw){
        this.userId = userid;
        this.UserPW = userpw;
    }
    public String getUserId(){
        return this.userId;
    }
}
