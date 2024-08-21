package chapter_10.social_media_analyzer.domain;

import java.util.List;
import java.util.Optional;

/**
 * Interface for accessing user data.
 */
public interface UserRepository {

    /**
     * Retrieves all users.
     *
     * @return a list of all users
     */
    List<User> findAll();

    /**
     * Retrieves a user by their unique identifier.
     *
     * @param userId the unique identifier of the user
     * @return an Optional containing the user if found, or an empty Optional if not
     */
    Optional<User> findById(String userId);

    /**
     * Saves a new or existing user.
     *
     * @param user the user to be saved
     * @return the saved user
     */
    User save(User user);

    /**
     * Deletes a user by their unique identifier.
     *
     * @param userId the unique identifier of the user to be deleted
     */
    void deleteById(String userId);

    void saveAll(List<User> asList);
}

