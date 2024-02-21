import java.util.Arrays;

public class TableFunctions {

    String[][] table;
    String column;
    int row;
    int count;

    public TableFunctions(String[][] table) {
        this.table = table;
        count = table.length - 1;
    }

    public TableFunctions() {
        this.table = new String[5][5];
        count = table.length - 1;
    }

    public int size() {
        return this.table.length;
    }

    public TableFunctions column(String str) {
        this.column = str;
        return this;
    }

    public TableFunctions cell(String str) {
        this.column = str;
        return this;
    }

    public TableFunctions row(int number) {
        this.row = number;
        return this;
    }

    public TableFunctions cell(int number) {
        this.row = number;
        return this;

    }

    public TableFunctions cell(String str, int number) {
        this.column = str;
        this.row = number;
        return this;
    }

    public TableFunctions cell(int number, String str) {
        this.column = str;
        this.row = number;
        return this;
    }


    public TableFunctions setValue(int number) {
        setValue(Integer.toString(number));
        return this;
    }

    public TableFunctions setValue(String str) {
        if (!column.isEmpty() || getColumn(column) != -1) {
            table[row][getColumn(column)] = str;
        }
        return this;
    }

    public TableFunctions addRow(String full) {
        count++;
        if (count > table.length - 1) {
            table = Arrays.copyOf(table, count * 2);
        }
        table[count] = full.split(",");
        return this;
    }

    public TableFunctions removeRow() {
        removeRow(row);
        return this;
    }

    public TableFunctions removeRow(int number) {
        for (int i = number; i < count; i++) {
            table[i] = table[i + 1];
        }
        table[count] = null;
        count--;
        return this;
    }

    public TableFunctions addColumn() {
        addColumn(new String[table.length]);
        return this;
    }

    public TableFunctions addColumn(String str) {
        addColumn(ru.vsu.cs.util.ArrayUtils.toStringArray(str));
        return this;
    }

    public TableFunctions addColumn(String[] str) {
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

    public TableFunctions removeColumn() {
        removeColumn(getColumn(column));
        return this;
    }

    public TableFunctions removeColumn(int columnReplace) {
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
