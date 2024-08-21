package chapter_10.social_media_analyzer.ui;

import chapter_10.social_media_analyzer.application.UserService;
import chapter_10.social_media_analyzer.domain.User;

import java.util.List;

/**
 * The AnalyticsController class handles user interactions
 * and displays analytics results by using the UserService.
 */
public class AnalyticsController {

    private final UserService userService;

    /**
     * Constructs an AnalyticsController with the specified UserService.
     *
     * @param userService the UserService to be used by this controller
     */
    public AnalyticsController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Displays various user analytics results by using the UserService.
     * This method shows examples of filtering, sorting, and aggregating data.
     */
    public void showAnalytics() {
        List<User> superActiveUsers = userService.filterUsersWithMoreActivities(15);
        System.out.println("Active Users: " + superActiveUsers);
    }
}
