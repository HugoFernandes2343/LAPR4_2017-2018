package pt.isep.nsheets.shared.lapr4.blue.s1.lang.s1150371.macros;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashMap;
import java.util.List;

import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.formula.compiler.MacrosBaseVisitor;
import pt.isep.nsheets.shared.core.formula.compiler.MacrosParser;
import pt.isep.nsheets.shared.services.CurrentWorkbookDTO;

/**
 *
 * @author josea
 */
public class MacrosBaseVisitorImp extends MacrosBaseVisitor<Double> {

    /**
     * This class provides an empty implementation of {@link MacrosVisitor},
     * which can be extended to create a visitor which only needs to handle a
     * subset of the available methods.
     *
     * @param <T> The return type of the visit operation. Use {@link Void} for
     * operations with no return type.
     */
    
    private HashMap<String, Double> variables = new HashMap<String, Double>();

//    @Override
//    public Double visitSetVariable(MacrosParser.SetVariableContext ctx) {
//        Double value = visit(ctx.plusOrMinus());
//        variables.put(ctx.ID().getText(), value);
//        return value;
//    }
    
    @Override
    public Double visitToMultOrDiv(MacrosParser.ToMultOrDivContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Double visitPlus(MacrosParser.PlusContext ctx) {
        return visit(ctx.plusOrMinus()) + visit(ctx.multOrDiv());
    }
    
    @Override
    public Double visitMinus(MacrosParser.MinusContext ctx) {
        return visit(ctx.plusOrMinus()) - visit(ctx.multOrDiv());
    }
    
    @Override
    public Double visitMultiplication(MacrosParser.MultiplicationContext ctx) {
        return visit(ctx.multOrDiv()) * visit(ctx.pow());
    }
    
    @Override
    public Double visitDivision(MacrosParser.DivisionContext ctx) {
        return visit(ctx.multOrDiv()) / visit(ctx.pow());
    }
    
    @Override
    public Double visitToPow(MacrosParser.ToPowContext ctx) {
        return visitChildren(ctx);
    }
    
    @Override
    public Double visitPower(MacrosParser.PowerContext ctx) {
        if (ctx.pow() != null) {
            return Math.pow(visit(ctx.unaryMinus()), visit(ctx.pow()));
        }
        return visit(ctx.unaryMinus());
    }
    
    @Override
    public Double visitChangeSign(MacrosParser.ChangeSignContext ctx) {
        return -1 * visit(ctx.unaryMinus());
    }
    
    @Override
    public Double visitToAtom(MacrosParser.ToAtomContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Double visitConstantPI(MacrosParser.ConstantPIContext ctx) {
        return Math.PI;
    }
    
    @Override
    public Double visitConstantE(MacrosParser.ConstantEContext ctx) {
        return Math.E;
    }
    
    @Override
    public Double visitDouble(MacrosParser.DoubleContext ctx) {
        return Double.parseDouble(ctx.DOUBLE().getText());
    }
    
    @Override
    public Double visitInt(MacrosParser.IntContext ctx) {
        return Double.parseDouble(ctx.INT().getText());
    }
    
    @Override
    public Double visitBraces(MacrosParser.BracesContext ctx) {
        return visit(ctx.plusOrMinus());
    }

    @Override
    public Double visitMac(MacrosParser.MacContext ctx) {
        List<Macro> list = CurrentWorkbookDTO.getCurrentWorkbook().macros();
        Macro temp = null;
        for(Macro m : list){
            if(m.getName().equals(ctx.MACRO_REF().toString().replace("@",""))){
                temp = m;
            }
        }

        if(temp == null){
            return -1.0;
        } else {
            return temp.runMacro();
        }
    }

    @Override
    public Double visitCell(MacrosParser.CellContext ctx) {
        try {
            return CurrentWorkbookDTO.getCurrentSpreadsheet().getCell(CurrentWorkbookDTO.getCurrentSpreadsheet().findAddress(ctx.CELL_REF().getText())).getValue().toDouble();
        } catch (IllegalValueTypeException e) {
            return 0.0;
        }
    }
}
