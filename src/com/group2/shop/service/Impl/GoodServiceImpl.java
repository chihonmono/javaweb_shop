package com.group2.shop.service.Impl;

import com.group2.shop.dao.GoodDao;
import com.group2.shop.dao.Impl.GoodDaoImpl;
import com.group2.shop.domain.Good;
import com.group2.shop.domain.PageBean;
import com.group2.shop.service.GoodService;

import java.util.List;
import java.util.Map;

/**
 * 货物service实现类
 * @author Honmono
 * @date 2021/10/22 - 19:22
 */
public class GoodServiceImpl implements GoodService {
    private GoodDao dao = new GoodDaoImpl();

    /**
     * 查找所有货物
     * @return
     */
    @Override
    public List<Good> findAllGoods() {
        return dao.findAllGoods();
    }

    /**
     * 根据g_id查找货物
     * @param g_id
     * @return
     */
    @Override
    public Good findGoodById(int g_id) {
        return dao.findGoodById(g_id);
    }

    /**
     * 根据页码获取数据
     * @param str_currentPage
     * @param str_rows
     * @param condition
     * @return
     */
    @Override
    public PageBean<Good> findAllGoodsByPage(String str_currentPage, String str_rows, Map<String, String[]> condition) {
        //转换数据类型
        int currentPage = Integer.parseInt(str_currentPage);
        int rows = Integer.parseInt(str_rows);
        //如果当前页码为-1则设为默认值
        if (currentPage == -1){
            currentPage = 1;
        }

        //计算当前页开始的条目数
        int start = (currentPage - 1) * rows;

        //调用dao查询总记录数
        int totalCount = dao.findGoodsTotalCount(condition);

        //计算总页码数
        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows) + 1;

        //调用dao查询货物
        List<Good> goods = dao.findAllGoodsByPage(start, rows,condition);

        //创建空的PageBean对象
        PageBean<Good> pb = new PageBean<>();
        //封装数据
        pb.setTotalCount(totalCount);
        pb.setTotalPage(totalPage);
        pb.setList(goods);
        pb.setCurrentPage(currentPage);

        return pb;
    }

    /**
     * 用户点击购买后更新库存数量
     * @param g_id
     * @param o_num
     */
    @Override
    public void updateStockAfterBuy(int g_id, int o_num) {
        dao.updateStockAfterBuy(g_id,o_num);
    }

    /**
     * 完成收藏功能
     * @param u_id
     * @param g_id
     * @return
     */
    @Override
    public int GoodCollection(int u_id, int g_id) {
        //调用dao查询是否收藏
        int gColl_id = dao.confirmIfCollected(u_id, g_id);
        //判断是否收藏
        if (gColl_id == 0){//否
            //执行收藏操作 创建收藏行
            dao.createCollectionByu_idAndg_id(u_id,g_id);
            //再次查询收藏表获取gColl_id并返回
            return dao.confirmIfCollected(u_id,g_id);

        } else {//是
            //执行取消收藏操作 删除收藏行
            dao.deleteCollectionBygColl_id(gColl_id);
            return 0;
        }
    }

    /**
     * 确认是否收藏
     * @param u_id
     * @param g_id
     * @return
     */
    @Override
    public int confirmIfCollected(int u_id, int g_id) {
        return dao.confirmIfCollected(u_id,g_id);
    }
}
