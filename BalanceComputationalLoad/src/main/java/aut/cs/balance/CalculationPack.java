package aut.cs.balance;


import java.util.ArrayList;

public class CalculationPack {
    private final int volume;
    private boolean accepted;
    private ArrayList<Integer> rejectedBy;

    public CalculationPack(int volume) {
        this.volume = volume;
        this.accepted = false;
        this.rejectedBy = new ArrayList<>();
    }

    int getVolume() {
        return this.volume;
    }

    void accept() {
        this.accepted = true;
    }

    boolean isRejectedBy(int id) {
        return this.rejectedBy.contains(id);
    }

    void addRejectionComputer(int id) {
        this.rejectedBy.add(id);
    }
}
