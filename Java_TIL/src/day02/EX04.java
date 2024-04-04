package day02;

public class EX04 {
    public static void main(String[] args) {
        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        bus.ride();
        taxi.ride();
        bus.getWheelNum();
        taxi.getWheelNum();
        bus.ring();
    }
}

class Car {
    void ride() {
        System.out.println("부릉부릉");
    }
}

class Bus extends Car {
    int wheel = 4;

    void ring() {
        System.out.println("RRRRRRR");
    }

    void getWheelNum() {
        System.out.println(this.wheel);
    }
}

class Taxi extends Car {
    int wheel = 4;

    void getWheelNum() {
        System.out.println(this.wheel);
    }
    @Override
    void ride() {
        System.out.println("빵빵");
    }
}