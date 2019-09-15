/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setandhashset;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ash_360
 */
public final class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> sattelites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.sattelites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSattelites() {
        return new HashSet<>(this.sattelites);
    }

    // add moon
    public boolean addMoon(HeavenlyBody moon) {
        return this.sattelites.add(moon);
    }
    
    

}
