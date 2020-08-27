package com.mmweb.demo.controller;

import com.mmpojo.demo.pojo.Goods;
import com.mmservice.demo.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Resource
    private GoodsService goodsService;

    // list all goods
    @GetMapping("/list")
    @ResponseBody
    public List<Goods> all() {
        System.out.println("-------------------------list");
        List<Goods> list = goodsService.getAllGoods();
        return list;
    }

    //带模板显示商品列表 参数:第几页
    @GetMapping("/goodslist")
    public String goodsList(Model model,
                            @RequestParam(value="p",required = false,defaultValue = "1") int currentPage) {
        Map<String,Object> res = goodsService.getAllGoodsByPage(currentPage);
        model.addAttribute("pageInfo", res.get("pageInfo"));
        model.addAttribute("goodslist", res.get("goodslist"));
        return "goods/goodslist";
    }
}
