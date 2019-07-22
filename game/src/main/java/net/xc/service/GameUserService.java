package net.xc.service;

import net.xc.pojo.GameUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户业务层
 */
public interface GameUserService {
    /**
     * 根据用户的uuid查询用户是否存在
     *
     * @param uuid 用户唯一id
     * @return true 存在   false 不存在
     */
    boolean userIsExists(String uuid)  throws  Exception;

    /**
     * 全球排行榜
     *
     * @return 用户集合
     */
    List<GameUser> listByRanking()  throws  Exception;

    /**
     * 用户首次注册
     * @param gameUser 用户
     * @return 是否添加成功  true 成功   false 失败
     */
    boolean register(GameUser gameUser)  throws  Exception;
}
