package com.interfaces.challenge;

enum Geometry {LINE, POINT, POLYGON};

enum Color {BLACK, BLUE, GREEN, ORANGE, RED};

enum PointMarker { CIRCLE, PUSH_PIN, STAR, SQUARE, TRIANGLE};

enum LineMarker { DASHED, DOTTED, SOLID}

public interface Mappable {

    String JSON_PROPERTY = """
            "properties": {%s} """;

    String getLabel();
    Geometry getShape();
    String getMarker();

    private static void testingIterfacePrivateMethodFunctionality(){
        var date =  new java.util.Date();
        System.out.println(date);
    }

    default String toJSON(){
        testingIterfacePrivateMethodFunctionality();
        return """
                "type": "%s", "label": "%s", "marker": "%s" """
                .formatted(getShape(), getLabel(), getMarker());
    }

    static void mapIt(Mappable mappable){
        testingIterfacePrivateMethodFunctionality();
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }

}
