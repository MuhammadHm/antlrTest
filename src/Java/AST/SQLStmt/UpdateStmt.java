package Java.AST.SQLStmt;

import Java.AST.Expression.Expression;
import Java.AST.General.AnyName;
import Java.AST.Visitor.ASTVisitor;

import java.util.ArrayList;

public class UpdateStmt extends Statement {
//:  K_UPDATE  qualified_table_name
//   K_SET column_name '=' expr ( ',' column_name '=' expr )* ( K_WHERE expr )?

    QualifiedTableName qualifiedTableName;
    ArrayList<AnyName> columnNames;
    ArrayList<Expression> values;
    Expression whereExpr;

    public UpdateStmt(){
        columnNames=new ArrayList<>();
        values=new ArrayList<>();
    }
    @Override
    public void accept(ASTVisitor astVisitor){
        astVisitor.visit(this);
        qualifiedTableName.accept(astVisitor);
        if(columnNames!=null)
        for (int i = 0; i < columnNames.size(); i++) {
            columnNames.get(i).accept(astVisitor);
        }
        if(values!=null)
            for (int i = 0; i < values.size(); i++) {
                values.get(i).accept(astVisitor);
            }
        if(whereExpr!=null)
            whereExpr.accept(astVisitor);
    }

    public void setQualifiedTableName(QualifiedTableName qualifiedTableName) {
        this.qualifiedTableName = qualifiedTableName;
    }

    public void setWhereExpr(Expression whereExpr) {
        this.whereExpr = whereExpr;
    }
    public void addColName(AnyName col){
        columnNames.add(col);
    }
    public void addValue(Expression val){
        values.add(val);
    }
}
