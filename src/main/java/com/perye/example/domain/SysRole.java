package com.perye.example.domain;

import lombok.Data;

import java.util.List;

/**
 * @author: Perye
 * @create: 2018-10-23 21:10
 **/
@Data
public class SysRole {

    private Integer id;
    private String name;
    private List<SysUser> users;
}
