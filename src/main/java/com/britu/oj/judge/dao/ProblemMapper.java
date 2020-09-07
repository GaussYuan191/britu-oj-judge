package com.britu.oj.judge.dao;


import com.britu.oj.judge.entity.Problem;

public interface ProblemMapper {
    int deleteByPrimaryKey(String id);

    int insert(Problem record);

    int insertSelective(Problem record);

    Problem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Problem record);

    int updateByPrimaryKey(Problem record);

    int addAcCount(String problemId);

    int addPeCount(String problemId);

    int addCeCount(String problemId);

    int addTleCount(String problemId);

    int addMeCount(String problemId);

    int addReCount(String problemId);

    int addWaCount(String problemId);



}