package Java.SymbolTable;

public class Symbol {

    private String name;
    private Type type;
    private Scope scope;
    private boolean isParam;
    private boolean isDeclaration;
    int lineNum;

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Scope getScope() {
        return scope;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public boolean getIsParam() {
        return isParam;
    }

    public void setIsParam(boolean param) {
        isParam = param;
    }

    public void setDeclaration(boolean declaration) {
        isDeclaration = declaration;
    }

    public boolean isDeclaration() {
        return isDeclaration;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public int getLineNum() {
        return lineNum;
    }

}
