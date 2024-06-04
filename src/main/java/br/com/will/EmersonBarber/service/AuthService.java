package br.com.will.EmersonBarber.service;

import br.com.will.EmersonBarber.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UsuarioRepository repository;
    @Override
    public UserDetails loadUserByUsername(String email){
        try{
            return repository.findByEmail(email);
        } catch (RuntimeException exception){
            throw new RuntimeException("Usuario Não Encontrado !!");
        }
    }
}
