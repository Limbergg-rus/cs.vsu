package ru.vsu.cs.aslanovrenat.oldtasks.task10;

public class DataBaseRealty {
    public String name;
    public int kitchenArea;
    public int totalArea;
    public int countRooms;
    public int price;


    public DataBaseRealty(String name, int countRooms, int totalArea, int kitchenArea, int price) {
        this.name = name;
        this.totalArea = totalArea;
        this.kitchenArea = kitchenArea;
        this.countRooms = countRooms;
        this.price = price;
    }
}
