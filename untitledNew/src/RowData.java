public class RowData {
    public String[][] table;
    public int row;
    RowData(String[][] table, String row){
        this.row = Integer.parseInt(row);
        this.table = table;
    }
    RowData(String[][] table, int row){
        this.row = row;
        this.table = table;
    }
    public DataCell removeRow(){
        return new DataCell(table, row).removeRow();
    }


    public DataCell cell(String columnName){
        return new DataCell(table, columnName,row);
    }
}
