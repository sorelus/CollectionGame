package com.altima.validation.utilis;

public class UrlsControllers {

    // for console
    public final static String createConsoleURL = "/create_console";
    public final static String listConsoleURL = "/list_console";
    public final static String findConsoleURL = "/find_console";

    // for JeuVideo
    public final static String createJeuURL = "/create_jeu";
    public final static String listJeuURL = "/list_jeu";
    public final static String findJeuURL = "/find_jeu";
    public final static String linkJeuURL = "/lier_jeu";

    // for User
    public final static String createUserURL = "/create_user";
    public final static String listUserURL = "/list_user";
    public final static String linkUserURL = "/list_jeux_user";
    public final static String deleteUserURL = "/delete_jeu";


    public final static String simpleCreateUserURL = "/registration";
    public final static String simpleUpdateProfile = "/update_profile";
    public final static String simpleListGameURL = "/my_game";
    public final static String simpleDeleteUserURL = "/delete_my_game";

    public static String getCreateConsoleURL() {
        return createConsoleURL;
    }

    public static void setCreateConsoleURL() {

    }
}
