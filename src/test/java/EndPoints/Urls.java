package EndPoints;

public class Urls {
    public static String baseUrl = "https://api.trello.com/1";

    public static String createBoardUrl = "/boards/";
    public static String GetBoardUrl = "/boards/{id}";
    public static String UpdateBoardUrl = "/boards/{id}";
    public static String DeleteBoardUrl = "/boards/{id}";

    public static String createListUrl = "/lists/";
    public static String GetListUrl = "/lists/{id}";
    public static String UpdateListUrl = "/lists/{id}";

    public static String createCardUrl = "/cards/";
    public static String GetCardUrl = "/cards/{id}";
    public static String UpdateCardUrl = "/cards/{id}";
    public static String DeleteCardUrl = "/cards/{id}";

    public static String CreateChecklistUrl = "cards/{id}/checklists";
    public static String getChecklistUrl = "cards/{id}/checklists";
    public static String UpdateChecklistUrl = "checklists/{id}";
    public static String DeleteChecklistUrl = "checklists/{id}";

    public static String CreateCheckItemUrl = "checklists/{id}/checkItems";
    public static String getCheckItemUrl = "checklists/{id}/checkItems/{idCheckItem}";
    public static String DeleteCheckItemUrl = "checklists/{id}/checkItems/{idCheckItem}";

}

