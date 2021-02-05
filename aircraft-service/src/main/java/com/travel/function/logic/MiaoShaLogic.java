package com.travel.function.logic;

import com.travel.function.entity.MiaoShaOrder;
import com.travel.function.entity.MiaoShaUser;
import com.travel.function.entity.OrderInfo;
import com.travel.vo.GoodsVo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 邱润泽 bullock
 */
@Service
public interface MiaoShaLogic {

    OrderInfo createOrder(MiaoShaUser user, GoodsVo goods);

    int insertMiaoshaOrder(MiaoShaOrder miaoshaOrder);

    MiaoShaOrder getMiaoshaOrderByUserIdGoodsId(Long userId, Long goodsId);

    // check 生成的验证码路径
    boolean checkPath(MiaoShaUser user, long goodsId, String path);


    List<MiaoShaOrder> listByGoodsId(Long goodsId);

    MiaoShaUser getById(Long id);

    HttpServletResponse addCookie(HttpServletResponse response, String token, MiaoShaUser user);

    Long insertSelective(OrderInfo record);

    OrderInfo getOrderById(Long orderId);

    MiaoShaUser getByToken(HttpServletResponse response , String token);

}
