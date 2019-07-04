package com.example.adams.ast_processor;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.List;
import javax.annotation.processing.Messager;
import javax.tools.Diagnostic;

/**
 * create by adams on 2019/6/11
 *
 * 清除日志Log
 *
 */
public class LogClearTranslator extends TreeTranslator {

    public final static String LOG_TAG = "Log.";

    private Messager messager;

    public LogClearTranslator(Messager messager) {
        this.messager = messager;
    }

    /**
     *  访问代码块
     * */
    @Override
    public void visitBlock(JCTree.JCBlock jcBlock) {
        super.visitBlock(jcBlock);
        List<JCTree.JCStatement> jcStatementList = jcBlock.getStatements();//获取所有语句
        if (jcStatementList == null || jcStatementList.isEmpty()){
            return;
        }
        List<JCTree.JCStatement> newList = List.nil();//创建一个新的list,用于装载不包含log的代码语句
        for (JCTree.JCStatement jcStatement : jcStatementList) {
            if (!jcStatement.toString().contains(LOG_TAG)){
                newList = newList.append(jcStatement);
            }else{
                messager.printMessage(Diagnostic.Kind.NOTE, "clearLog: " + jcStatement.toString());
            }
        }
        jcBlock.stats = newList;//修改代码块的语句list
    }

}
