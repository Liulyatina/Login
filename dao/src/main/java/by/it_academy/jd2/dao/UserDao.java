package by.it_academy.jd2.dao;

import by.it_academy.jd2.core.dto.UserDTO;
import by.it_academy.jd2.dao.api.IUserDao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserDao implements IUserDao {
    private final Map<String, UserDTO> users = new HashMap<>();

    @Override
    public void create(UserDTO user) {

        this.users.compute(user.getLogin(), (k, v) -> {
            if (v != null) {
                throw new IllegalArgumentException("Пользователь с таким логином уже существует");
            }
            return user;
        });
    }

    @Override
    public Optional<UserDTO> getByLogin(String login) {
        return Optional.ofNullable(this.users.get(login));
    }
}
