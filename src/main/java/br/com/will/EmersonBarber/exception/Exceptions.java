package br.com.will.EmersonBarber.exception;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class Exceptions {

    @ExceptionHandler(RuntimeException.class)
    public void errodeAuth(HttpServletResponse res) throws IOException {
        var url = "http://localhost:8081/emerson-barbeiro/login?error=true";
        res.sendRedirect(url);
    }
}
