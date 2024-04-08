package dao;

import dto.user.SignupDTO;
import entity.UserEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class UserDAOImpl implements UserDAO {

    private static Map<String, UserEntity> db = new HashMap<String, UserEntity>();


    @Override
    public int createOne(SignupDTO signupDTO) throws Exception {
        if(db.get(signupDTO.getId()) != null) {
            throw new IllegalArgumentException();
        }
        db.put(signupDTO.getId(), new UserEntity(signupDTO.getId(), signupDTO.getPassword(), signupDTO.getName()));

        System.out.println(db.get(signupDTO.getId()).getName());
        return 0;
    }

    @Override
    public UserEntity findOneById(String id) throws NoSuchElementException {
        UserEntity userEntity = db.get(id);
        if(userEntity == null)
            throw new NoSuchElementException();

        return userEntity;
    }

    @Override
    public int updateOne(SignupDTO signupDTO) throws NoSuchElementException {
        UserEntity userEntity = db.get(signupDTO.getId());

        if(userEntity == null)
            throw new NoSuchElementException();

        userEntity.setName(signupDTO.getName());
        userEntity.setPassword(signupDTO.getPassword());

        db.put(signupDTO.getId(), userEntity);

        return 0;
    }

    @Override
    public int deleteOne(String id) throws NoSuchElementException {
        UserEntity userEntity = db.get(id);

        if(userEntity == null)
            throw new NoSuchElementException();

        db.remove(id);
        return 0;
    }
}
