package net.xc.controller;

import net.xc.service.GameUserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户控制器
 */
@RestController
public class GameUserController {

    @Resource(name = "gameUserService")
    private GameUserService gameUserService;

    /**
     * 查询用户是否存在
     *
     * @param uuid 用户uuid
     * @return
     */
    @RequestMapping(value = "/gameUser/userIsExists")
    public Object userIsExists(@RequestParam(value = "uuid", required = false) String uuid,
                               Model model) throws Exception {
        if (null != uuid || !"".equals(uuid.trim())) {
            return model.addAttribute("result", gameUserService.userIsExists(uuid));
        }
        return null;
    }

    /**
     * 查询排行榜用户
     *
     * @return
     */
    @RequestMapping(value = "/gameUser/listUserGame")
    public Object listUserGame(Model model) throws Exception {
        return gameUserService.listByRanking();
    }

    /**
     * 添加用户
     *
     * @param userStg 用户
     * @return
     */
    @RequestMapping(value = "/gameUser/registerUser")
    public Object registerUser(Model model, String userStg) {
        return "";
    }
}
