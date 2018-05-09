package com.example.fiuady.chatapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface UsersDao {

    @Query("SELECT * FROM users")
    List<UsersTable> getUsers();

    @Query("SELECT * FROM users WHERE last_name LIKE :last_name") //referencia a un parámetro con autocompletar
    UsersTable getUserByLastName(String last_name);

    @Query("SELECT * FROM users WHERE id in (:ids)")
    List<UsersTable> getUserById(int[] ids);

    @Query("SELECT first_name FROM users WHERE id = :id")
    String getFirstNameById(int id);

    @Query("SELECT last_name FROM users WHERE id = :id")
    String getLastNameById(int id);

    @Query("SELECT phone_number FROM users WHERE id = :id")
    int getPhoneNumberById(int id);


    @Query("SELECT MAX(id) FROM users")
    int getMaxId();

    @Insert
    void InsertUser(UsersTable user);

    @Update
    void UpdateUser(UsersTable user);
}
