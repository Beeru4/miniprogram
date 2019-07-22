package net.xc.service.impl;

import net.xc.mapper.GameUserMapper;
import net.xc.pojo.GameUser;
import net.xc.service.GameUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户业务层
 */
@Service(value = "gameUserService")
public class GameUserServiceImpl implements GameUserService {

    @Resource(name = "gameUserMapper")
    private GameUserMapper gameUserMapper;

    @Override
    @Transactional(readOnly = true)
    public boolean userIsExists(String uuid) {
        return gameUserMapper.count_row(uuid) > 0;
    }

    @Override
    @Transactional(readOnly = true)
    public List<GameUser> listByRanking() {
        return gameUserMapper.listByRanking();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean register(GameUser gameUser) {
        return gameUserMapper.saveGameUser(gameUser) > 0;
    }
}
