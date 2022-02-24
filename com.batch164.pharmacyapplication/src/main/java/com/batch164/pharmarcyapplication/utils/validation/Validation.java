package com.batch164.pharmarcyapplication.utils.validation;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation
{
//  Check whether an email exists or not
public static boolean isExistedItem(
    String itemNeedToCheck, ArrayList<String> existedItems)
{
  for (String item : existedItems)
  {
    if (item.equalsIgnoreCase(itemNeedToCheck))
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
}





















