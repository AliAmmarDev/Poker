/**
 * Throws an exception
 * Will be used to deal with errors in PokerHand
 * @author sc16aa Ali Ammar
 */
public class PokerException extends RuntimeException {

  /**
   * Throws an exception
   * @param  String error message
   */
  public PokerException (String message) {
    super (message);
  }
}
