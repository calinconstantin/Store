package ro.calin.Store.utils;

public class Tools {

    public static boolean checkNullEmpty(Object thisObject){
        if(thisObject==null || thisObject.equals(""))
            return true;
        return false;
    }
    public static boolean checkDigits(String thisString){
        return thisString.matches("[0-9]+");
    }
    public static boolean checkDouble(String thisString){
        return thisString.matches("[0-9.]+");
    }
    public static boolean checkLetter(String thisString){
        return thisString.matches("[a-z A-Z]+");
    }
    public static boolean checkMail(String thisString){
       return thisString.matches("[a-zA-Z0-9 @.]+");
    }
    public static boolean checkLetterDigits(String thisString){
        return thisString.matches("[a-zA-Z0-9]+");
    }

}
