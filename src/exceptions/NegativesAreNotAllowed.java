package exceptions;

public class NegativesAreNotAllowed extends RuntimeException{
    public NegativesAreNotAllowed(String numbers){
        super("Negatives are not allowed : " + numbers);
    }
}
