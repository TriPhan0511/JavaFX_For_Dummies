package com.batch164.pharmacyapp.model;

public interface InformationDisplayable
{
  void setCurrentStore(Store currentStore);
  void setCurrentUser(Employee currentUser);
  void displayWelcomeMessage();
  void displayCurrentStore();
}
