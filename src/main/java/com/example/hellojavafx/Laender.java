/*
 */
package com.example.hellojavafx;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author stephan
 */
public abstract class Laender {
    private static final HashMap<String, String[]> bundeslaender = new HashMap<>();
    private static final Set<String> laender = new HashSet<>();
    
    public static Set<String> gibLaender() {
        if (laender.isEmpty()) {
            laender.add("Deutschland");
            laender.add("Österreich");
        }
        return Collections.unmodifiableSet(laender);
    }
    
    public static Set<String> gibBundeslaender(String land) {
        if (bundeslaender.isEmpty()) {
            bundeslaender.put("Deutschland", new String[]{
                "Baden-Württemberg",
                "Bayern",
                "Berlin",
                "Brandenburg",
                "Bremen",
                "Hamburg",
                "Hessen",
                "Mecklenburg-Vorpommern",
                "Niedersachsen",
                "Nordrhein-Westfalen",
                "Rheinland-Pfalz",
                "Saarland",
                "Sachsen",
                "Sachsen-Anhalt",
                "Schleswig-Holstein",
                "Thüringen"
            });

            bundeslaender.put("Österreich", new String[]{
                "Burgenland",
                "Kärnten",
                "Niederösterreich",
                "Oberösterreich",
                "Salzburg",
                "Steiermark",
                "Tirol",
                "Vorarlberg",
                "Wien"
            });
        }
        
        return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            bundeslaender.getOrDefault(land, new String[]{})
        )));
    }
}
