package com.servive;

import com.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return如果返回null说明登录失败，如果返回有值登录成功
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return返回true表示用户已存在，返回false表示用户名可用
     */
    public boolean existsUsername(String username);
}
