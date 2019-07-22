package net.xc.mapper;

import net.xc.pojo.GameUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户映射层
 */
@Mapper
public interface GameUserMapper {
    /**
     * 查询用户是否存在
     *
     * @param uuid 用户唯一id
     * @return
     */
    Integer count_row(String uuid);

    /**
     * 全球排行榜
     *
     * @return 用户集合
     */
    List<GameUser> listByRanking();
    /**
     * 保存用户
     * @param gameUser 用户
     * @return 是否添加成功
     */
    Integer saveGameUser(GameUser gameUser);
}
