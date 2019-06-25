package com.altima.validation.utilis;

public class UrlsControllers {

    private static final String create ="/create";
    private static final String find ="/find";
    private static final String list ="/list";
    private static final String link ="/lier";
    private static final String update ="/update";
    private static final String delete ="/delete";
    private static final String console ="/console";
    private static final String jeu ="/jeu";
    private static final String user ="/user";
    // for Console
    public static final String CREATE_CONSOLE_URL = console+create;
    public static final String LIST_CONSOLE_URL = console+list;
    public static final String FIND_CONSOLE_URL = console+find;

    // for JeuVideo
    public static final String CREATE_JEU_URL = jeu+create;
    public static final String LIST_JEU_URL = jeu+list;
    public static final String FIND_JEU_URL = jeu+find;
    public static final String LINK_JEU_URL = jeu+link;

    // for User
    public static final String CREATE_USER_URL = user+create;
    public static final String LIST_USER_URL = user+list;
    public static final String LINK_USER_URL = user+jeu+link;
    public static final String DELETE_USER_URL =user+jeu+delete;
    public static final String SIMPLE_CREATE_USER_URL = user+"/registration";
    public static final String SIMPLE_UPDATE_PROFILE = user+update;
    public static final String SIMPLE_LIST_GAME_URL = user+"/my_game";
    public static final String SIMPLE_DELETE_USER_URL = user+"/delete_my_game";
    public static final  String DOWNLOAD_FILE = "/downloads/{imageId}";



}
