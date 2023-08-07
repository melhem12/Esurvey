package com.claimsExpress.Esurvey.security;


import com.claimsExpress.Esurvey.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

//    @Bean
//    private PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//        return new User("user",passwordEncoder().encode("password"), AuthorityUtils.NO_AUTHORITIES);
        Optional<AppUser> appUserOptional=userRepository.findById(userId);

        if (!appUserOptional.isPresent() ) {
            throw new NotFoundException("User not found");
        }

        return appUserOptional.get();
    }
//
//        public void save(AppUser user) {
//            user.setPassword(passwordEncoder().encode(user.getPassword()));
//            this.userRepository.save(user);
//        }
    public boolean userExist(String usrId) {
        Optional<AppUser> appUserOptional=userRepository.findById(usrId);
        if (!appUserOptional.isPresent()) {
            return false;

        }else {
            return true;
        }
    }


    public List<AppUser> findAll() {
        return userRepository.findAll();
    }
}
