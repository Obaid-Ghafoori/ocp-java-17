package chapter_10.social_media_analyzer;

import chapter_10.social_media_analyzer.application.UserService;
import chapter_10.social_media_analyzer.domain.User;
import chapter_10.social_media_analyzer.domain.UserRepository;
import chapter_10.social_media_analyzer.infrastructure.UserRepositoryImpl;
import chapter_10.social_media_analyzer.ui.AnalyticsController;

import java.util.Arrays;
import java.util.List;

public class SocialMediaAnalyzerApp {
    public static void main(String[] args) {

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
        List<User> users = Arrays.asList(
                new User(1L, "JohnDoe", "john@example.com", 15, 10, 25,23),
                new User(2L, "JaneSmith", "jane@example.com", 5, 20, 10,40),
                new User(3L, "BobBrown", "bob@example.com", 12, 5, 30,6),
                new User(4L, "AliceBlue", "alice@example.com", 7, 8, 15,8),
                new User(5L, "TomGreen", "tom@example.com", 20, 15, 40,34),
                new User(6L, "EveWhite", "eve@example.com", 18, 25, 35, 56),
                new User(7L, "CharlieBlack", "charlie@example.com", 10, 5, 50,678),
                new User(8L, "NancyYellow", "nancy@example.com", 8, 12, 20,3),
                new User(9L, "ZaraGray", "zara@example.com", 25, 30, 60,8),
                new User(10L, "DavidPurple", "david@example.com", 14, 20, 30,99),
                new User(11L, "MonaRed", "mona@example.com", 11, 9, 18,1),
                new User(12L, "SamBlue", "sam@example.com", 22, 14, 45,0),
                new User(13L, "OliverBrown", "oliver@example.com", 17, 11, 25,555),
                new User(14L, "LilyPink", "lily@example.com", 19, 13, 35,45),
                new User(15L, "GeorgeGreen", "george@example.com", 9, 16, 28,78),
                new User(16L, "SophiaBlue", "sophia@example.com", 13, 18, 22,9),
                new User(17L, "HenryWhite", "henry@example.com", 6, 8, 15,7),
                new User(18L, "IsabellaBlack", "isabella@example.com", 21, 19, 42,2),
                new User(19L, "LiamGray", "liam@example.com", 23, 20, 50, 6),
                new User(20L, "EmmaOrange", "emma@example.com", 16, 12, 30,7)
        );
        // Saving the users to the repository
        userRepository.saveAll(users);
    }
}
