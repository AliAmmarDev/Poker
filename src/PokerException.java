/**
 * Throws an exception
 * Will be used to deal with errors in PokerHand
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
