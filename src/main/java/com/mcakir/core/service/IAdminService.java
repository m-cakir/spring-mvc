package com.mcakir.core.service;

import com.mcakir.core.model.Menu;
import com.mcakir.core.model.Role;
import com.mcakir.core.model.User;

import java.util.List;

public interface IAdminService {

/* * User methods * */

    public User findUserById(long id);

    public User findUserByUsername(String username);

    public List<User> findUsers();

    public void updateUser(User user);

/* * Role methods * */

    public Role findRoleById(long id);

    public List<Role> findRoles();

/* * Menu methods * */

    public Menu findMenuById(long id);

    public List<Menu> findMenus();

    public List<Menu> findMenusByParentId(long id);

    public List<Menu> findParents();
}
