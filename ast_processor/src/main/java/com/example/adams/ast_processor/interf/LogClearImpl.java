package com.example.adams.ast_processor.interf;

import com.example.adams.ast_processor.LogClearTranslator;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeTranslator;
import java.util.Set;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

/**
 * create by adams on 2019/6/12
 */
public class LogClearImpl implements ASTInterf {

    private Messager messager;

    public LogClearImpl(Messager messager) {
        this.messager = messager;
    }

    @Override
    public String getSupportedAnnotationTypes() {
        return "*";
    }

    @Override
    public Set<? extends Element> getRootElements(RoundEnvironment roundEnv) {
        Set<? extends Element> elements = roundEnv.getRootElements();
        return elements;
    }

    @Override
    public JCTree.Visitor getVisitor() {
        TreeTranslator treeTranslator = new LogClearTranslator(messager);
        return treeTranslator;
    }


}
