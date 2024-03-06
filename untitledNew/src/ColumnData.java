import javax.xml.crypto.Data;

public class ColumnData {
    public String[][] table;
    public String column;

    ColumnData(String[][] table, String str){
        this.column = str;
        this.table = table;
    }

    public DataCell cell(int rowNumber) {
        return new DataCell(table, column, rowNumber);
    }

    public DataCell removeColumn() {
        return new DataCell(table).removeColumn(column);
    }

}
