package Java;

import Java.AST.Parse;
import Java.AST.Visitor.ASTSymbolTable;
import Java.AST.Visitor.BaseASTVisitor;
import Java.Base.BaseVisitor;
import generated.SQLBaseListener;
import generated.SQLLexer;
import generated.SQLParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {

    public static void main(String[] args) {
        try {
            String source = "samples//samples.txt";
            CharStream cs = fromFileName(source);
            SQLLexer lexer = new SQLLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            SQLParser parser = new SQLParser(token);
            ParseTree tree = parser.parse();

            Parse p = (Parse) new BaseVisitor().visit(tree);
            System.out.println("\n\nAbstract Syntax Tree: \n");

            p.accept(new BaseASTVisitor());
//             p.accept(new ASTSymbolTable());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
