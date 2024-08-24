package chapter_10.social_media_analyzer.ui;

import chapter_10.social_media_analyzer.application.UserService;
import chapter_10.social_media_analyzer.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * The AnalyticsController class handles user interactions
 * and displays analytics results by using the UserService.
 */
public class AnalyticsController {

    public static final int BY_TWO = 2;
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
        displayUserAnalyticsTable(superActiveUsers, "active users list");

        //sort by username
        var byUsername = userService.sortByAttribute("username");
        displayUserAnalyticsTable(byUsername, "Sorted out by username:");
        
        showHighestEngagedUser();
    }

    private static void displayUserAnalyticsTable(List<User> superActiveUsers, String title) {
        // Define the column width and table width
        String format = "%-10s %-20s %-25s %-10s %-10s %-10s %5s";
        int tableWidth = String.format(format, "User ID", "Username", "Email", "Posts", "Comments", "Likes", "Share").length();

        // Center the title
        int titlePadding = (tableWidth - title.length()) / BY_TWO;
        String centeredTitle = String.format("%" + titlePadding + "s%s", "", title.toUpperCase());

        // Print the centered title and the table
        System.out.println("\n" + centeredTitle);
        System.out.println(String.format(format, "User ID", "Username", "Email", "Posts", "Comments", "Likes", "Share"));
        System.out.println("------------------------------------------------------------------------------------------------");

        for (User user : superActiveUsers) {
            System.out.println(String.format(format,
                    user.userId(), user.username(), user.email(),
                    user.postCount(), user.commentCount(), user.likeCount(), user.shareCount()));
        }
        System.out.println("------------------------------------------------------------------------------------------------");
    }

    private void showHighestEngagedUser() {
        Optional<Double> highestEngagedUser = userService.findHighestEngagementUser();
        System.out.println("highest engagement user with the engagement score of: " + highestEngagedUser.get());

    }
}
