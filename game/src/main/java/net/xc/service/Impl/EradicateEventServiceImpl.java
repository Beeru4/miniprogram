package net.xc.service.impl;


import net.xc.mapper.EradicateEventMapper;
import net.xc.pojo.EradicateEvent;
import net.xc.service.EradicateEventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 可杜绝事件业务层
 */
@Service(value = "eradicateEventService")
public class EradicateEventServiceImpl implements EradicateEventService {

    @Resource(name = "eradicateEventMapper")
    private EradicateEventMapper eradicateEventMapper;

    @Override
    @Transactional(readOnly = true)
    public List<EradicateEvent> listEradicateEvent() {
        return eradicateEventMapper.listEradicateEvent();
    }
}
