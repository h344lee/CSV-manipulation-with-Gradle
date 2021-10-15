package com.kinaxis.interview;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import java.io.IOException;
import static tech.tablesaw.aggregate.AggregateFunctions.sum;

public class CSVGenerator {

    public static void main(String[] args){
        Table expeditionTable = readCSV("expeditions.csv");
        Table mineralsTable = getMineralTable(expeditionTable);
        writeCSV(mineralsTable, "minerals.csv");
    }

    public static Table readCSV(String filename) {
        String systemPath = System.getProperty("user.dir");
        System.out.println(systemPath);
        Table expeditionTable = null;
        try {
            expeditionTable = Table.read().csv(systemPath+"/data/"+filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expeditionTable;
    }

    public static void writeCSV(Table mineralsTable,String fileName) {
        String systemPath = System.getProperty("user.dir");
        try {
            mineralsTable.write().csv(systemPath+"/result/"+fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Table getMineralTable(Table expeditionTable) {
        Table mineralTable = expeditionTable.summarize("Quantity", sum).by("Mineral").sortOn("Mineral");

        StringColumn mineralCol = (StringColumn) mineralTable.column(0);
        DoubleColumn quantityCol = (DoubleColumn) mineralTable.column(1);

        String[] mineralColVal = mineralCol.asObjectArray();
        double[] quantityColVal = quantityCol.asDoubleArray();

        StringColumn MineralCol = StringColumn.create("Mineral", mineralColVal);
        DoubleColumn QuantityCol = DoubleColumn.create("Quantity", quantityColVal);

        Table mineralsTable = Table.create("minerals", MineralCol, QuantityCol);
        return mineralsTable;
    }


}
