package com.example.adams.ast_processor.interf;

import com.sun.tools.javac.tree.JCTree;
import java.util.Set;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

/**
 * create by zl on 2019/7/4
 */
public interface ASTInterf {



    String getSupportedAnnotationTypes();

    Set<? extends Element> getRootElements(RoundEnvironment roundEnv);

    JCTree.Visitor getVisitor();

}
