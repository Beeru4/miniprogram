package net.xc.service.impl;

import net.xc.mapper.DayEventMapper;
import net.xc.pojo.DayEvent;
import net.xc.service.DayEventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 每天事件业务层
 */
@Service(value = "dayEventService")
public class DayEventServiceImpl implements DayEventService {

    @Resource(name = "dayEventMapper")
    private DayEventMapper dayEventMapper;

    @Override
    @Transactional(readOnly = true)
    public List<DayEvent> listDayEvent() {
        return dayEventMapper.listDayEvent();
    }
}
