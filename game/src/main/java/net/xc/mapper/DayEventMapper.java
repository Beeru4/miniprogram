package net.xc.mapper;

import net.xc.pojo.DayEvent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 每天事件映射层
 */
@Mapper
public interface DayEventMapper {
    /**
     * 查询所有每天事件
     * @return 每天事件集合
     */
    List<DayEvent> listDayEvent();
}
