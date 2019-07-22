package net.xc.mapper;

import net.xc.pojo.HouseFintment;
import net.xc.pojo.Warehouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/***
 * 接口i
 */
@Mapper
public interface FintmentMapper {
    /**
     * 查询全部
     * @return
     */
    List<HouseFintment> queryFintmentList();

    /**
     * 添加仓库
     * @return
     */
    int addWarehouse(Warehouse warehouse);
    /**
     * 根据id查询仓库
     * @param warehouse
     * @return
     */
    int queryWarByid(Warehouse warehouse);

    /**
     * 根据user_id,fintment_id去修改
     * @param warehouse
     * @return
     */
    int updateWarBynum(Warehouse warehouse);

}
