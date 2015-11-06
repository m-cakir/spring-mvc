package com.mcakir.core.service;

import com.mcakir.core.model.Menu;
import com.mcakir.core.model.Role;
import com.mcakir.core.model.User;
import com.mcakir.core.repository.MenuRepository;
import com.mcakir.core.repository.RoleRepository;
import com.mcakir.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService implements IAdminService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    MenuRepository menuRepository;

    @Override
    @Transactional(readOnly = true)
    public User findUserById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(User user) {
        if(user != null && user.getId() != null){
            userRepository.save(user);
        }
    }

    @Override
    public Role findRoleById(long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public List<Role> findRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Menu findMenuById(long id) {
        return menuRepository.findOne(id);
    }

    @Override
    public List<Menu> findMenus() {
        return menuRepository.findAll();
    }

    @Override
    public List<Menu> findMenusByParentId(long id){
        return menuRepository.findAllByParentId(id);
    }

    @Override
    public List<Menu> findParents() {
        return menuRepository.findAllParents();
    }
}
