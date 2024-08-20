package chapter_10.social_media_analyzer;

import chapter_10.social_media_analyzer.domain.User;

public class SocialMediaAnalyzerApp {
    public static void main(String[] args) {
        User user = new User("123", "@John12", "john@email.com", 5666);
        System.out.println("User: "  + user.username());
    }
}
