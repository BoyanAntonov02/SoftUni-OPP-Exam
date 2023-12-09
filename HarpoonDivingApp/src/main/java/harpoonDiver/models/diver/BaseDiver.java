package harpoonDiver.models.diver;

import harpoonDiver.common.ExceptionMessages;
import harpoonDiver.models.seaCatch.SeaCatch;

import java.util.Collection;

public abstract class BaseDiver implements Diver{
    private String name;
    private double oxygen;
    private SeaCatch seaCatch;

    public BaseDiver(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
    }

    private void setName(String name){
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.DIVER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setOxygen(double oxygen){
        if (oxygen < 0) throw new IllegalArgumentException(ExceptionMessages.DIVER_OXYGEN_LESS_THAN_ZERO);
        this.oxygen = oxygen;

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canDive() {
        return oxygen > 0;
    }

    @Override
    public SeaCatch getSeaCatch() {
        return seaCatch;
    }

    @Override
    public void shoot() {
        if(oxygen > 0) {
            this.oxygen = oxygen - 30;
        }else this.oxygen = 0;
    }
}
