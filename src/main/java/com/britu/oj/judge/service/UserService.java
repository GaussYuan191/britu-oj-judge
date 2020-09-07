package com.britu.oj.judge.service;

import com.britu.oj.judge.response.ServerResponse;
import com.britu.oj.judge.common.JudgeStatusEnum;

/**
 * @author m969130721@163.com
 * @date 18-12-17 下午1:44
 */
public interface UserService {

    ServerResponse addCount(Integer userId, JudgeStatusEnum statusConst);

    ServerResponse addSolutionCountAndGoldCountAndRating(Integer userId,String problemId,Integer goldCount,Integer ratingCount);

}
