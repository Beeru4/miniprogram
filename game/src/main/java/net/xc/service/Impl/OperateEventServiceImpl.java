package net.xc.service.impl;

import net.xc.mapper.OperateEventMapper;
import net.xc.pojo.OperateEvent;
import net.xc.service.OperateEventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 运营事件业务层
 */
@Service(value = "operateEventService")
public class OperateEventServiceImpl implements OperateEventService {

    @Resource(name = "operateEventMapper")
    private OperateEventMapper operateEventMapper;

    @Override
    @Transactional(readOnly = true)
    public List<OperateEvent> listOperateEvent() {
        return operateEventMapper.listOperateEvent();
    }
}
