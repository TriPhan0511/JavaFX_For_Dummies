module com.lowewriter.clickme
{
  requires javafx.controls;
  requires javafx.fxml;

  exports com.lowewriter.clickme;
  exports com.lowewriter.clickcounter;
  exports com.lowewriter.addsubtract1;
  exports com.lowewriter.addsubtract2;
  exports com.lowewriter.addsubtract3;
  exports com.lowewriter.addsubtract4;
  exports com.lowewriter.addsubtract5;
  exports com.lowewriter.testing;
  exports com.lowewriter.scenesswitcher;
  exports com.lowewriter.clickcounteralert;
  exports com.lowewriter.clickcounterexit;
  exports com.lowewriter.layoutpane_samples;

  exports com.triphan.stageandscene;

  opens com.triphan.pizzaorder to javafx.fxml;
  exports com.triphan.pizzaorder;

  opens com.lowewriter.validating_numeric_data to javafx.fxml;
  exports com.lowewriter.validating_numeric_data;

  opens com.lowewriter.getting_input_from_the_user.textfield_sample to javafx.fxml;
  exports com.lowewriter.getting_input_from_the_user.textfield_sample;

  opens com.lowewriter.getting_input_from_the_user.checkboxes_sample to javafx.fxml;
  exports com.lowewriter.getting_input_from_the_user.checkboxes_sample;

  opens com.lowewriter.getting_input_from_the_user.radiobuttons_sample to javafx.fxml;
  exports com.lowewriter.getting_input_from_the_user.radiobuttons_sample;

  opens com.lowewriter.choosing_from_a_list.choicebox_samples to javafx.fxml;
  exports com.lowewriter.choosing_from_a_list.choicebox_samples;

  opens com.lowewriter.choosing_from_a_list.combobox_samples to javafx.fxml;
  exports com.lowewriter.choosing_from_a_list.combobox_samples;

  opens com.lowewriter.choosing_from_a_list.listview_samples to javafx.fxml;
  exports com.lowewriter.choosing_from_a_list.listview_samples;

  opens com.triphan.master_detail_views_sample to javafx.fxml;
  exports com.triphan.master_detail_views_sample;

  opens com.lowewriter.choosing_from_a_list.listview_samples_2 to javafx.fxml;
  exports com.lowewriter.choosing_from_a_list.listview_samples_2;

}