package com.britu.oj.judge.dao;


import com.britu.oj.judge.entity.SystemConfig;

public interface SystemConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemConfig record);

    int insertSelective(SystemConfig record);

    SystemConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemConfig record);

    int updateByPrimaryKey(SystemConfig record);

    SystemConfig getByKey(String key);
}