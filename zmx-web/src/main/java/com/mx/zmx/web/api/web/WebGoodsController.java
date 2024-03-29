package com.mx.zmx.web.api.web;

import com.mx.zmx.core.serialize.ResponseMsg;
import com.mx.zmx.service.goods.service.GoodsService;
import com.mx.zmx.web.webservice.goods.service.WebGoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * author:www.maoxing.vip
 * date:2018/8/23
 * function:
 */
@RestController
@RequestMapping("/web/goods/")
public class WebGoodsController {
    @Resource
    private GoodsService goodsService;
    @Resource
    private WebGoodsService webGoodsService;


    @RequestMapping("info")
    public ResponseMsg info(){
        Jedis jedis;
        goodsService.getModel(1L);
        webGoodsService.getWebGoods(1L);
        return new ResponseMsg("ok");
    }

}
