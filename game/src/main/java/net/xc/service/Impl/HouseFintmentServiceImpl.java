package net.xc.service.Impl;

import net.xc.mapper.FintmentMapper;
import net.xc.pojo.HouseFintment;
import net.xc.pojo.Warehouse;
import net.xc.service.HouseFintmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class HouseFintmentServiceImpl implements HouseFintmentService {
    @Resource
    private FintmentMapper FintmentMapper;

    //查询市场商品
    @Override
    public List<HouseFintment> queryFintmentList() {
        return FintmentMapper.queryFintmentList();
    }
    //根据id查询仓库user_id
    @Override
    public int queryWarByid(Warehouse warehouse) {
        return FintmentMapper.queryWarByid(warehouse);
    }
    //添加到仓库
    @Override
    public int addWarehouse(Warehouse warehouse) {
        return FintmentMapper.addWarehouse(warehouse);
    }
    //修改仓库商品得数量东西
    @Override
    public int updateWarBynum(Warehouse warehouse) {
        return FintmentMapper.updateWarBynum(warehouse);
    }


}
