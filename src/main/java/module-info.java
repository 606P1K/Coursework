module com.stepaniuk.taxipark {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;
    requires org.apache.logging.log4j;


    opens com.stepaniuk.taxipark to javafx.fxml;
    exports com.stepaniuk.taxipark;
    exports com.stepaniuk.taxipark.Controllers;
    opens com.stepaniuk.taxipark.Controllers to javafx.fxml;
    exports com.stepaniuk.taxipark.Database;
    exports com.stepaniuk.taxipark.Controllers.Universal;
    opens com.stepaniuk.taxipark.Controllers.Universal to javafx.fxml;
    exports com.stepaniuk.taxipark.Controllers.findControllers;
    opens com.stepaniuk.taxipark.Controllers.findControllers to javafx.fxml;
}