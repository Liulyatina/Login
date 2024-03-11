package by.it_academy.registration.dao;

import by.it_academy.registration.dao.dto.UserDto;
import by.it_academy.registration.dao.api.IUserDao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class UserDao implements IUserDao {
    private final Map<String, UserDto> userMap = new HashMap<>();

    @Override
    public boolean addUser(String login, String password, String fullName, LocalDate birthDate) {
        if (userMap.containsKey(login)) {
            return false; // Пользователь с таким логином уже существует
        }

        UserDto user = new UserDto(login, password, fullName, birthDate, LocalDate.now(), "пользователь");
        userMap.put(login, user);
        return true;
    }

    @Override
    public boolean getUserByLogin(String login, String password) {
        UserDto user = userMap.get(login);
        return user != null && user.getPassword().equals(password);
    }
}
