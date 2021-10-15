package com.kinaxis.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CSVGeneratorTest {
    @Test
    public void readCSV_filenameIsNull() {
        assertThrows(IllegalStateException.class, () -> {
            CSVGenerator.readCSV(null);
        });
    }

    @Test
    public void readCSV_wrongFilename() {
        assertThrows(IllegalStateException.class, () -> {
            CSVGenerator.readCSV("abc.csv");
        });
    }

    @Test
    public void writeCSV_TableIsNull() {
        Table firstAugment= null;
        assertThrows(NullPointerException.class, () -> {
            CSVGenerator.writeCSV(firstAugment, "minerals.csv");
        });
    }

    @Test
    public void testCase1() {
        Table testCaseTable = CSVGenerator.readCSV("testCase1.csv");
        Table mineralsTable = CSVGenerator.getMineralTable(testCaseTable);

        String[] expectedMineralColVal = {"Chromium", "Gold", "Titanium"};
        double[] expectedQuantityColVal = {13,9,3};

        StringColumn mineralCol = (StringColumn) mineralsTable.column(0);
        DoubleColumn quantityCol = (DoubleColumn) mineralsTable.column(1);

        String[] mineralColVal = mineralCol.asObjectArray();
        double[] quantityColVal = quantityCol.asDoubleArray();

        Assertions.assertArrayEquals(expectedMineralColVal, mineralColVal);
        Assertions.assertArrayEquals(expectedQuantityColVal, quantityColVal);
    }

    @Test
    public void testCase2() {
        Table testCaseTable = CSVGenerator.readCSV("testCase2.csv");
        Table mineralsTable = CSVGenerator.getMineralTable(testCaseTable);

        String[] expectedMineralColVal = {"Chromium", "Gold", "Titanium"};
        double[] expectedQuantityColVal = {3,2,2};

        StringColumn mineralCol = (StringColumn) mineralsTable.column(0);
        DoubleColumn quantityCol = (DoubleColumn) mineralsTable.column(1);

        String[] mineralColVal = mineralCol.asObjectArray();
        double[] quantityColVal = quantityCol.asDoubleArray();

        Assertions.assertArrayEquals(expectedMineralColVal, mineralColVal);
        Assertions.assertArrayEquals(expectedQuantityColVal, quantityColVal);
    }

    @Test
    public void testCase3() {
        Table testCaseTable = CSVGenerator.readCSV("testCase3.csv");
        Table mineralsTable = CSVGenerator.getMineralTable(testCaseTable);

        String[] expectedMineralColVal = {"Chromium", "Gold", "Titanium"};
        double[] expectedQuantityColVal = {0,0,1};

        StringColumn mineralCol = (StringColumn) mineralsTable.column(0);
        DoubleColumn quantityCol = (DoubleColumn) mineralsTable.column(1);

        String[] mineralColVal = mineralCol.asObjectArray();
        double[] quantityColVal = quantityCol.asDoubleArray();

        Assertions.assertArrayEquals(expectedMineralColVal, mineralColVal);
        Assertions.assertArrayEquals(expectedQuantityColVal, quantityColVal);
    }

    @Test
    public void testCase4() {
        Table testCaseTable = CSVGenerator.readCSV("testCase4.csv");
        Table mineralsTable = CSVGenerator.getMineralTable(testCaseTable);

        String[] expectedMineralColVal = {"Chromium", "Gold", "Titanium"};
        double[] expectedQuantityColVal = {0,0,0};

        StringColumn mineralCol = (StringColumn) mineralsTable.column(0);
        DoubleColumn quantityCol = (DoubleColumn) mineralsTable.column(1);

        String[] mineralColVal = mineralCol.asObjectArray();
        double[] quantityColVal = quantityCol.asDoubleArray();

        Assertions.assertArrayEquals(expectedMineralColVal, mineralColVal);
        Assertions.assertArrayEquals(expectedQuantityColVal, quantityColVal);
    }

    @Test
    public void testCase5() {
        Table testCaseTable = CSVGenerator.readCSV("testCase5.csv");
        Table mineralsTable = CSVGenerator.getMineralTable(testCaseTable);

        String[] expectedMineralColVal = {"Chromium", "Gold", "Titanium"};
        double[] expectedQuantityColVal = {11,5,7};

        StringColumn mineralCol = (StringColumn) mineralsTable.column(0);
        DoubleColumn quantityCol = (DoubleColumn) mineralsTable.column(1);

        String[] mineralColVal = mineralCol.asObjectArray();
        double[] quantityColVal = quantityCol.asDoubleArray();

        Assertions.assertArrayEquals(expectedMineralColVal, mineralColVal);
        Assertions.assertArrayEquals(expectedQuantityColVal, quantityColVal);
    }
}

