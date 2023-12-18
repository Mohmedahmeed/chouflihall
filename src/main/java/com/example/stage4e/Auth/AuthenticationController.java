package com.example.stage4e.Auth;

import com.example.stage4e.Entities.Email;

import com.example.stage4e.Entities.User;
import com.example.stage4e.Repository.UserRepository;
import com.example.stage4e.Service.EmailServiceImp;
import com.example.stage4e.Service.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final Code code;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailServiceImp emailServiceImp;


    @Autowired
    private UserServiceImp userServiceImp;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return  ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping(path = "/registration/confirm")
    public String  confirmToken(@RequestParam("token") String token) {
        return authenticationService.confirmToken(token);
    }


    @PostMapping("/checkByEmail")
    public AccountResponse resetPasswordEmail(@RequestBody Person person){
        Boolean result;
        result = userServiceImp.ifEmailExists(person.getMail());
        User user = userServiceImp.getUserByEmail(person.getMail()).orElse(null);
        AccountResponse accountResponse =new AccountResponse();
        if(user != null){
            String codejdid = code.getCode();
            Email email = new Email ();
            email.setToEmail(person.getMail());
            email.setCode(codejdid);
            user.setCode(codejdid);
            userServiceImp.editUser(user);
            System.out.println(code.getCode());
            emailServiceImp.sendCodeByMail(email);
            accountResponse.setResult(1);

        }
        else {
            accountResponse.setResult(0);
            System.out.println(accountResponse.getResult());
        }
        return accountResponse;
    }



    @PostMapping("/reset")
    public AccountResponse ResetPassword (@RequestBody NewPassword newPassword){
        User user = userServiceImp.getUserByEmail(newPassword.getEmail()).orElse(null);
        AccountResponse accountResponse =new AccountResponse();
        if (user!= null){
            String kal=user.getCode();

            if(kal.equals(newPassword.getCode().toString())){
                System.out.println(newPassword.getPassword());
                String klithma = passwordEncoder.encode(newPassword.getPassword());
                user.setPassword(klithma);
                userRepository.saveAndFlush(user);
                accountResponse.setResult(1);


            }
            else {
                accountResponse.setResult(0);
            }
        }
        else {
                accountResponse.setResult(0);
        }
            return accountResponse;
    }

}
