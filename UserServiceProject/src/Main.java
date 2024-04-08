import controller.UserController;
import dto.user.LoginDTO;
import dto.user.SignupDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String[] SIGNUP_MESSAGE = new String[] {"아이디", "비밀번호", "이름"};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        UserController userController = new UserController();
        boolean isActive = true;

        String token = "";

        while (isActive) {
            System.out.println("1:회원가입, 2:로그인, 3:회원정보 수정, 4:탈퇴, 0: 종료");
            int mode = -1;
            try {
                mode = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Input number is not a number");
            }

            String[] inputs = new String[3];
            int res = -1;
            switch (mode) {
                case 1:
                    for(int i=0; i<3; i++) {
                        System.out.println(SIGNUP_MESSAGE[i]);
                        inputs[i] = br.readLine();
                    }

                    SignupDTO signupDTO = new SignupDTO(inputs[0], inputs[1], inputs[2]);
                    res = userController.signup(signupDTO);

                    if(res == 0) {
                        System.out.println("Done");
                    } else {
                        System.out.println("sth went wrong");
                    }
                    break;

                case 2:
                    for(int i=0; i<2; i++) {
                        System.out.println(SIGNUP_MESSAGE[i]);
                        inputs[i] = br.readLine();
                    }

                    LoginDTO loginDTO = new LoginDTO(inputs[0], inputs[1]);
                    res = userController.login(loginDTO);


                    if(res == 0) {
                        System.out.println("Done");
                        // TODO: token
                        token = loginDTO.getId();
                    } else {
                        System.out.println("sth wrong");
                    }

                    break;

                case 3:
                    for(int i=0; i<3; i++) {
                        System.out.println(SIGNUP_MESSAGE[i]);
                        inputs[i] = br.readLine();
                    }

                    SignupDTO modifyDTO = new SignupDTO(inputs[0], inputs[1], inputs[2]);
                    res = userController.modify(token, modifyDTO);

                    if(res == 0) {
                        System.out.println("Success");
                    } else {
                        System.out.println("sth wrong");
                    }

                    break;

                case 4:
                    System.out.println(SIGNUP_MESSAGE[0]);
                    inputs[0] = br.readLine();

                    res = userController.delete(token, inputs[0]);

                    if(res == 0) {
                        System.out.println("Deleted");
                    } else {
                        System.out.println("sth wrong");
                    }

                    break;

                case 0:
                    System.out.println("Ends...");
                    isActive = false;
                    break;

                default:
                    System.out.println("Incorrect input");

            }
        }
    }
}