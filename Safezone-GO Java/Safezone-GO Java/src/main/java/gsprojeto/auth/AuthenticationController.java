package gsprojeto.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gsprojeto.util.JwtUtil;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationController {

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "1234".equals(password)) {
            return JwtUtil.generateToken(username);
        }
        throw new RuntimeException("Usuário ou senha inválidos");
    }
}

