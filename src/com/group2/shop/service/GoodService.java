package com.group2.shop.service;

import com.group2.shop.domain.Good;
import com.group2.shop.domain.PageBean;

import java.util.List;
import java.util.Map;

/**
 * 货物service接口
 * @author Honmono
 * @date 2021/10/22 - 19:20
 */
public interface GoodService {

    /**
     * 查找全部货物
     * @return
     */
    public List<Good> findAllGoods();

    /**
     * 通过g_id查找货物
     * @return
     */
    Good findGoodById(int g_id);

    /**
     * 根据页数查找货物
     * @return
     */
    PageBean<Good> findAllGoodsByPage(String currentPage, String rows, Map<String, String[]> condition);

    /**
     * 用户点击购买后更新库存数量
     * @param g_id
     * @param o_num
     */
    void updateStockAfterBuy(int g_id, int o_num);

    /**
     * 完成收藏功能
     * @param u_id
     * @param g_id
     * @return
     */
    int GoodCollection(int u_id, int g_id);

    /**
     * 确认是否完成收藏
     * @param u_id
     * @param g_id
     * @return
     */
    int confirmIfCollected(int u_id, int g_id);
}
