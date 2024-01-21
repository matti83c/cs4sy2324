public class NameTooLongException extends Exception{

  public NameTooLongException(){}

  public NameTooLongException(String msg){
    super(msg);
  }
}