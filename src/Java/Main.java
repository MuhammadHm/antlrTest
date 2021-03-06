package Java;

import CodeGeneration.MainGenerator;
//import GeneratedCode.sample.AggregationFunctions;
//import GeneratedCode.sample.AggregationFunctions;
import Java.AST.Parse;
import Java.AST.Visitor.BaseASTVisitor;
import Java.Base.BaseVisitor;
import Java.SymbolTable.SymbolTable;
import Utils.TypeManager;
import generated.SQLLexer;
import generated.SQLParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.ArrayList;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {

    public static SymbolTable symbolTable;
    public static String packageName = "sample6";

    public static void main(String[] args) {
        symbolTable = new SymbolTable();
        try {
            String source = "samples//samples.txt";
            CharStream cs = fromFileName(source);
            SQLLexer lexer = new SQLLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            SQLParser parser = new SQLParser(token);
            ParseTree tree = parser.parse();
            Parse p = (Parse) new BaseVisitor().visit(tree);

            System.out.println("\nAbstract Syntax Tree Start\n");
            p.accept(new BaseASTVisitor());
            System.out.println("\nAbstract Syntax Tree End\n");

            TypeManager.convertDeclaredTypes2Classes();
            new MainGenerator().generate();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
