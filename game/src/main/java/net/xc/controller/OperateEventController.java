package net.xc.controller;

import net.xc.service.OperateEventService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 杜绝事件控制器
 */
@RestController
public class OperateEventController {

    @Resource(name = "operateEventService")
    private OperateEventService operateEventService;

    /**
     * 查询所有可杜绝事件
     *
     * @return
     */
    @RequestMapping(value = "/operateEvent/listOperateEvent")
    public Object listOperateEvent(Model model) throws Exception {
        return operateEventService.listOperateEvent();
    }
}
