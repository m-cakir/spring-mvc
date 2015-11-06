package com.mcakir.core.repository;

import com.mcakir.core.base.repository.BaseRepository;
import com.mcakir.core.model.User;

public interface UserRepository extends BaseRepository<User> {

    public User findByUsername(String username);

}
