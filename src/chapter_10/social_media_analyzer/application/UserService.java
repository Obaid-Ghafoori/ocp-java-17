package chapter_10.social_media_analyzer.application;

import chapter_10.social_media_analyzer.domain.User;
import chapter_10.social_media_analyzer.domain.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Provides business logic for user operations.
 * This service interacts with the {@link UserRepository} to perform operations such as filtering and sorting users.
 */
public class UserService {
    private final UserRepository userRepository;

    /**
     * Constructs a {@code UserService} with the specified {@link UserRepository}.
     *
     * @param userRepository the {@link UserRepository} to be used by this service
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Filters and returns a list of users who have more than the specified number of activities.
     * This method helps identify highly active users based on their activity count.
     *
     * @param minActivities the minimum number of activities a user must have to be included in the result list
     * @return a {@code List<User>} containing users who have more than {@code minActivities} activities
     * @throws IllegalArgumentException if {@code minActivities} is negative
     */
    public List<User> filterUsersWithMoreActivities(int minActivities) {
        if (minActivities < 0) {
            throw new IllegalArgumentException("minActivities must be non-negative");
        }

        return userRepository.findAll().stream()
                .filter(user -> user.postCount() > minActivities)
                .collect(Collectors.toList());

    }
}
