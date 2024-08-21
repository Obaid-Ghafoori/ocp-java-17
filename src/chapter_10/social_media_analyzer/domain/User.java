package chapter_10.social_media_analyzer.domain;

import java.util.Objects;

/**
 * Represents a user in the system.
 */
public record User(
        long userId,
        String username,
        String email,
        int postCount
) {

    /**
     * Initializes a new User record.
     */
    public User {
        Objects.requireNonNull(userId, "userId must not be null");
        Objects.requireNonNull(username, "username must not be null");
        Objects.requireNonNull(email, "email must not be null");
    }
}

