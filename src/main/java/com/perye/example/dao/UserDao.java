package com.perye.example.dao;

import com.perye.example.domain.SysUser;

/**
 * @author: Perye
 * @create: 2018-10-23 21:14
 **/
public interface UserDao {
    public SysUser findByUserName(String username);
}
