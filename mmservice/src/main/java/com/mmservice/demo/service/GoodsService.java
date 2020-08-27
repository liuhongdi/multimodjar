package com.mmservice.demo.service;

import com.mmpojo.demo.pojo.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    public List<Goods> getAllGoods();
    public Map<String,Object> getAllGoodsByPage(int currentPage);
}
