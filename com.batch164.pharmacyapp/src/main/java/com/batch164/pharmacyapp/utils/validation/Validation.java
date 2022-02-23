package com.batch164.pharmacyapp.utils.validation;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation
{

//  Check whether an email exists or not
  public static boolean isExistedEmail(String email, ArrayList<String> existedEmails)
  {
    for (String item : existedEmails)
    {
      if (item.equalsIgnoreCase(email))
      {
        return true;
      }
    }
    return false;
  }

  //  Check whether an email is valid or not
  public static boolean isValidEmail(String email)
  {
    String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(email);
    if (matcher.matches())
    {
      return true;
    }
    return false;
  }


//  public static boolean isValidEmail(String email)
//  {
//    String pattern = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)$";
//    if (email.matches(pattern))
//    {
//      return true;
//    }
//    else
//    {
//      return false;
//    }
//  }
}
