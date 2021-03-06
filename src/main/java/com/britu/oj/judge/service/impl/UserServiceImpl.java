package com.britu.oj.judge.service.impl;

import com.britu.oj.judge.dao.UserMapper;
import com.britu.oj.judge.service.UserService;
import com.britu.oj.judge.response.ServerResponse;
import com.britu.oj.judge.common.JudgeStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:45
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public ServerResponse addCount(Integer userId, JudgeStatusEnum statusConst) {
        int effect = 0;
        if (Objects.equals(JudgeStatusEnum.ACCEPTED, statusConst)) {
            effect = userMapper.addAcCount(userId);

        } else if (Objects.equals(JudgeStatusEnum.TIME_LIMIT_EXCEEDED, statusConst)) {
            effect = userMapper.addTleCount(userId);

        } else if (Objects.equals(JudgeStatusEnum.PRESENTATION_ERROR, statusConst)) {
            effect = userMapper.addPeCount(userId);

        } else if (Objects.equals(JudgeStatusEnum.MEMORY_LIMIT_EXCEEDED, statusConst)) {
            effect = userMapper.addMeCount(userId);

        } else if (Objects.equals(JudgeStatusEnum.COMPILE_ERROR, statusConst)) {
            effect = userMapper.addCeCount(userId);

        } else if (Objects.equals(JudgeStatusEnum.RUNTIME_ERROR, statusConst)) {
            effect = userMapper.addReCount(userId);

        } else if (Objects.equals(JudgeStatusEnum.WRONG_ANSWER, statusConst)) {
            effect = userMapper.addWaCount(userId);
        }
        return effect > 0 ? ServerResponse.success() : ServerResponse.fail();

    }

    @Override
    public ServerResponse addSolutionCountAndGoldCountAndRating(Integer userId, String problemId, Integer goldCount, Integer ratingCount) {
        int effect = userMapper.addSolutionCountAndGoldCountAndRating(userId, problemId, goldCount, ratingCount);
        return effect > 0 ? ServerResponse.success() : ServerResponse.fail();
    }
}
