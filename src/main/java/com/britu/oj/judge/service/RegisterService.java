package com.britu.oj.judge.service;

import com.britu.oj.judge.response.ServerResponse;

/**
 * @author m969130721@163.com
 * @date 19-2-16 下午4:09
 */
public interface RegisterService {

    ServerResponse addSolutionCountByProblemIdCompIdUserId(String problemId,Integer compId, Integer userId);

    ServerResponse addSubmitCountByCompIdUserId(Integer compId, Integer userId);

    ServerResponse addAcCountByCompIdUserId(Integer compId, Integer userId);

    ServerResponse updateScore(Integer score,Integer compId, Integer userId);

}
