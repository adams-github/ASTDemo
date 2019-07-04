package com.example.adams.ast_processor;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.List;
import javax.annotation.processing.Messager;
import javax.tools.Diagnostic;

/**
 * create by zl on 2019/6/11
 */
public class TestVisitMethodTranslator extends TreeTranslator {

    private Messager messager;

    public TestVisitMethodTranslator(Messager messager) {
        this.messager = messager;
    }

    @Override
    public void visitClassDef(JCTree.JCClassDecl jcClassDecl) {
        super.visitClassDef(jcClassDecl);


//        if (jcClassDecl.name.toString().equals("MainActivity")){
//            messager.printMessage(Diagnostic.Kind.NOTE, jcClassDecl.name + " : " + jcClassDecl.mods);
//            messager.printMessage(Diagnostic.Kind.NOTE, jcClassDecl.name + " : " + jcClassDecl.sym.toString());
//            List<JCTree.JCTypeParameter> jcTypeParameterList = jcClassDecl.typarams;
//            messager.printMessage(Diagnostic.Kind.NOTE, jcClassDecl.name + " : " + jcTypeParameterList.size());
//            messager.printMessage(Diagnostic.Kind.NOTE, jcClassDecl.name + " : " + jcClassDecl.extending.toString());
//            messager.printMessage(Diagnostic.Kind.NOTE, jcClassDecl.name + " : " + jcClassDecl.implementing.toString());
//            List<JCTree> jcTreeList = jcClassDecl.defs;
//            messager.printMessage(Diagnostic.Kind.NOTE, jcClassDecl.name + " : " + jcTreeList.size());
//            for (JCTree jcTree : jcTreeList) {
//                if (jcTree instanceof JCTree.JCMethodDecl){
//                    messager.printMessage(Diagnostic.Kind.NOTE, jcClassDecl.name + " : " + ((JCTree.JCMethodDecl) jcTree).name);
//                    messager.printMessage(Diagnostic.Kind.NOTE, jcClassDecl.name + " : " + ((JCTree.JCMethodDecl) jcTree).defaultValue);
//                    JCTree.JCBlock jcBlock = ((JCTree.JCMethodDecl) jcTree).getBody();
//                    List<JCTree.JCStatement> jcStatementList = jcBlock.getStatements();
//                    for (JCTree.JCStatement jcStatement: jcStatementList) {
//                        messager.printMessage(Diagnostic.Kind.NOTE, jcClassDecl.name + "_" + ((JCTree.JCMethodDecl) jcTree).name + ":" + jcStatement.toString());
//                    }
//                }else if (jcTree instanceof JCTree.JCVariableDecl){
//                    messager.printMessage(Diagnostic.Kind.NOTE, jcClassDecl.name + " : " + ((JCTree.JCVariableDecl) jcTree).vartype);
//                    messager.printMessage(Diagnostic.Kind.NOTE, jcClassDecl.name + " : " + ((JCTree.JCVariableDecl) jcTree).name);
//                }
//            }
//        }
    }

    @Override
    public void visitVarDef(JCTree.JCVariableDecl jcVariableDecl) {
        super.visitVarDef(jcVariableDecl);
//        messager.printMessage(Diagnostic.Kind.NOTE, jcVariableDecl.name + " " + jcVariableDecl.vartype);
//        messager.printMessage(Diagnostic.Kind.NOTE, jcVariableDecl.name + " " + jcVariableDecl.init);
//        messager.printMessage(Diagnostic.Kind.NOTE, jcVariableDecl.name + " " + jcVariableDecl.mods);
//        messager.printMessage(Diagnostic.Kind.NOTE, jcVariableDecl.name + " " + jcVariableDecl.sym);
//        messager.printMessage(Diagnostic.Kind.NOTE, jcVariableDecl.name + " " + jcVariableDecl.nameexpr);
//        messager.printMessage(Diagnostic.Kind.NOTE, "-------------------------");
    }

    @Override
    public void visitTypeIdent(JCTree.JCPrimitiveTypeTree jcPrimitiveTypeTree) {
        super.visitTypeIdent(jcPrimitiveTypeTree);

//        messager.printMessage(Diagnostic.Kind.NOTE, jcPrimitiveTypeTree.typetag + "");
    }

    @Override
    public void visitMethodDef(JCTree.JCMethodDecl jcMethodDecl) {
        super.visitMethodDef(jcMethodDecl);

//        messager.printMessage(Diagnostic.Kind.NOTE, jcMethodDecl.name + " " + jcMethodDecl.mods);
//        messager.printMessage(Diagnostic.Kind.NOTE, jcMethodDecl.name + " " + jcMethodDecl.defaultValue);
//        messager.printMessage(Diagnostic.Kind.NOTE, jcMethodDecl.name + " " + jcMethodDecl.sym);
//        messager.printMessage(Diagnostic.Kind.NOTE, jcMethodDecl.name + " " + jcMethodDecl.params);

//        JCTree.JCBlock jcBlock = jcMethodDecl.getBody();
//        JCTree.JCStatement jcStatement = jcBlock.getStatements().get(0);
//        messager.printMessage(Diagnostic.Kind.NOTE, jcBlock.getStatements() + " " );
    }

    @Override
    public void visitSelect(JCTree.JCFieldAccess jcFieldAccess) {
        super.visitSelect(jcFieldAccess);
//        messager.printMessage(Diagnostic.Kind.NOTE, jcFieldAccess.name + " " + jcFieldAccess.selected);
    }

    @Override
    public void visitApply(JCTree.JCMethodInvocation jcMethodInvocation) {
        super.visitApply(jcMethodInvocation);

        messager.printMessage(Diagnostic.Kind.NOTE, jcMethodInvocation.meth + " " + jcMethodInvocation.typeargs);
        messager.printMessage(Diagnostic.Kind.NOTE, jcMethodInvocation.args + " " + jcMethodInvocation.varargsElement);
        messager.printMessage(Diagnostic.Kind.NOTE, "-------------------");
    }

    @Override
    public void visitLiteral(JCTree.JCLiteral jcLiteral) {
        super.visitLiteral(jcLiteral);

//        messager.printMessage(Diagnostic.Kind.NOTE, jcLiteral.typetag + " " + jcLiteral.value);
    }

    @Override
    public void visitNewClass(JCTree.JCNewClass jcNewClass) {
        super.visitNewClass(jcNewClass);

//        messager.printMessage(Diagnostic.Kind.NOTE, jcNewClass.encl + " " + jcNewClass.clazz);
//        messager.printMessage(Diagnostic.Kind.NOTE, jcNewClass.typeargs + " " + jcNewClass.args);
//        messager.printMessage(Diagnostic.Kind.NOTE, jcNewClass.def + " " + jcNewClass.constructor);
//        messager.printMessage(Diagnostic.Kind.NOTE, jcNewClass.varargsElement + " " + jcNewClass.constructorType);
    }

    @Override
    public void visitAnnotation(JCTree.JCAnnotation jcAnnotation) {
        super.visitAnnotation(jcAnnotation);

//        messager.printMessage(Diagnostic.Kind.NOTE, "----------------------");
//        messager.printMessage(Diagnostic.Kind.NOTE, jcAnnotation.args.size() + " ");


    }

    @Override
    public void visitBinary(JCTree.JCBinary jcBinary) {
        super.visitBinary(jcBinary);

//        messager.printMessage(Diagnostic.Kind.NOTE, jcBinary.getTag() + " " + jcBinary.operator);
//        messager.printMessage(Diagnostic.Kind.NOTE, jcBinary.lhs + " " + jcBinary.rhs);
    }

    @Override
    public void visitReturn(JCTree.JCReturn jcReturn) {
        super.visitReturn(jcReturn);


//        messager.printMessage(Diagnostic.Kind.NOTE, jcReturn.expr + " ");
    }

    @Override
    public void visitIf(JCTree.JCIf jcIf) {
        super.visitIf(jcIf);

//        messager.printMessage(Diagnostic.Kind.NOTE, jcIf.cond + " ");
//        messager.printMessage(Diagnostic.Kind.NOTE, jcIf.thenpart + " ");
//        messager.printMessage(Diagnostic.Kind.NOTE, jcIf.elsepart + " ");

    }

    @Override
    public void visitTry(JCTree.JCTry jcTry) {
        super.visitTry(jcTry);

//        messager.printMessage(Diagnostic.Kind.NOTE, jcTry.body + " ");
//        messager.printMessage(Diagnostic.Kind.NOTE, jcTry.catchers + " ");
//        messager.printMessage(Diagnostic.Kind.NOTE, jcTry.finalizer + " ");
//        messager.printMessage(Diagnostic.Kind.NOTE, jcTry.resources + " ");
//        messager.printMessage(Diagnostic.Kind.NOTE, jcTry.finallyCanCompleteNormally + " ");

    }


}
