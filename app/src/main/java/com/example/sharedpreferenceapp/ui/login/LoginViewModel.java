package com.example.sharedpreferenceapp.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.util.Patterns;

import com.example.sharedpreferenceapp.Nurse;
import com.example.sharedpreferenceapp.SecondMainActivity;
import com.example.sharedpreferenceapp.data.LoginRepository;
import com.example.sharedpreferenceapp.data.Result;
import com.example.sharedpreferenceapp.data.model.LoggedInUser;
import com.example.sharedpreferenceapp.R;

import java.util.List;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;

    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String username, String password) {
        // can be launched in a separate asynchronous job

        Result<LoggedInUser> result = loginRepository.login(username, password);

        if (result instanceof Result.Success) {
            LoggedInUser data = ((Result.Success<LoggedInUser>) result).getData();
            loginResult.setValue(new LoginResult(new LoggedInUserView(data.getDisplayName())));
        } else {
            loginResult.setValue(new LoginResult(R.string.login_failed));
        }
    }

    public void loginDataChanged(String username, String password) {

        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState( R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        }
        else if (!doesNurseExist(username,password)){
            loginFormState.setValue(new LoginFormState( R.string.invalid_username2, null));
        }
        else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        else {
            return !username.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 0;
    }

    private boolean doesNurseExist(String username, String password){
        List<Nurse> nurses = SecondMainActivity.patientDB2.hospitalDao().getnurses();
        for (Nurse nur:nurses){
            if (Integer.parseInt(username) == nur.getNurseId()){
                if (password.equals(nur.getPassword())){
                    return true;
                }}}
        return false;
    }
}