package com.ebr163.attributesdispatcher.internal;

import com.ebr163.attributesdispatcher.Attribute;
import com.ebr163.attributesdispatcher.CustomView;
import com.ebr163.attributesdispatcher.attr.BooleanAttr;
import com.ebr163.attributesdispatcher.attr.ColorAttr;
import com.ebr163.attributesdispatcher.attr.DimenAttr;
import com.ebr163.attributesdispatcher.attr.FloatAttr;
import com.ebr163.attributesdispatcher.attr.IntAttr;
import com.ebr163.attributesdispatcher.attr.ReferenceAttr;
import com.ebr163.attributesdispatcher.attr.StringAttr;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeVariableName;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;

/**
 * Created by mac1 on 23.11.16.
 */

class CustomViewElement {

    private static final String GEN_CLASS_SUFFIX = "Attribute";

    final TypeName typeName;
    final List<TypeVariableName> typeVariables;
    final String packageName;
    final String appPackegae;
    final String inputClassName;
    final String generatedClassName;
    final List<ExecutableElement> attrElements;
    final TypeElement typeElement;
    final List<Element> booleanElements;
    final List<Element> colorElements;
    final List<Element> dimenElements;
    final List<Element> floatElements;
    final List<Element> integerElements;
    final List<Element> referenceElements;
    final List<Element> stringElements;

    CustomViewElement(TypeElement typeElement) {
        this.typeElement = typeElement;
        typeName = TypeName.get(typeElement.asType());
        typeVariables = getTypeVariables(typeElement);
        packageName = getPackageName(typeElement);
        appPackegae = typeElement.getAnnotation(CustomView.class).value();
        inputClassName = typeElement.getSimpleName().toString();
        generatedClassName = inputClassName + GEN_CLASS_SUFFIX;
        attrElements = getChildElementsAnnotatedWith(typeElement, Attribute.class);
        booleanElements = getChildFieldsAnnotatedWith(typeElement, BooleanAttr.class);
        colorElements = getChildFieldsAnnotatedWith(typeElement, ColorAttr.class);
        dimenElements = getChildFieldsAnnotatedWith(typeElement, DimenAttr.class);
        floatElements = getChildFieldsAnnotatedWith(typeElement, FloatAttr.class);
        integerElements = getChildFieldsAnnotatedWith(typeElement, IntAttr.class);
        referenceElements = getChildFieldsAnnotatedWith(typeElement, ReferenceAttr.class);
        stringElements = getChildFieldsAnnotatedWith(typeElement, StringAttr.class);
    }

    private List<TypeVariableName> getTypeVariables(TypeElement typeElement) {
        List<TypeVariableName> names = new ArrayList<>();
        for (TypeParameterElement e : typeElement.getTypeParameters()) {
            names.add(TypeVariableName.get(e));
        }
        return names;
    }

    private String getPackageName(TypeElement typeElement) {
        String packageName = typeElement.getQualifiedName().toString();
        return packageName.substring(0, packageName.lastIndexOf("."));
    }

    private List<ExecutableElement> getChildElementsAnnotatedWith(TypeElement typeElement, Class clazz) {
        List<ExecutableElement> childElements = new ArrayList<>();
        for (Element e : typeElement.getEnclosedElements()) {
            if (e.getAnnotation(clazz) != null) {
                childElements.add((ExecutableElement) e);
            }
        }
        return childElements;
    }

    private List<Element> getChildFieldsAnnotatedWith(TypeElement typeElement, Class clazz) {
        List<Element> childElements = new ArrayList<>();
        for (Element e : typeElement.getEnclosedElements()) {
            if (e.getAnnotation(clazz) != null) {
                childElements.add(e);
            }
        }
        return childElements;
    }
}
