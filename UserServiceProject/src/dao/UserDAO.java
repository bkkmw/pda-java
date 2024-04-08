package dao;

import dto.user.SignupDTO;
import entity.UserEntity;

import java.util.NoSuchElementException;

public interface UserDAO {
    // CRUD
    int createOne(SignupDTO signupDTO) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws NoSuchElementException not found
     */
    UserEntity findOneById(String id) throws NoSuchElementException;

    int updateOne(SignupDTO signupDTO) throws NoSuchElementException;

    int deleteOne(String id) throws NoSuchElementException;

}
