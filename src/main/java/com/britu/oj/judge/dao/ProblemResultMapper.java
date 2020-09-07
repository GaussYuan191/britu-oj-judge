package com.britu.oj.judge.dao;


import com.britu.oj.judge.entity.ProblemResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProblemResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProblemResult record);

    int insertSelective(ProblemResult record);

    ProblemResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProblemResult record);

    int updateByPrimaryKey(ProblemResult record);


    int updateProblemResultStatus(@Param("problemResultId") Integer problemResultId,@Param("status") Integer status);

    List<ProblemResult> listByUserIdProblemId(@Param("userId") Integer userId,@Param("problemId") String problemId);

    int countByUserIdProblemIdStatus(@Param("userId") Integer userId,@Param("problemId") String problemId,@Param("status")Integer status);

    ProblemResult getProblemResultByRunNum(String runNum);

    int updateCompScoreById(@Param("compScore")Integer compScore, @Param("problemResultId") Integer problemResultId);

    Integer getTotalScoreById(@Param("userId") Integer userId,@Param("compId") Integer compId);
}