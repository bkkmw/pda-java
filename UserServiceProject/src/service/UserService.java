package service;

import dto.user.LoginDTO;
import dto.user.SignupDTO;

public interface UserService {

    int signup(SignupDTO signupDTO) throws Exception;

    /**
     *
     * @param loginDTO
     * @return
     * @throws java.util.NoSuchElementException
     * @throws IllegalAccessError
     */
    int login(LoginDTO loginDTO) throws Exception;

    int update(SignupDTO signupDTO) throws Exception;

    int delete(String id) throws Exception;
}
