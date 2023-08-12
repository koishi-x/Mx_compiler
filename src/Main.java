//import Assembly.AsmFn;
//import Backend.*;
//import Frontend.ASTBuilder;
//import Frontend.SemanticChecker;
//import Frontend.SymbolCollector;
//import MIR.block;
//import MIR.mainFn;
import AST.rootNode;
import Frontend.ASTBuilder;
import Parser.MxLexer;
import Parser.MxParser;
//import Util.YxErrorListener;
//import Util.globalScope;
import Util.MxErrorListener;
import Util.error.error;
import Util.globalScope;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import Frontend.*;

//import java.io.FileInputStream;
//import java.io.InputStream;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        System.out.println("fasjhkdghlkdas");



        if (args[0].equals("-fsyntax-only")) {
            //String name = "test.mx";
            //InputStream input = new FileInputStream(name);
            InputStream input = System.in;
            try {
                rootNode ASTRoot;
                globalScope gScope = new globalScope(null);

                MxLexer lexer = new MxLexer(CharStreams.fromStream(input));
                lexer.removeErrorListeners();
                lexer.addErrorListener(new MxErrorListener());
                MxParser parser = new MxParser(new CommonTokenStream(lexer));
                parser.removeErrorListeners();
                parser.addErrorListener(new MxErrorListener());
                ParseTree parseTreeRoot = parser.program();
                ASTBuilder astBuilder = new ASTBuilder(gScope);
                ASTRoot = (rootNode) astBuilder.visit(parseTreeRoot);
                new SymbolCollector(gScope).visit(ASTRoot);
                new SemanticCheck(gScope).visit(ASTRoot);

            } catch (error er) {
                System.err.println(er.toString());
                throw new RuntimeException();
            }
        }
    }
}