package com.tcc.agronomia.api.security;

import com.tcc.agronomia.domain.Usuario.Usuario;
import com.tcc.agronomia.domain.Usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value="userDetailsService")//identificao do "Qualifier" em SecurityConfig
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRep;

    /*
        implementar metodo para leitura de usuario do banco
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//        if(username.equals("user")){
//           return User.withUsername(username).password(encoder.encode("user")).roles("USER").build();
//        }else if(username.equals("admin")){
//                return User.withUsername(username).password(encoder.encode("admin")).roles("USER", "ADMIN").build();
//        }
//        throw new UsernameNotFoundException("usuario não encontrado");

        Usuario user = userRep.findByEmail(email);

        if(user == null){
            throw new UsernameNotFoundException("usuario não encontrado");
        }else{
            return User.withUsername(email).password(user.getSenha()).roles("USER").build();
        }
    }
}

