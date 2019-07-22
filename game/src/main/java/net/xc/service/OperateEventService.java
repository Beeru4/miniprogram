package net.xc.service;

import net.xc.pojo.OperateEvent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 运营事件业务层
 */
public interface OperateEventService {
    /**
     * 查询所有运营事件
     *
     * @return 运营事件集合
     */
    List<OperateEvent> listOperateEvent()  throws  Exception;
}
