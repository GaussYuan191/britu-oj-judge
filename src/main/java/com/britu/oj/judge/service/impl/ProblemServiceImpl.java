package com.britu.oj.judge.service.impl;

import com.britu.oj.judge.dao.ProblemMapper;
import com.britu.oj.judge.dao.ProblemResultMapper;
import com.britu.oj.judge.dao.TestcaseResultMapper;
import com.britu.oj.judge.service.ProblemService;
import com.britu.oj.judge.response.ServerResponse;
import com.britu.oj.judge.common.JudgeStatusEnum;
import com.britu.oj.judge.entity.Problem;
import com.britu.oj.judge.entity.ProblemResult;
import com.britu.oj.judge.entity.TestcaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:44
 */
@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemMapper problemMapper;

    @Autowired
    private ProblemResultMapper problemResultMapper;

    @Autowired
    private TestcaseResultMapper testcaseResultMapper;

    @Override
    public Problem getProblemById(String problemId) {
        return problemMapper.selectByPrimaryKey(problemId);
    }

    @Override
    public ProblemResult getProblemResultById(Integer problemResultId) {
        return problemResultMapper.selectByPrimaryKey(problemResultId);
    }

    @Override
    public ProblemResult getProblemResultByRunNum(String runNum) {
        return problemResultMapper.getProblemResultByRunNum(runNum);
    }

    @Override
    public ServerResponse insertProblemResult(ProblemResult result) {
        result.setCreateTime(new Date());
        int effect = problemResultMapper.insertSelective(result);
        return effect > 0 ? ServerResponse.success() : ServerResponse.fail();
    }

    /**
     * 更新题目
     *
     * @param problem
     * @return
     */
    @Override
    public ServerResponse updateProblemById(Problem problem) {
        int effect = problemMapper.updateByPrimaryKeySelective(problem);
        return effect > 0 ? ServerResponse.success() : ServerResponse.fail();
    }

    /**
     * 更新题目结果
     *
     * @return
     */
    @Override
    public ServerResponse updateProblemResultById(ProblemResult problemResult) {
        int effect = problemResultMapper.updateByPrimaryKeySelective(problemResult);
        return effect > 0 ? ServerResponse.success() : ServerResponse.fail();
    }


    /**
     * 更新题目状态
     *
     * @return
     */
    @Override
    public ServerResponse updateProblemResultStatusById(Integer problemResultId, Integer status) {
        int effect = problemResultMapper.updateProblemResultStatus(problemResultId, status);
        return effect > 0 ? ServerResponse.success() : ServerResponse.fail();
    }

    /**
     * 添加记录数
     *
     * @param problemId
     * @param statusConst
     * @return
     */
    @Override
    public ServerResponse addProblemCountById(String problemId, JudgeStatusEnum statusConst) {
        int effect = 0;
        if (Objects.equals(JudgeStatusEnum.ACCEPTED, statusConst)) {
            effect = problemMapper.addAcCount(problemId);

        } else if (Objects.equals(JudgeStatusEnum.TIME_LIMIT_EXCEEDED, statusConst)) {
            effect = problemMapper.addTleCount(problemId);

        } else if (Objects.equals(JudgeStatusEnum.PRESENTATION_ERROR, statusConst)) {
            effect = problemMapper.addPeCount(problemId);

        } else if (Objects.equals(JudgeStatusEnum.MEMORY_LIMIT_EXCEEDED, statusConst)) {
            effect = problemMapper.addMeCount(problemId);

        } else if (Objects.equals(JudgeStatusEnum.COMPILE_ERROR, statusConst)) {
            effect = problemMapper.addCeCount(problemId);

        } else if (Objects.equals(JudgeStatusEnum.RUNTIME_ERROR, statusConst)) {
            effect = problemMapper.addReCount(problemId);

        } else if (Objects.equals(JudgeStatusEnum.WRONG_ANSWER, statusConst)) {
            effect = problemMapper.addWaCount(problemId);
        }

        return effect > 0 ? ServerResponse.success() : ServerResponse.fail();
    }

    @Override
    public ServerResponse insertBatchTestcaseResult(List<TestcaseResult> testcaseResultList) {
        int effect = testcaseResultMapper.insertBatch(testcaseResultList);
        return effect > 0 ? ServerResponse.success() : ServerResponse.fail();
    }

    @Override
    public int countProblemResult(Integer userId, String problemId,Integer status) {
        return problemResultMapper.countByUserIdProblemIdStatus(userId,problemId,status);
    }

    @Override
    public ServerResponse addCompScoreById(Integer compScore, Integer problemResultId) {
        int effect = problemResultMapper.updateCompScoreById(compScore,problemResultId);
        return effect > 0 ? ServerResponse.success() : ServerResponse.fail();
    }

    @Override
    public Integer getTotalScoreById(Integer userId, Integer compId) {
        return  problemResultMapper.getTotalScoreById(userId,compId);
    }
}
