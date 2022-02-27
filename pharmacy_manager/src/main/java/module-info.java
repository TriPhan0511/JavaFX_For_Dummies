module com.pharmacy_management.pharmacy_manager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    opens com.pharmacy_management.pharmacy_manager to javafx.fxml;
    exports com.pharmacy_management.pharmacy_manager;
    exports com.pharmacy_management.pharmacy_manager.controller;
    opens com.pharmacy_management.pharmacy_manager.controller to javafx.fxml;
    opens com.pharmacy_management.pharmacy_manager.models to javafx.fxml;
    exports com.pharmacy_management.pharmacy_manager.map;
    opens com.pharmacy_management.pharmacy_manager.map to javafx.fxml;
    exports com.pharmacy_management.pharmacy_manager.mapper;
    opens com.pharmacy_management.pharmacy_manager.mapper to javafx.fxml;
    exports com.pharmacy_management.pharmacy_manager.DBUtils;
    opens com.pharmacy_management.pharmacy_manager.DBUtils to javafx.fxml;
    exports com.pharmacy_management.pharmacy_manager.models;
}