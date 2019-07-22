package net.xc.mapper;


import net.xc.pojo.EradicateEvent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 可杜绝事件映射层
 */
@Mapper
public interface EradicateEventMapper {
    /**
     * 查询所有可杜绝事件
     * @return 可杜绝事件集合
     */
    List<EradicateEvent> listEradicateEvent();
}
