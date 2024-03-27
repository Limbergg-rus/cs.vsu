import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Cell {
    String place;

    Cell(String place) {
        this.place = place;
    }

    public void setValue(String value) {
        this.place = value;
    }

    public void setValue(int value) {
        this.place = String.valueOf(value);
    }

    public int getValueAsInt() {
        return Integer.parseInt(this.place);
    }

    public String getValue() {
        return this.place != null ? this.place : "null";
    }
}

class Row {
    HashMap<String, Cell> cells; // ключи - названия столбцов, значения - ячейки

    Row(String[] columnName, Cell[] cell) {
        this.cells = new HashMap<>();
        for (int i = 0; i < columnName.length; i++) {
            this.cells.put(columnName[i], cell[i]);
        }
    }

    public Cell cell(String columnName) {
        return this.cells.get(columnName);
    }

    public void insertRow(String[] replaceArr) {
        HashMap<String, Cell> replaceMap = this.cells;
        int count = 0;
        for (var key : replaceMap.keySet()) {
            if (count < replaceArr.length) {
                replaceMap.get(key).place = replaceArr[count];
            } else {
                break;
            }
            count++;
        }
    }

    public void removeRow() {
        HashMap<String, Cell> deleteArr = this.cells;
        for (var key : deleteArr.keySet()) {
            deleteArr.get(key).place = "null";
        }
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        for (String i : cells.keySet()) {
            out.append(i).append(": ").append(cells.get(i).getValue()).append(", ");
        }
        return out.toString();
    }

    public String[] getColumn() {
        String[] arr = new String[cells.keySet().size()];
        int index = 0;
        for (var i : this.cells.keySet()) {
            arr[index] = i;
            index++;
        }
        return arr;
    }
}

class Column {
    ArrayList<Cell> cells; // ячейки колонки

    Column(Cell[] arr) {
        this.cells = new ArrayList<>();
        this.cells.addAll(Arrays.asList(arr));
    }

    public Cell cell(int i) {
        return this.cells.get(i);
    }

    public void insertColumn(String[] replaceArr) {
        ArrayList<Cell> arr = this.cells;
        int count = 0;
        for (var i : arr) {
            if (count < replaceArr.length) {
                i.place = replaceArr[count];
            } else {
                break;
            }
            count++;
        }
    }

    public void removeColumn() {
        ArrayList<Cell> arr = this.cells;
        for (var i : arr) {
            i.place = "null";
        }
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        for (Cell i : cells) {
            out.append(i.place).append(", ");
        }
        return out.toString();
    }
}


class Table {
    HashMap<String, Column> cells; // ключи - названия столбцов
    ArrayList<Row> rows; // список строк
    int sizeRow;
    int sizeColumn;

    Table(String[][] table) {
        this.rows = new ArrayList<>();
        this.cells = new HashMap<>();
        this.sizeRow = table.length;
        this.sizeColumn = table[0].length;

        Cell[][] tempTable = new Cell[table.length][table[0].length];
        //Создание таблицы через матрицу Cell[][]
        createCellTable(table, tempTable);

        //Создание списка строк с передачей ссылок из cell
        createRowTable(table, tempTable);

        //Создание коллекции ключ/значение с передачей ссылок из cell
        createColumnTable(table, tempTable);
    }

    private void createColumnTable(String[][] table, Cell[][] tempTable) {
        for (int i = 0; i < sizeColumn; i++) {
            Cell[] arr = new Cell[sizeRow - 1];
            for (int k = 0; k < arr.length; k++) {
                arr[k] = tempTable[k + 1][i];
            }
            this.cells.put(table[0][i], new Column(arr));
        }
    }

    private void createRowTable(String[][] table, Cell[][] tempTable) {
        for (int i = 1; i < sizeRow; i++) {
            this.rows.add(new Row(table[0], tempTable[i]));
        }
    }

    private void createCellTable(String[][] table, Cell[][] tempTable) {
        for (int i = 0; i < sizeRow; i++) {
            for (int k = 0; k < sizeColumn; k++) {
                tempTable[i][k] = new Cell(table[i][k]);
            }
        }
    }

    public void addRow(String[] arr) {
        Cell[] newRow = new Cell[sizeColumn];
        int peak = Math.min(arr.length, sizeColumn);
        for (int i = 0; i < peak; i++) {
            newRow[i] = new Cell(arr[i]);
        }
        addRowToRowTable(newRow);
        addRowToColumnTable(arr, newRow);
        this.sizeRow++;
    }

    private void addRowToColumnTable(String[] arr, Cell[] newRow) {
        Cell[][] table = getValues(cells);
        String[] ColumnName = getColumnNames(cells);

        this.cells = new HashMap<>();
        for (int i = 0; i < sizeColumn; i++) {
            Cell[] tempArr = new Cell[sizeRow];
            int peak = Math.min(arr.length, sizeRow);
            System.arraycopy(table[i], 0, tempArr, 0, peak);
            tempArr[sizeRow - 1] = newRow[i];
            this.cells.put(ColumnName[i], new Column(tempArr));
        }
    }

    private Cell[][] getValues(HashMap<String, Column> cells) {
        Cell[][] arr = new Cell[sizeColumn][sizeRow];
        int rowIndex = 0;
        for (String keys : cells.keySet()) {
            int colIndex = 0;
            for (Cell item : cells.get(keys).cells) {
                arr[rowIndex][colIndex] = item;
                colIndex++;
            }
            rowIndex++;
        }
        return arr;
    }

    private String[] getColumnNames(HashMap<String, Column> cells) {
        String[] columnName = new String[cells.keySet().size()];
        int rowIndex = 0;
        for (String keys : cells.keySet()) {
            columnName[rowIndex] = keys;
            rowIndex++;
        }
        return columnName;
    }


    private void addRowToRowTable(Cell[] newRow) {
        this.rows.add(new Row((this.rows.getFirst().getColumn()), newRow));
    }

    public void addColumn(String[] arr) {
        Cell[] newRow = new Cell[sizeRow];
        int peak = Math.min(arr.length + 1, sizeRow);
        for (int i = 0; i < peak; i++) {
            newRow[i] = new Cell(arr[i + 1]);
        }
        addColumnToRowTable(arr, newRow);
        addColumnToColumnTable(arr, newRow);
        this.sizeColumn++;
    }

    private void addColumnToColumnTable(String[] arr, Cell[] newRow) {
        this.cells.put(arr[0], new Column(newRow));
    }

    private void addColumnToRowTable(String[] arr, Cell[] newRow) {
        int index = 0;
        for (Row item : rows) {
            item.cells.put(arr[0], newRow[index]);
            index++;
        }
    }

    public Column column(String columnName) {
        return this.cells.get(columnName);
    }

    public Row row(int index) {
        return this.rows.get(index);
    }

    public Cell cell(String columnName, int index) {
        return this.cells.get(columnName).cell(index);
    }

    public Cell cell(int index, String columnName) {
        return this.rows.get(index).cell(columnName);
    }

    public void print() {
        System.out.println("--------Cell----------");
        System.out.println("Названия столбца: Столбец ");
        for (String i : this.cells.keySet()) {
            System.out.println(i + ": " + this.cells.get(i).toString());
        }
        System.out.println("--------Row----------");
        for (Row i : this.rows) {
            System.out.println(i.toString());
        }
    }

}