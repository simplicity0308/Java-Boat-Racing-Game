public class Menu{
    //attributes, set to -1 is to prevent trigger action automatically
    int userInput = -1;
    public static void main(String[] args) {
        Text text = new Text();
        System.out.println(text.getWelcomeBanner());
        System.out.println(text.getAction());
        UserInput userInput = new UserInput();
    }
}   