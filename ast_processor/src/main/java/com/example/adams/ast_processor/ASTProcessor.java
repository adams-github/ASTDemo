package com.example.adams.ast_processor;

import com.example.adams.ast_processor.interf.ASTInterf;
import com.example.adams.ast_processor.interf.DataOpImpl;
import com.example.adams.ast_processor.interf.LogClearImpl;
import com.google.auto.service.AutoService;
import com.sun.source.util.Trees;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Names;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;

/**
 * create by adams on 2019/6/12
 */
@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ASTProcessor extends AbstractProcessor {

    private Messager mMessager;//用于打印数据
    private Trees trees;//提供了待处理的抽象语法树
    private TreeMaker treeMaker;//TreeMaker 封装了创建AST节点的一些方法
    private Names names;//提供了创建标识符的方法
    private ASTInterf astInterf;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);

        mMessager = processingEnvironment.getMessager();
        trees = Trees.instance(processingEnvironment);
        Context context = ((JavacProcessingEnvironment) processingEnvironment).getContext();
        treeMaker = TreeMaker.instance(context);
        names = Names.instance(context);

//        astInterf = new LogClearImpl(mMessager);
        astInterf = new DataOpImpl(mMessager, treeMaker, names);
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> stringSet = new LinkedHashSet<>();
        stringSet.add(astInterf.getSupportedAnnotationTypes());
        return stringSet;
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if (!roundEnvironment.processingOver()) {
            for (Element element : astInterf.getRootElements(roundEnvironment)) {
                if (element.getKind() == ElementKind.CLASS) {
                    JCTree tree = (JCTree) trees.getTree(element);
                    tree.accept(astInterf.getVisitor());
                }
            }
        }
        return false;
    }



}
