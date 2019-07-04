package com.example.adams.ast_processor.interf;

import com.example.adams.annotations.Data;
import com.example.adams.ast_processor.DataOperationTranslator;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.Names;
import java.util.Set;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

/**
 * create by zl on 2019/6/12
 */
public class DataOpImpl implements ASTInterf {

    private Messager messager;
    private TreeMaker treeMaker;
    private Names names;

    public DataOpImpl(Messager messager, TreeMaker treeMaker, Names names) {
        this.messager = messager;
        this.treeMaker = treeMaker;
        this.names = names;
    }

    @Override
    public String getSupportedAnnotationTypes() {
        return "com.example.adams.annotations.Data";
    }

    @Override
    public Set<? extends Element> getRootElements(RoundEnvironment roundEnv) {
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Data.class);
        return elements;
    }

    @Override
    public JCTree.Visitor getVisitor() {
        TreeTranslator treeTranslator = new DataOperationTranslator(messager, treeMaker, names);
        return treeTranslator;
    }

}
