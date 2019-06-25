package com.zyzp.springboot.elasticsearch.service;

import com.zyzp.springboot.elasticsearch.entity.Authorize;
import com.zyzp.springboot.elasticsearch.entity.Users;
import com.zyzp.springboot.elasticsearch.repository.AuthorizeReposity;
import com.zyzp.springboot.elasticsearch.repository.UsersReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UsersReposity usersReposity;
    @Autowired
    private AuthorizeReposity authorizeReposity;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users users = usersReposity.getUsersByUsername(s);
        if (users!=null){
            List<Authorize> authorizes = authorizeReposity.getAuthorizesByUid(users.getUid());
            List<GrantedAuthority> list = new ArrayList<>();
            for(int i = 0;i<authorizes.size();i++){
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authorizes.get(i).getAuth());
                list.add(grantedAuthority);
            }
            return new User(users.getUsername(),users.getPassword(),list);
        }
        return null;
    }
}
