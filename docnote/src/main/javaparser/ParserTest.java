package javaparser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;

/**
 * Created by xugangwen on 2018/11/26.
 */
public class ParserTest {
    private static final String FILE_PATH = "docnote/src/main/javaparser/Test.java";
    public static void main(String[] args) {
        try {
            CompilationUnit cu = JavaParser.parse(new File(FILE_PATH));
            cu.accept(new MethodVisitor(),null);
            System.out.printf("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static class MethodVisitor extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(MethodDeclaration method, Void arg) {
            /* here you can access the attributes of the method.
             this method will be called for all methods in this
             CompilationUnit, including inner class methods */
            System.out.println("method:"+method.getName());

            Optional<BlockStmt> block = method.getBody();
            NodeList<Statement> statements = block.get().getStatements();

            for (Statement tmp : statements) {
                tmp.removeComment();
                if(tmp instanceof IfStmt) {
                    IfStmt ifStmt = (IfStmt) tmp;
                    ifStmt.getCondition();
                    ifStmt.getThenStmt();
                    System.out.println(tmp.toString());
                }
            }

            super.visit(method, arg);
        }


    }
}
