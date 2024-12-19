package cokr.oneweeks.member_post.exception;


public class UnsignedAuthException extends RuntimeException {
  public UnsignedAuthException(String msg) {
    super(msg);
    //없으면 기본생성자만 있음.
  }
}
