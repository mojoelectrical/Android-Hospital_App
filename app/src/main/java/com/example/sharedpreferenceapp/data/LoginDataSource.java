package com.example.sharedpreferenceapp.data;

import android.widget.Toast;

import com.example.sharedpreferenceapp.Nurse;
import com.example.sharedpreferenceapp.SecondMainActivity;
import com.example.sharedpreferenceapp.data.model.LoggedInUser;

import java.io.IOException;
import java.util.List;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    List<Nurse> nurses = SecondMainActivity.patientDB2.hospitalDao().getnurses();
    public Result<LoggedInUser> login(String username, String password) {
    String name="";
        try {
            for (Nurse nur:nurses){
                if (Integer.parseInt(username) == nur.getNurseId()){
                    if (password.equals(nur.getPassword())){
                        name = " " + nur.getFirstname() + " " + nur.getLastname() + " signed in";
                        LoggedInUser fakeUser =
                                new LoggedInUser(
                                        java.util.UUID.randomUUID().toString(),
                                        name);
                        return new Result.Success<>(fakeUser);
                    }}}

            return null;
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}