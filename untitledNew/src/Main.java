import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[][] data = new String[][]{{"Name", "Info", "Id"},
                {"John", "Age: 30", "001"},
                {"Amy", "Age: 25", "002"},
                {"Mike", "Age: 35", "003"},
                {"Alice", "Age: 28", "004"},
                {"Tom", "Age: 42", "005"},
                {"Sara", "Age: 31", "006"},
                {"Jake", "Age: 29", "007"},
                {"Emily", "Age: 27", "008"},
                {"Chris", "Age: 33", "009"},
                {"Linda", "Age: 39", "010"},
                {"Paul", "Age: 36", "011"},
                {"Kate", "Age: 26", "012"},
                {"Bill", "Age: 45", "013"},
                {"Grace", "Age: 32", "014"},
        };
        TableData table = new TableData(data);
        table.column("Name").cell(5).setValue("132"); 
        table.cell("Info", 5).setValue(2); // параметрический полиморфизм
        table.cell("Id", 5).setValue(3); // параметрический полиморфизм
        table.addRow("8953132132, Age: 26, 012"); // добавлени ряда
        outputBase(table); // вывод таблицы
        System.out.println("---------------------------");
        table.row(1).removeRow(); // удаление ряда
        table.addColumn("Code 456 456 45423 234 234 58345 "); // добавление столбца
        table.cell("Name").removeColumn(); // удаление столбца
        outputBase(table); // вывод таблицы
    }


    public static void outputBase(TableData table) {
        for (int i = 0; i < table.size(); i++) {
            if (table.table[i] != null) {
                System.out.println(Arrays.toString(table.table[i]));
            }
        }
    }
}