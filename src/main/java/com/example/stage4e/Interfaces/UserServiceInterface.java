package com.example.stage4e.Interfaces;


import com.example.stage4e.Entities.User;


public interface UserServiceInterface {


    int enableAppUser(String email);

    String signUpUser(User appUser);

    public Object getUserByEmail(String email);

    User editUser(User user);

   // public List<User> findAdmins();
}

