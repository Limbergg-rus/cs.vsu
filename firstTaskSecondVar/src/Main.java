public class Main {
    public static void main(String[] args) {
        Table table = new Table(new String[][]{{"1", "2", "3", "4", "5",},
                {"6", "7", "8", "9", "10"},
                {"11", "12", "13", "14", "15"}});

        int value = table.row(1).cell("1").getValueAsInt();
        table.addRow(new String[]{"16", "17", "18", "19", "20"});
        table.column("1").cell(1).setValue("123");
        table.cell("1", 1).setValue(value + 1); // параметрический полиморфизм
        table.cell(1, "1").setValue(value + 2);
        table.addColumn(new String[]{"6", "17", "18", "19", "20"});// параметрический полиморфизм
        table.column("5").removeColumn();
        table.row(0).removeRow();
        table.column("1").insertColumn(new String[]{"lol", "kek", "cringe"});
        table.row(1).insertRow(new String[]{"1000-7", "zxc", "qwe"});

        table.print();
    }
}



