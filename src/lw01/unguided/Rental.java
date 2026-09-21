package lw01.unguided;

public abstract class Rental implements Chargeable {
    private String id;
    private int days;

    public Rental(String id, int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Days must be greater than zero.");
        }
        this.id = id;
        this.days = days;
    }
    public String getId() {
        return this.id;
    }
    public int getDays() {
        return this.days;
    }

    @Override 
    public abstract int calculateCharge();

    public int calculateCharge(int unit) {
        if (unit <= 0) {
            throw new IllegalArgumentException("Unit must be greater than zero.");
        }
        
        return unit * calculateCharge(); 
    }
    public String label() {
        return "Rental";
    }
    
    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }




} 

