package net.xc.controller;

import net.xc.service.DayEventService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * DayEvent控制器
 */
@RestController
public class DayEventController {

    @Resource(name = "dayEventService")
    private DayEventService dayEventService;

    /**
     * 查询每天事件
     *
     * @return 返回JSON数据
     */
    @RequestMapping(value = "/dayEvent/listDayEvent")
    public Object listDayEvent(Model model) throws Exception {
        return dayEventService.listDayEvent();
    }
}