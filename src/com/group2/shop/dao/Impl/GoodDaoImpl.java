package com.group2.shop.dao.Impl;

import com.group2.shop.dao.GoodDao;
import com.group2.shop.domain.Good;
import com.group2.shop.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 货物dao实现类
 * @author Honmono
 * @date 2021/10/22 - 19:25
 */
public class GoodDaoImpl implements GoodDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查找所有货物
     * @return
     */
    @Override
    public List<Good> findAllGoods() {
        //定义SQL
        String sql = "select * from good";
        List<Good> goods = template.query(sql, new BeanPropertyRowMapper<Good>(Good.class));
        return goods;
    }

    /**
     * 根据g_id查找货物
     * @param g_id
     * @return
     */
    @Override
    public Good findGoodById(int g_id) {
        //定义SQL
        String sql = "select * from good where g_id = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<>(Good.class),g_id);
    }

    /**
     * 根据页数查找货物
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    @Override
    public List<Good> findAllGoodsByPage(int start, int rows, Map<String, String[]> condition) {
        //定义模板SQL
        String sql = "select * from good where 1 = 1 ";
        StringBuffer sqlSb = new StringBuffer(sql);

        //遍历map
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<>();//定义参数集合
        for (String key : keySet) {
            //排除currentpage和rows条件
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断不为空
            if (value != null && !"".equals(value)){
                //拼接SQL
                sqlSb.append(" and " + key +" like ? ");
                params.add("%" + value + "%");
            }
        }
        //拼接剩余sql
        sqlSb.append("limit ? , ?");
        params.add(start);
        params.add(rows);
        //执行SQL
        List<Good> goods;
        if (params.size() == 0){
            goods = template.query(sqlSb.toString(), new BeanPropertyRowMapper<Good>(Good.class),start,rows);
        }else {
            goods = template.query(sqlSb.toString(), new BeanPropertyRowMapper<Good>(Good.class),params.toArray());
        }
        return goods;
    }

    /**
     * 查询货物记录总数
     * @return
     * @param condition
     */
    @Override
    public int findGoodsTotalCount(Map<String, String[]> condition) {
        //定义模板SQL
        String sql = "select count(*) from good where 1 = 1 ";
        StringBuffer sqlSb = new StringBuffer(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<>();//定义参数集合
        for (String key : keySet) {
            //排除currentpage和rows条件
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断不为空
            if (value != null && !"".equals(value)){
                //拼接SQL
                sqlSb.append("and " + key +" like ? ");
                params.add("%" + value + "%");
            }
        }

        return template.queryForObject(sqlSb.toString(),Integer.class,params.toArray());
    }

    /**
     * 用户点击购买后减少对应商品对应数量的库存量
     * @param g_id
     * @param o_num
     */
    @Override
    public void updateStockAfterBuy(int g_id, int o_num) {
        //定义SQL
        String sql = "UPDATE good SET g_stock = g_stock - ? WHERE g_id = ?";
        //执行SQL
        template.update(sql,o_num,g_id);
    }

    /**
     * 根据用户id和商品id查询用户收藏记录
     * @param g_id
     * @param u_id
     * @return
     */
    @Override
    public int confirmIfCollected(int u_id,int g_id) {
        //定义SQL
        String sql = "select count(*) from user_goodcollection where u_id = ? and g_id = ?";
        //执行SQL
        Integer count = template.queryForObject(sql, Integer.class, u_id, g_id);//返回记录数
        //判断记录是否存在 是则获取记录编号返回 否则返回0
        if (count > 0){//存在
            //定义SQL
            String getgColl_idSql = "select gcoll_id from user_goodcollection where u_id = ? and g_id = ?";
            //执行SQL
            Integer gColl_id = template.queryForObject(getgColl_idSql, Integer.class, u_id, g_id);
            return gColl_id;
        } else {
            return 0;
        }
    }

    /**
     * 根据收藏编号删除收藏
     * @param gColl_id
     */
    @Override
    public void deleteCollectionBygColl_id(int gColl_id) {
        //定义SQL
        String sql = "DELETE FROM user_goodcollection WHERE gcoll_id = ?";
        //执行SQL
        template.update(sql,gColl_id);
    }

    /**
     * 根据用户编号和商品编号创建收藏
     * @param u_id
     * @param g_id
     */
    @Override
    public void createCollectionByu_idAndg_id(int u_id, int g_id) {
        //定义SQL
        String sql = "INSERT INTO user_goodcollection VALUES(NULL,?,?)";
        //执行SQL
        template.update(sql,u_id,g_id);
    }
}
