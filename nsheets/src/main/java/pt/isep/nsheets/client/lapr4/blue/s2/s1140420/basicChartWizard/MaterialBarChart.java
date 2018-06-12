package pt.isep.nsheets.client.lapr4.blue.s2.s1140420.basicChartWizard;

//Taken from https://github.com/GwtMaterialDesign/gwt-material-demo/blob/master/src/main/java/gwt/material/design/demo/client/ui/charts/MaterialBarChart.java

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.corechart.BarChart;
import com.googlecode.gwt.charts.client.corechart.BarChartOptions;
import com.googlecode.gwt.charts.client.options.Animation;
import com.googlecode.gwt.charts.client.options.AnimationEasing;
import com.googlecode.gwt.charts.client.options.Bar;
import com.googlecode.gwt.charts.client.options.Gridlines;
import com.googlecode.gwt.charts.client.options.HAxis;
import com.googlecode.gwt.charts.client.options.Legend;
import com.googlecode.gwt.charts.client.options.LegendAlignment;
import com.googlecode.gwt.charts.client.options.LegendPosition;
import com.googlecode.gwt.charts.client.options.TextPosition;
import com.googlecode.gwt.charts.client.options.VAxis;
import gwt.material.design.client.ui.MaterialCardContent;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Spreadsheet;

public class MaterialBarChart extends Composite {

    private static MaterialBarChartUiBinder uiBinder = GWT.create(MaterialBarChartUiBinder.class);

    interface MaterialBarChartUiBinder extends UiBinder<Widget, MaterialBarChart> {
    }

    @UiField
    MaterialCardContent cardContent;

    private boolean isLoop;
    private BarChart chart;
    private int[][] values;
    Address lowerCellAddress;
    Address upperCellAddress;
    boolean linesOriented;
    Spreadsheet spreadsheet;


    public MaterialBarChart() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setSpreadsheet(Spreadsheet spreadsheet) {
        this.spreadsheet = spreadsheet;
    }

    public void setLowerCellAddress(String lowerCell) {
        lowerCellAddress = spreadsheet.findAddress(lowerCell);
    }

    public void setUpperCellAddress(String upperCell) {
        this.upperCellAddress = spreadsheet.findAddress(upperCell);
    }

    public void setLinesOriented(boolean linesOriented) {
        this.linesOriented = linesOriented;
    }

    public void setValues(){
        Cell[][] cells = spreadsheet.getCellRangeMatrix(upperCellAddress, lowerCellAddress);

        if (!linesOriented){
            cells = transpose (cells);
        }

        try {
            values = cellsToValueMatrix (cells);
        } catch (IllegalValueTypeException e) {
            e.printStackTrace();
        }
    }

    public static Cell[][] transpose (Cell[][] cells){
        Cell[][] transposed = new Cell[cells[0].length][cells.length];

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                transposed[j][i] = transposed[i][j];
            }
        }
        return transposed;
    }

    public static int[][] cellsToValueMatrix (Cell[][] cells) throws IllegalValueTypeException {
        int[][] result = new int[cells.length][cells[0].length];

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                result[i][j] = cells[i][j].getValue().toNumber().intValue();
            }
        }
        return result;
    }

    public void initialize() {
        ChartLoader chartLoader = new ChartLoader(ChartPackage.CORECHART);
        chartLoader.loadApi(new Runnable() {

            @Override
            public void run() {
                // Create and attach the chart
                chart = new BarChart();
                cardContent.add(chart);

                // Prepare the data with loop inside to populate the initial data
                setLoop();
            }
        });
    }

    private void drawChart(int[][] values) {

        // Prepare the data
        DataTable dataTable = DataTable.create();
        dataTable.addColumn(ColumnType.STRING, "");
        for (int i = 0; i < values[0].length; i++) {
            String label = "Label " + i;
            dataTable.addColumn(ColumnType.NUMBER, label);
        }
        dataTable.addRows(values.length);
        for (int i = 0; i < values.length; i++) {
            String label = "Label " + i;
            dataTable.setValue(i, 0, label);
        }
        for (int col = 0; col < values.length; col++) {
            for (int row = 0; row < values[col].length; row++) {
                dataTable.setValue(row, col + 1, values[col][row]);
            }
        }

        // Draw the chart
        chart.draw(dataTable, getOptions());
    }

    private void setLoop() {

        Timer timer = new Timer() {

            public void run() {
                if (isLoop) {
                    drawChart(values);
                    isLoop = false;
                }
                else {
                    drawChart(values);
                    isLoop = true;
                }

            }
        };
        timer.scheduleRepeating(1000);
    }

    private BarChartOptions getOptions() {
        // Grid Lines
        Gridlines lines = Gridlines.create();
        lines.setColor("fff");

        // Text Positions X and Y Axis
        HAxis hAxis = HAxis.create();
        hAxis.setTextPosition(TextPosition.NONE);

        VAxis vAxis = VAxis.create();
        vAxis.setGridlines(lines);
        hAxis.setGridlines(lines);

        // Legend
        Legend legend = Legend.create();
        legend.setPosition(LegendPosition.NONE);
        legend.setAligment(LegendAlignment.START);

        // Set options
        BarChartOptions options = BarChartOptions.create();
        options.setHAxis(HAxis.create("Cups"));
        options.setVAxis(VAxis.create("Year"));
        options.setColors("#2196f3", "#42a5f5", "#64b5f6", "#90caf9");
        options.setVAxis(vAxis);
        options.setHAxis(hAxis);
        options.setLegend(legend);

        // Set Animation
        Animation animation = Animation.create();
        animation.setDuration(500);
        animation.setEasing(AnimationEasing.OUT);
        options.setAnimation(animation);

        // Set Bar
        Bar bar = Bar.create();
        bar.setGroupWidth("50%");

        return options;
    }

}
