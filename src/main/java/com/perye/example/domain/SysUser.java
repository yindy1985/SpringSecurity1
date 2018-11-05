package com.perye.example.domain;

import lombok.Data;

import java.util.List;

/**
 * @author: Perye
 * @create: 2018-10-23 21:09
 **/
@Data
public class SysUser {
    private Integer id;
    private String username;
    private String password;
    private List<SysRole> roles;

}
