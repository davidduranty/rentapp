package com.duranty.rentapp.service.contract;

import com.duranty.rentapp.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    List<User> getByName(String name);

    User createUser(User user);

    void deleteUser(Long id);
}
