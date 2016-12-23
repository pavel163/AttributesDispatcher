package com.ebr163.attributesdispatcher.internal;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.tools.Diagnostic;

/**
 * Created by Ergashev on 23.12.16.
 */

class ErrorManager {

    private final Messager messager;

    ErrorManager(ProcessingEnvironment processingEnv) {
        this.messager = processingEnv.getMessager();
    }

    void abortWithError(String msg, Element e) {
        messager.printMessage(Diagnostic.Kind.ERROR, msg, e);
        throw new RuntimeException();
    }
}
