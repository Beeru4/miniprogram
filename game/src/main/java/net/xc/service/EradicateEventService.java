package net.xc.service;


import net.xc.pojo.EradicateEvent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 可杜绝事件业务层
 */
public interface EradicateEventService {
    /**
     * 查询所有可杜绝事件
     *
     * @return 可杜绝事件集合
     */
    List<EradicateEvent> listEradicateEvent()  throws  Exception;
}
