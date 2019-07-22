package net.xc.controller;

import net.xc.service.EradicateEventService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 可杜绝事件控制器
 */
@RestController
public class EradicateEventController {

    @Resource(name = "eradicateEventService")
    private EradicateEventService eradicateEventService;

    @RequestMapping(value = "/eradicateEvent/listEradicateEvent")
    public Object listEradicateEvent(Model model) throws Exception  {
        return eradicateEventService.listEradicateEvent();
    }
}
