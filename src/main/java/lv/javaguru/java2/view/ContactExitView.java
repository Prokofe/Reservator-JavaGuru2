package lv.javaguru.java2.view;

public class ContactExitView implements View{

    @Override
    public void execute() {
        System.out.println("Good by!");
        System.exit(0);
    }
}