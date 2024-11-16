package ru.volobuev.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.volobuev.security.models.User;

import java.util.List;

public interface UserService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    User findById(Long userId);
    void update(User user, String[] roleNames);
    List<User> getAll();
    boolean save(User user, String[] roleNames);
    void delete(Long userId);
}
