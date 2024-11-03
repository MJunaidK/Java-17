package com.interfaces.challenge;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Mappable> mappables = new ArrayList<>();
        mappables.add(new Building("Circuit house", UsageType.GOVERNMENT));
        mappables.add(new Building("Prabha Talkies", UsageType.ENTERTAINMENT));
        mappables.add(new Building("Bareilly Stadium", UsageType.SPORTS));

        mappables.add(new UtilityLine("Colege st", UtilityType.FIBER_OPTIC));
        mappables.add(new UtilityLine("Akshar vihar", UtilityType.WATER));
        for(var m: mappables ){
            Mappable.mapIt(m);
        }
    }
}
