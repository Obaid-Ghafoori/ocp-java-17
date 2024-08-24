package chapter_10.social_media_analyzer.application;

import chapter_10.social_media_analyzer.domain.User;
import chapter_10.social_media_analyzer.domain.UserEngagement;
import chapter_10.social_media_analyzer.domain.UserRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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

    /**
     * Sorts and returns a list of users based on the specified attribute.
     * The attribute can be "username", "email", or "postCount".
     *
     * @param attribute the attribute by which users should be sorted; valid options are "username", "email", or "postCount"
     * @return a {@code List<User>} sorted by the specified attribute
     * @throws IllegalArgumentException if the {@code attribute} is not one of the allowed values
     */
    public List<User> sortByAttribute(String attribute) {
        if (!"username".equals(attribute) && !"email".equals(attribute) && !"postCount".equals(attribute)) {
            throw new IllegalArgumentException("Invalid attribute: " + attribute);
        }

        return userRepository.findAll().stream()
                .sorted(getComparatorBy(attribute))
                .collect(Collectors.toList());
    }


    private static Comparator<User> getComparatorBy(String attribute) {
        return switch (attribute) {
            case "username" -> Comparator.comparing(User::username);
            case "email" -> Comparator.comparing(User::email);
            case "postCount" -> Comparator.comparingInt(User::postCount);
            default -> throw new IllegalArgumentException("Unexpected value: " + attribute);
        };
    }

    /**
     * Displays the user with the highest engagement.
     * <p>
     * This method identifies and displays the user with the highest engagement score.
     * Engagement is typically a composite metric based on various factors such as activity frequency,
     * types of activities, etc.
     */
    public Optional<Double> findHighestEngagementUser() {
        return userRepository.findAll().stream()
                .map(this::calculateEngagementScore)
                .max(Double::compare);
    }

    /**
     * Custom collector to aggregate user engagement data.
     *
     * @return A list of UserEngagement objects with engagement scores and total activities.
     */
    public List<UserEngagement> collectUserEngagementData() {
        return userRepository.findAll().stream()
                .map(user -> new UserEngagement(
                        user.username(),
                        calculateEngagementScore(user),
                        getTotalActivities(user)
                )).collect(Collectors.toList());
    }

    private static int getTotalActivities(User user) {
        return user.commentCount()
                + user.likeCount()
                + user.shareCount()
                + user.postCount();
    }

    private double calculateEngagementScore(User user) {
        var score = user.postCount()
                + user.commentCount() * 0.5
                + user.likeCount() * 0.2
                + user.shareCount() * 0.8;

        // Round the score to two decimal places
        BigDecimal roundedScore = new BigDecimal(score).setScale(2, RoundingMode.HALF_UP);

        return roundedScore.doubleValue();
    }
}
