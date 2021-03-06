package Java.AST.SQLStmt;

import Java.AST.Expression.Expression;
import Java.AST.General.AnyName;
import Java.AST.JavaStatements.JavaStatement;
import Java.AST.Visitor.ASTVisitor;

import java.util.ArrayList;

public class SelectCore extends Statement {
    // : K_SELECT ( K_DISTINCT | K_ALL )? result_column ( ',' result_column )*
    //   ( K_FROM ( table_or_subquery ( ',' table_or_subquery )* | join_clause ) )?
    //   ( K_WHERE expr )?
    //   ( K_GROUP K_BY expr ( ',' expr )* ( K_HAVING expr )? )?
    // | K_VALUES '(' expr ( ',' expr )* ')' ( ',' '(' expr ( ',' expr )* ')' )*
    // ;
    ArrayList<AnyName> resultColumns;
    ArrayList<AnyName> tableNames;
    ArrayList<AnyName> joinTables;
    Expression where;
    ArrayList<Expression>  groupByExpr;

    public SelectCore(){
        resultColumns=new ArrayList<>();
        tableNames=new ArrayList<>();
        groupByExpr=new ArrayList<>();

    }


    public void setWhere(Expression where) {
        this.where = where;
    }
    public void addResultCol(AnyName anyName){
        resultColumns.add(anyName);
    }
    public void addTableName(AnyName anyName){
        tableNames.add(anyName);
    }
    public void addGroupByExpr(Expression expression){
        groupByExpr.add(expression);
    }
    @Override
    public void accept(ASTVisitor astVisitor) {
        astVisitor.visit(this);
        if (where != null) {
            System.out.println("ast where stmt");
            where.accept(astVisitor);
        }
        if (!resultColumns.isEmpty()) {
            System.out.println("ast result columns");
            for (int i = 0; i < resultColumns.size(); i++) {
                resultColumns.get(i).accept(astVisitor);
            }

        }
        if (!tableNames.isEmpty()) {
            System.out.println("ast from stmt");
            for (int i = 0; i < tableNames.size(); i++) {
                tableNames.get(i).accept(astVisitor);
            }
        }
        if (!groupByExpr.isEmpty()) {
            System.out.println("ast group by stmt");
            for (int i = 0; i < groupByExpr.size(); i++) {
                groupByExpr.get(i).accept(astVisitor);
            }
        }
    }

    public ArrayList<AnyName> getTableNames() {
        return tableNames;
    }
}
