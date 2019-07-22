package net.xc.service;

import net.xc.pojo.DayEvent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 每天事件业务层
 */
public interface DayEventService {
    /**
     * 查询所有每天事件
     *
     * @return 每天事件集合
     */
    List<DayEvent> listDayEvent() throws  Exception;
}
