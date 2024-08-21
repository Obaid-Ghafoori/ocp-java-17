package chapter_10.social_media_analyzer;

import chapter_10.social_media_analyzer.application.UserService;
import chapter_10.social_media_analyzer.domain.User;
import chapter_10.social_media_analyzer.domain.UserRepository;
import chapter_10.social_media_analyzer.infrastructure.UserRepositoryImpl;
import chapter_10.social_media_analyzer.ui.AnalyticsController;

import java.util.Arrays;

public class SocialMediaAnalyzerApp {
    public static void main(String[] args) {
        User user = new User(123l, "@John12", "john@email.com", 5666);
        System.out.println("User: " + user.username());

        // initialize user Repository
        UserRepository userRepository = new UserRepositoryImpl();


        // Add some sample users to the repository
        addSampleUsers(userRepository);

        // initialize user service
        UserService userService = new UserService(userRepository);

        // Initialize the AnalyticsController with the UserService
        AnalyticsController analyticsController = new AnalyticsController(userService);

        // call show analytics
        analyticsController.showAnalytics();
    }

    /**
     * Adds sample users to the UserRepository for testing purposes.
     */
    private static void addSampleUsers(UserRepository userRepository) {
        // Creating some sample users with different activity counts
        User user1 = new User(1L, "JohnDoe", "john@example.com", 15);  // 15 activities
        User user2 = new User(2L, "JaneSmith", "jane@example.com", 5);  // 5 activities
        User user3 = new User(3L, "BobBrown", "bob@example.com", 12);   // 12 activities
        User user4 = new User(4L, "AliceBlue", "d-alice@example.com", 7); // 7 activities
        User user5 = new User(5L, "TomGreen", "tom@example.com", 20);   // 20 activities

        // Saving the users to the repository
        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5));
    }
}
