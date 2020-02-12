package Day05.excetption;

public class RegisterExcept extends /*Exception*/ RuntimeException{
    public RegisterExcept(){
        super();
    }
    public RegisterExcept(String message){
        super(message);
    }

}
