package com.example.android.myapplication.users;


import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * UserHandler keeps user information and provides an interface where that information can be
 * achieved and methods for checking if a user exists among the allowed ones.
 * Created by peter on 2016-11-03.
 */

public class UserHandler {

    private List<User> users;

    public UserHandler(Context context) {

        DatabaseHelper db = new DatabaseHelper(context);

        this.users = new ArrayList<>();

        if (db.getUsersCount() == 0) {

            /* If nothing in database fill it with this test users */
            this.users.add(new User("Nisse", "nisse@mail.com", "pass1", "nizz", "Chocolate balls", 59.310768, 18.069999));
            this.users.add(new User("Tord", "tord@mail.com", "pass2", "MrT", 4, 4, "Fläsklägg", 59.303057, 17.989887));
            this.users.add(new User("Lisa", "Lisa@mail.com", "pass3", "Lisa", 10, 3, "Köttbullar", 59.338792, 18.053402));
            this.users.add(new User("Anna", "Anna@mail.com", "pass4", "Anna", "Körv", 59.341944, 18.10799));
            this.users.add(new User("Kalle Svensson", "ksven@mail.com", "pass5", "Cal", "Sylta", 33, 4));
            // Inserting Contacts
            Log.d("Insert: ", "Inserting ..");
            for (User user : this.users) {
                db.addUserToDb(user);
            }
        }
        else
        {
            for (User user: db.getAllUsers()) {
                this.users.add(user);
            }
        }
    }


    public List<User> getUsers() {
        return this.users;
    }

    /**
     * @param name
     * @param password
     * @return True if the user exists and that the given password is correct
     */
    public boolean checkUser(final String name, final String password) {

        for (User user : this.users) {
            if (user.getName().equals(name) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }
}
