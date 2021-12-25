package com.group2.shop.dao;

import com.group2.shop.domain.Good;

import java.util.List;
import java.util.Map;

/**
 * 货物dao接口
 * @author Honmono
 * @date 2021/10/22 - 19:23
 */
public interface GoodDao {
    /**
     * 查找所有货物dao
     * @return
     */
    public List<Good> findAllGoods();

    /**
     * 根据g_id查找货物
     * @return
     */
    Good findGoodById(int g_id);

    /**
     * 根据页数查询货物
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    List<Good> findAllGoodsByPage(int currentPage, int rows, Map<String, String[]> condition);

    /**
     * 查询货物总数
     * @return
     * @param condition
     */
    int findGoodsTotalCount(Map<String, String[]> condition);

    /**
     * 用户点击购买后减少对应商品对应数量的库存量
     * @param g_id
     * @param o_num
     */
    void updateStockAfterBuy(int g_id, int o_num);

    /**
     * 根据用户id和商品id查询用户收藏记录
     * @param u_id
     * @param g_id
     * @return
     */
    int confirmIfCollected(int u_id,int g_id);

    /**
     * 根据收藏编号删除收藏
     * @param gColl_id
     */
    void deleteCollectionBygColl_id(int gColl_id);

    /**
     * 根据用户编号和商品编号创建收藏
     * @param u_id
     * @param g_id
     */
    void createCollectionByu_idAndg_id(int u_id, int g_id);
}
