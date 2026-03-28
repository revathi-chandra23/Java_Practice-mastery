package org._practice.exception_handling;

public class ThrowAndThrows {
    public static void main(String[] args) throws NullPointerException {
        String s="red";
      if(s==null)
      {
            throw new NullPointerException("Null Pointer Exception");
      }
      else {
          System.out.println(s);
      }
    }
}
