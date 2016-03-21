package com.baidu.mgame.interfacetest.dao;

import java.util.List;

import com.baidu.mgame.interfacetest.entity.UsecaseMain;

/**
 * 用例数据库操作
 *
 * @author maolei
 * @date 2015年8月30日 上午2:13:33
 * @version V1.0
 */
public interface UsecaseDao {

    /**
     * 根据接口id查询用例
     *
     * @param interIds
     * @return
     * @throws Exception
     */
    public List<UsecaseMain> getUsecaseByInterfaceId(Integer[] interIds) throws Exception;

    /**
     * 新增用例
     *
     * @param uc
     * @return
     * @throws Exception
     */
    public int insertUsecase(UsecaseMain uc) throws Exception;

    /**
     * 修改用例
     *
     * @param uc
     * @return
     * @throws Exception
     */
    public boolean updateUsecase(UsecaseMain uc) throws Exception;

    /**
     * 删除用例
     *
     * @param ucids
     * @return
     * @throws Exception
     */
    public boolean deleteUsecase(Integer[] ucids) throws Exception;

}
