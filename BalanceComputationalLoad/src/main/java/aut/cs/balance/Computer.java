package aut.cs.balance;

import java.util.ArrayList;

public class Computer {
    private static int lastId = 1;


    private final int totalCapacity;
    private ArrayList<Computer> neighbors;
    private int usedCapacity;
    private int id;

    public Computer(int capacity) {
        this.totalCapacity = capacity;
        this.usedCapacity = 0;
        this.neighbors = new ArrayList<>();
        this.id = lastId;
        lastId++;
    }

    public int getId() {
        return this.id;
    }

    public int getTotalCapacity() {
        return this.totalCapacity;
    }

    public void connect(Computer computer) {
        this.neighbors.add(computer);
    }

    public int getUsedCapacity() {
        return this.usedCapacity;
    }

    /**
     * @param c calculation pack
     * @return -1 if no one accepted the pack, otherwise id of the accepting machine
     */
    public int handle(CalculationPack c) {
        if (((float) (this.getUsedCapacity() + c.getVolume()) / (float) (this.getTotalCapacity())) < 0.81) {
            //accept
            c.accept();
            this.usedCapacity += c.getVolume();
            return this.id;
        } else {
            //reject
            c.addRejectionComputer(this.id);
            for (Computer computer : this.neighbors) {
                if (!c.isRejectedBy(computer.id)) {
                    int result = computer.handle(c);
                    if (result != -1) {
                        return result;
                    }
                }
            }
            return -1;
        }
    }
}
