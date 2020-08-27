package com.mmrepo.demo.mapper;

import com.mmpojo.demo.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GoodsMapper {
    List<Goods> selectAllGoods();
}
