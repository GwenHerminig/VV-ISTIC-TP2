package org.example;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Main {
    public static PrintWriter varWithNoGetter(File file) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter resultFile = new PrintWriter("src/main/java/org/example/result.txt");
        try {
            CompilationUnit cu = StaticJavaParser.parse(file);
            for(ClassOrInterfaceDeclaration classe : cu.findAll(ClassOrInterfaceDeclaration.class)){
                for(VariableDeclarator variable : cu.findAll(VariableDeclarator.class)){
                    String fieldName = String.valueOf(variable.getName());
                    String getterName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
                    if (!hasGetter(classe, getterName)) {
                        resultFile.println("La classe " + classe.getNameAsString() + " n'a pas de getter pour la variable " + fieldName);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        resultFile.close();
        return resultFile;
    }
    private static boolean hasGetter(ClassOrInterfaceDeclaration classe, String methodName) {
        for (var method : classe.getMethods()) {
            if (method.getNameAsString().equals(methodName)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {

        File file = new File("src/main/java/org/example/Person.java");
        varWithNoGetter(file);
    }
}
