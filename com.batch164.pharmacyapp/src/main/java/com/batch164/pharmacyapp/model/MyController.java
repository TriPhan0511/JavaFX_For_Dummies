package com.batch164.pharmacyapp.model;

public interface MyController
{
  void setCurrentStore(Store currentStore);
  void setCurrentUser(Employee currentUser);
  void displayWelcomeMessage();
  void displayCurrentStore();
}
