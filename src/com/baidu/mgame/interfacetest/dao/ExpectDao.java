package com.baidu.mgame.interfacetest.dao;

import java.util.List;

import com.baidu.mgame.interfacetest.entity.ExpectMain;

/**
 * 用例期望结果数据库操作
 *
 * @author maolei
 * @date 2015年8月30日 上午1:14:20
 * @version V1.0
 */
public interface ExpectDao {

    /**
     * 根据接口ID批量查询对应的期望结果
     *
     * @param interfaceIds
     * @return
     * @throws Exception
     */
    public List<ExpectMain> getExpectByInterfaceId(Integer[] interfaceIds) throws Exception;

    /**
     * 新增预期结果
     *
     * @param ep
     * @return
     * @throws Exception
     */
    public int insertExpect(ExpectMain ep) throws Exception;

    /**
     * 修改预期结果
     *
     * @param ep
     * @return
     * @throws Exception
     */
    public boolean updateExpect(ExpectMain ep) throws Exception;

    /**
     * 删除预期结果
     *
     * @param eids
     * @return
     * @throws Exception
     */
    public boolean deleteExpect(Integer[] eids) throws Exception;
}
