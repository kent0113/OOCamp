package com.park;

public class Receipt {
    Manager manager;

    public Receipt() {
    }

    public Receipt(Manager manager) {
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
