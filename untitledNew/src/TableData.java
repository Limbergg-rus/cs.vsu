public class TableData {
    public String[][] table;

    TableData(String[][] arr) {
        this.table = arr;
    }

    public ColumnData column(String str) {
        return new ColumnData(table, str);
    }
    public ColumnData cell(String columnName) {
        return new ColumnData(table, columnName);
    }

    public RowData row(int rowNumber) {
        return new RowData(table, rowNumber);
    }

    public DataCell cell(String columnName, int rowNumber) {
        return new DataCell(table, columnName, rowNumber);
    }

    public DataCell addRow(String s) {
        return new DataCell(table).addRow(s);
    }

    public DataCell addColumn(String s) {
        return new DataCell(table).addColumn(s);
    }

    public int size(){
        return this.table.length;
    }
}
