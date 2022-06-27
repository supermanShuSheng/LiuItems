package com.shusheng.serviceImpl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author 刘闯
 * @date 2022/6/20
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        List<GrantedAuthority> grantedAuthorities = CollUtil.newArrayList();
//        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ACTIVITI_USER");
//        grantedAuthorities.add(grantedAuthority);
        return new User(username,"123", Collections.emptyList());
    }
}
