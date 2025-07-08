package services;

import interfaces.Sendable;

public class MailService {
    public static void send(Sendable book, String email) {
        System.out.println("MailService: Sent to " + email);
    }
}