package com.travel.service;


import com.travel.commons.resultbean.ResultGeekQ;
import com.travel.vo.GoodsVo;
import com.travel.vo.MiaoShaOrderVo;
import com.travel.vo.MiaoShaUserVo;
import com.travel.vo.OrderInfoVo;

/**
 * @author 邱润泽 bullock
 */
public interface MiaoshaService {

    ResultGeekQ<OrderInfoVo> miaosha(MiaoShaUserVo user, GoodsVo goods);

    ResultGeekQ<Integer> insertMiaoshaOrder(MiaoShaOrderVo miaoshaOrder);

    ResultGeekQ<MiaoShaOrderVo> getMiaoshaOrderByUserIdGoodsId(Long userId, Long goodsId);

    ResultGeekQ<String> createMiaoshaPath(MiaoShaUserVo user, Long goodsId);

    ResultGeekQ<Long> getMiaoshaResult(Long userId, Long goodsId);

    ResultGeekQ<Boolean> checkPath(MiaoShaUserVo user, long goodsId, String path);

    boolean checkVerifyCodeRegister(int verifyCode);

}
