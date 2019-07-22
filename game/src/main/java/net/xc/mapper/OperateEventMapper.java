package net.xc.mapper;

import net.xc.pojo.DayEvent;
import net.xc.pojo.OperateEvent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 运营事件映射层
 */
@Mapper
public interface OperateEventMapper {
    /**
     * 查询所有运营事件
     *
     * @return 运营事件集合
     */
    List<OperateEvent> listOperateEvent();
}
