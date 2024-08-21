package chapter_10.social_media_analyzer.infrastructure;

import chapter_10.social_media_analyzer.domain.User;
import chapter_10.social_media_analyzer.domain.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * In-memory implementation of the UserRepository interface.
 */
public class UserRepositoryImpl implements UserRepository {
    private final Map<Long, User> userDatabase = new HashMap<>();

    @Override
    public List<User> findAll() {
        return userDatabase.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(String userId) {
        return Optional.ofNullable(userDatabase.get(userId));
    }

    @Override
    public User save(User user) {
        if (userDatabase.containsKey(user.userId())) {
            throw new IllegalArgumentException(String.format("User ID already exists: %s", user.userId()));
        }
        userDatabase.put(user.userId(), user);
        return user;
    }

    @Override
    public void deleteById(String userId) {
        if (!userDatabase.keySet().contains(userId)) {
            throw new IllegalArgumentException(String.format("User ID %s does not exists: ", userId));
        }
        userDatabase.remove(userId);

    }

    @Override
    public void saveAll(List<User> users) {
        Map<Long, User> newUsers = users.stream().collect(Collectors.toMap(User::userId, user -> user));
        userDatabase.putAll(newUsers);
    }
}
