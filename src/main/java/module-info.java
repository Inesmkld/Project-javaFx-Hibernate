module org.example.projectjavafxhibernate {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;  // Pour JDBC et SQL
    requires mysql.connector.j;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires static lombok;


    opens org.example.projectjavafxhibernate to javafx.fxml;
    opens org.example.projectjavafxhibernate.Controller to javafx.fxml;
    opens org.example.projectjavafxhibernate.Model to org.hibernate.orm.core;

    exports org.example.projectjavafxhibernate;
    exports org.example.projectjavafxhibernate.Controller;
    exports org.example.projectjavafxhibernate.Model;
    exports org.example.projectjavafxhibernate.Annotation;
    exports org.example.projectjavafxhibernate.DAO;
    exports org.example.projectjavafxhibernate.Service;
    exports org.example.projectjavafxhibernate.Util;
}