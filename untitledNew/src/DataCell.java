import java.util.Arrays;

public class DataCell {

    String[][] table;
    String column;
    int row;
    int count;

    DataCell(String[][] data, String columnName, int rowNumber) {
        this.table = data;
        this.column = columnName;
        this.row = rowNumber;
    }

    DataCell(String[][] data, int rowNumber){
        this.table = data;
        this.row = rowNumber;
    }

    DataCell(String[][] data){
        this.table = data;
    }


    public int size() {
        return this.table.length;
    }

    public DataCell setValue(int number) {
        setValue(Integer.toString(number));
        return this;
    }

    public DataCell setValue(String str) {
        if (!column.isEmpty() || getColumn(column) != -1) {
            table[row][getColumn(column)] = str;
        }
        return this;
    }

    public DataCell addRow(String full) {
        count++;
        if (count > table.length - 1) {
            table = Arrays.copyOf(table, count * 2);
        }
        table[count] = full.split(",");
        return this;
    }

    public DataCell removeRow() {
        removeRow(row);
        return this;
    }

    public DataCell removeRow(int number) {
        for (int i = number; i < count; i++) {
            table[i] = table[i + 1];
        }
        table[count] = null;
        count--;
        return this;
    }

    public DataCell addColumn() {
        addColumn(new String[table.length]);
        return this;
    }

    public DataCell addColumn(String str) {
        addColumn(ru.vsu.cs.util.ArrayUtils.toStringArray(str));
        return this;
    }

    public DataCell addColumn(String[] str) {
        String[][] newTable = new String[table.length][table[0].length + 1];
        String[] replaceStr;
        for (int i = 0; i < newTable.length; i++) {
            if (table[i] != null) {
                replaceStr = Arrays.copyOf(table[i], table[0].length + 1);
                if (i < str.length) {
                    replaceStr[3] = str[i];
                }
                newTable[i] = replaceStr;
            } else {
                newTable[i] = null;
            }
        }
        table = newTable;
        return this;
    }

    public DataCell removeColumn(String columnName) {
        removeColumn(getColumn(columnName));
        return this;
    }

    public DataCell removeColumn(int columnReplace) {
        String[][] tableReplace = new String[table.length][table[0].length - 1];
        int newСounter = 0;
        for (int k = 0; k < table[0].length; k++) {
            if (k != columnReplace) {
                for (int i = 0; i < table.length; i++) {
                    if (table[i] != null) {
                        tableReplace[i][newСounter] = table[i][k];
                    } else {
                        tableReplace[i] = null;
                    }
                }
                newСounter++;
            }
        }
        table = tableReplace;
        return this;
    }


    public int getColumn(String str) {
        for (int i = 0; i < table.length; i++) {
            if (str.equals(table[0][i])) {
                return i;
            }
        }
        return -1;
    }


}
