package com.mmservice.demo.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmpojo.demo.pojo.Goods;
import com.mmrepo.demo.mapper.GoodsMapper;
import com.mmservice.demo.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    //返回全部商品
    @Override
    public List<Goods> getAllGoods() {
        List<Goods> goodsList = goodsMapper.selectAllGoods();
        return goodsList;
    }

    //带分页返回商品
    @Override
    public Map<String,Object> getAllGoodsByPage(int currentPage) {
        Map<String,Object> res = new HashMap<String,Object>();
        PageHelper.startPage(currentPage, 5);
        List<Goods> goodsList = goodsMapper.selectAllGoods();
        res.put("goodslist",goodsList);
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        res.put("pageInfo",pageInfo);
        return res;
    }
}
