package chapter_10.social_media_analyzer.ui;

import chapter_10.social_media_analyzer.application.UserService;
import chapter_10.social_media_analyzer.domain.User;
import chapter_10.social_media_analyzer.infrastructure.TablePrinter;

import java.util.List;

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
        TablePrinter.printTable(
                superActiveUsers,
                "User Data",
                user -> new Object[]{
                        user.userId(), user.username(), user.email(),
                        user.postCount(), user.commentCount(), user.likeCount(), user.shareCount()
                },
                "User"
        );


        //sort by username
        var byUsername = userService.sortByAttribute("username");
        TablePrinter.printTable(
                byUsername,
                "Sorted out by username",
                user -> new Object[]{
                        user.userId(), user.username(), user.email(),
                        user.postCount(), user.commentCount(), user.likeCount(), user.shareCount()
                },
                "User"
        );

        showHighestEngagedUser();

        TablePrinter.printTable(
                userService.collectUserEngagementData(),
                "User Engagement Data",
                engagement -> new Object[]{
                        engagement.user(),
                        String.format("%.2f", engagement.engagementScore()),
                        engagement.totalActivities()
                },
                "UserEngagement"
        );

    }

    private void showHighestEngagedUser() {
        var highestEngagedUser = userService.findHighestEngagementUser();
        System.out.println("highest engagement user with the engagement score of: " + highestEngagedUser.get());
    }
}
