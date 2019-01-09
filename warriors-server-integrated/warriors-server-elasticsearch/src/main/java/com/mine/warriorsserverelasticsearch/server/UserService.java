package com.mine.warriorsserverelasticsearch.server;

import com.mine.warriorsserverelasticsearch.entity.User;

import java.util.List;

public interface UserService {

    public boolean insert(User user);

    public List<User> search(String searchContent);

    public List<User> searchUser(Integer pageNumber, Integer pageSize, String searchContent);

}
