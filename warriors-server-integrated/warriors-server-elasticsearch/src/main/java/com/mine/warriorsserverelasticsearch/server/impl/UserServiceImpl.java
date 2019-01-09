package com.mine.warriorsserverelasticsearch.server.impl;

import com.mine.warriorsserverelasticsearch.dao.UserDao;
import com.mine.warriorsserverelasticsearch.entity.User;
import com.mine.warriorsserverelasticsearch.server.UserService;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean insert(User user) {
        boolean falg = false;
        try {
            userDao.save(user);
            falg = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return falg;
    }

    @Override
    public List<User> search(String searchContent) {
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(searchContent);
        System.out.println("查询的语句:" + builder);
        Iterable<User> searchResult = userDao.search(builder);
        Iterator<User> iterator = searchResult.iterator();
        List<User> list = new ArrayList<User>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }


    @Override
    public List<User> searchUser(Integer pageNumber, Integer pageSize, String searchContent) {
        // 分页参数
        Pageable pageable = new PageRequest(pageNumber, pageSize);
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(searchContent);
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withPageable(pageable).withQuery(builder).build();
        System.out.println("查询的语句:" + searchQuery.getQuery().toString());
        Page<User> searchPageResults = userDao.search(searchQuery);
        return searchPageResults.getContent();
    }
}
