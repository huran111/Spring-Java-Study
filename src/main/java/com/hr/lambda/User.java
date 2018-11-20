package com.hr.lambda;

/**
 * @author huran
 * @Title: User
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/2310:04
 */
public class User {
    private String userID;
    private boolean isVip;
    private int balance;

    public User(String userID, boolean isVip, int balance)
    {
        this.userID = userID;
        this.isVip = isVip;
        this.balance = balance;
    }

    public boolean isVip()
    {
        return this.isVip;
    }

    public String getUserID()
    {
        return this.userID;
    }

    public int getBalance()
    {
        return this.balance;
    }

}
