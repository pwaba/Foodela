package com.example.android.myapplication.users;

import java.text.DecimalFormat;

/**
 * Created by peter on 2016-11-03.
 */

public class User {

    private String name;
    private String nickName;
    private String email;
    private String password;
    private int sumOfScores;
    private int nrOfScores;

    public User(String name, String nickName, String email, String password, int sumOfScores, int nrOfScores)
    {
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.sumOfScores = sumOfScores;
        this.nrOfScores = nrOfScores;
    }

    public User(String name, String email, String password, String nickName)
    {
        this(name, email, password, nickName, 0, 0);
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addNewScore(int score) {
        this.sumOfScores += score;
        this.nrOfScores++;
    }

    /**
     * Calculates the mean value of the score given to this user.
     * @return Mean value score with one decimal
     */
    public String getAverageScore() {
        double averageScore = 0;
        final DecimalFormat df = new DecimalFormat("#.#");

        if (this.nrOfScores != 0) {
            averageScore = this.sumOfScores / this.nrOfScores;
        }

        return df.format(averageScore);
    }

}
