module com.module.common {
    requires javafx.base;

    exports com.module.common;
    opens com.module.common to javafx.base;
}