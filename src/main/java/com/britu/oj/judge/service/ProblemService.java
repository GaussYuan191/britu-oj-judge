package com.britu.oj.judge.service;

import com.britu.oj.judge.response.ServerResponse;
import com.britu.oj.judge.common.JudgeStatusEnum;
import com.britu.oj.judge.entity.Problem;
import com.britu.oj.judge.entity.ProblemResult;
import com.britu.oj.judge.entity.TestcaseResult;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:44
 */
public interface ProblemService {

    Problem getProblemById(String problemId);

    ProblemResult getProblemResultById(Integer problemResultId);

    ProblemResult getProblemResultByRunNum(String runNum);

    ServerResponse insertProblemResult(ProblemResult result);

    ServerResponse updateProblemById(Problem problem);

    ServerResponse updateProblemResultStatusById(Integer problemResultId, Integer status);

    ServerResponse updateProblemResultById(ProblemResult problemResult);

    ServerResponse addProblemCountById(String problemId, JudgeStatusEnum statusConst);

    ServerResponse insertBatchTestcaseResult(List<TestcaseResult> testcaseResultList);

    int countProblemResult(Integer userId,String problemId,Integer status);

    ServerResponse addCompScoreById(Integer compScore,Integer problemResultId);

    Integer getTotalScoreById( Integer userId, Integer compId);
}
