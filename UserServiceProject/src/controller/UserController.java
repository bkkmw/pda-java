package controller;

import dto.user.LoginDTO;
import dto.user.SignupDTO;
import service.UserService;
import service.UserServiceImpl;

import java.net.http.HttpRequest;

public class UserController {

    private UserService userService;

    public UserController() {
        this.userService = new UserServiceImpl();
    }

    public int signup(SignupDTO signupDTO) {
        try {
            // validation
            return userService.signup(signupDTO);

        } catch (Exception e) {

            return -1;
        }
    }

    public int login(LoginDTO loginDTO) {
        try {

            return userService.login(loginDTO);

        } catch (Exception e) {

            return -1;
        }
    }

    public int modify(String token, SignupDTO signupDTO) {
        try {
            if("".equals(token) || !checkAuth(token, signupDTO.getId()))
                return 401;

            // valid

            return userService.update(signupDTO);
        } catch (Exception e) {

            return -1;
        }
    }

    public int delete(String token, String id) {
        try {
            if("".equals(token) || !checkAuth(token, id))
                return 401;

            // validation
            return userService.delete(id);
        } catch (Exception e) {

            return -1;
        }
    }

    public boolean checkAuth(String token, String id) {
        if(token.equals(id)) return true;
        else return false;
    }

}
