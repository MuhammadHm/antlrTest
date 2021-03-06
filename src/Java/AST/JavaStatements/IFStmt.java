package Java.AST.JavaStatements;

import Java.AST.Expression.Expression;
import Java.AST.Function.FunctionBody;
import Java.AST.Visitor.ASTVisitor;

public class IFStmt extends JavaStatement{

    Expression expression;
    FunctionBody body;
    FunctionBody elseStmt;

    @Override
    public void accept(ASTVisitor astVisitor){
        astVisitor.visit(this);
        if(expression!=null)
        expression.accept(astVisitor);
        if(body!=null)
        body.accept(astVisitor);
        if(elseStmt!=null)
        elseStmt.accept(astVisitor);
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public void setBody(FunctionBody body) {
        this.body = body;
    }

    public void setElseStmt(FunctionBody elseStmt) {
        this.elseStmt = elseStmt;
    }
}
