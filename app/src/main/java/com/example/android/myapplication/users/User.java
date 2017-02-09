package com.example.android.myapplication.users;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by peter on 2016-11-03.
 */

public class User implements Serializable {

    private boolean isActiveOnMap;
    private String name;
    private String nickName;
    private String email;
    private String password;
    private String headline;
    private int sumOfScores;
    private int nrOfScores;
    private double latPosition;
    private double longPosition;
    private Marker marker;

    public User(String name, String email, String password, String nickName,int sumOfScores, int nrOfScores, String headline, double latPosition, double longPosition)
    {
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.sumOfScores = sumOfScores;
        this.nrOfScores = nrOfScores;
        this.headline = headline;
        this.latPosition = latPosition;
        this.longPosition = longPosition;
        this.isActiveOnMap = false;
    }

    public User(String name, String email, String password, String nickName, String headline, double latPosition, double longPosition)
    {
        this(name, email, password, nickName,0, 0,  headline, latPosition, longPosition);
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

    public LatLng getPosition() {
        return new LatLng(this.latPosition, this.longPosition);
    }

    public void setPosition(double latPosition, double longPosition) {
        this.latPosition = latPosition;
        this.longPosition = longPosition;
    }

    public void addNewScore(int score) {
        this.sumOfScores += score;
        this.nrOfScores++;
    }

    /**
     * Calculates the mean value of the score given to this user.
     * @return Mean value score with one decimal
     */
    public float getAverageScore() {
        float averageScore = 0;

        if (this.nrOfScores != 0) {
            averageScore = this.sumOfScores / this.nrOfScores;
        }

        return averageScore;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public int getNrOfScores() {
        return nrOfScores;
    }

    public int getSumOfScores() {
        return sumOfScores;
    }

    /**
     * Get a byte array representation of this user
     * @return
     */
    public byte[] getBytes()
    {
        byte[] yourBytes = new byte[1];
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(this);
            out.flush();
            yourBytes = bos.toByteArray();
        }
        catch (IOException ex) {

        }

        finally {
            try {
                bos.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }

        return yourBytes;
    }

    /**
     * Create a user object from a byte array
     * @param bytes
     * @return
     */
    public static User createObjFromBytes(byte[] bytes)
    {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInput in = null;
        User userObj = new User("","","","","",1,2);

        try {
            in = new ObjectInputStream(bis);
            Object o = in.readObject();
            userObj = (User) o;
        }
        catch (IOException ex2)
        {

        }
        catch (ClassNotFoundException ex) {

        }
            finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                // ignore close exception
            }
        }

        return userObj;
    }

    public void updateCurrentPosition() {

    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public Marker getMarker() {
        return marker;
    }

    public boolean getIsActiveOnMap() {
        return isActiveOnMap;
    }

    public void setIsActiveOnMap(boolean isActiveOnMap) {
        this.isActiveOnMap = isActiveOnMap;
    }
}
