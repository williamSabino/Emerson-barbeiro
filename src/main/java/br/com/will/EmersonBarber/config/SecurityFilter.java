package br.com.will.EmersonBarber.config;

import br.com.will.EmersonBarber.repository.UsuarioRepository;
import br.com.will.EmersonBarber.service.JWTtoken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private JWTtoken jwTtoken;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = verificarToken(request.getHeader("Authorization"));
        if(token != null){
            var login =jwTtoken.verificarToken(token);
            UserDetails user = usuarioRepository.findByEmail(login);
            var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request, response);
    }

    private String verificarToken(String authorization) {
        if(authorization == null) return null;
        return authorization.replace("Bearer ", "");
    }
}
