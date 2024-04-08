package service;

import dao.UserDAO;
import dao.UserDAOImpl;
import dto.user.LoginDTO;
import dto.user.SignupDTO;
import entity.UserEntity;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl() {
        this.userDAO = new UserDAOImpl();
    }

    @Override
    public int signup(SignupDTO signupDTO) throws Exception {
        try {
            // create
            userDAO.createOne(signupDTO);
            return 0;
        } catch (Exception e) {
            System.out.println("");
        }
        return -1;
    }

    @Override
    public int login(LoginDTO loginDTO) throws Exception {

        UserEntity userEntity = userDAO.findOneById(loginDTO.getId());

        if(userEntity.getPassword().equals(loginDTO.getPassword())) {
            return 0;
        } else {
            throw new IllegalAccessException();
        }
    }

    @Override
    public int update(SignupDTO signupDTO) throws Exception {
        // login 확인
        userDAO.updateOne(signupDTO);

        return 0;
    }

    @Override
    public int delete(String id) throws Exception {
        // auth
        userDAO.deleteOne(id);
        return 0;
    }
}
