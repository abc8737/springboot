package com.springboot.config;

import com.springboot.mapper.UserMapper;
import com.springboot.utils.EncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by SYSTEM on 2018/7/15.
 */
@Component
public class MyUserDetailsServiceImpl implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("用户的用户名: {}", username);
        String password = null;
        com.springboot.domain.User auth_user = userMapper.findUserByName(username);
        if (auth_user != null) {
            password = auth_user.getPassword();
        }
        logger.info("用户的密码: {}", password);

//        EncryptUtil encryptUtil = new EncryptUtil("MD5", password);
//        try {
//            logger.info("用户的MD5加密之后的密码: {}", encryptUtil.encrypt());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        logger.info("security加密后的密码是：{}", new BCryptPasswordEncoder().encode(password));
        try {
            logger.info("MD5加密后的密码是：{}", EncryptUtil.encrypt("MD5", password));
        } catch (Exception e) {
            e.printStackTrace();
        }


        User user = new User(username, new BCryptPasswordEncoder().encode(password),
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));


        return user;
    }
}
