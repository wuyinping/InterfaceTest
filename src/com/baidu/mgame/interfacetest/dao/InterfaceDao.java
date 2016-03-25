package com.baidu.mgame.interfacetest.dao;

import java.util.List;

import com.baidu.mgame.interfacetest.entity.InterfaceMain;

/**
 * 接口数据库操作
 *
 * @author maolei
 * @date 2015年8月30日 上午1:25:47
 * @version V1.0
 */
public interface InterfaceDao {

    /**
     * 根据项目版本id查询接口
     *
     * @param vids
     * @return
     * @throws Exception
     */
    public List<InterfaceMain> getInterfaceByVersionId(Integer[] vids) throws Exception;

    /**
     * 根据tag号查询接口
     *
     * @param vid
     * @param tag
     * @return
     * @throws Exception
     */
    public List<InterfaceMain> getInterfaceByTag(Integer vid, String tag) throws Exception;

    /**
     * 新增接口
     *
     * @param inter
     * @return
     * @throws Exception
     */
    public int insertInterface(InterfaceMain inter) throws Exception;

    /**
     * 修改接口
     *
     * @param inter
     * @return
     * @throws Exception
     */
    public boolean updateInterface(InterfaceMain inter) throws Exception;

    /**
     * 删除接口
     *
     * @param interIds
     * @return
     * @throws Exception
     */
    public boolean deleteInterface(Integer[] interIds) throws Exception;

}
