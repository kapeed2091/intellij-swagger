package org.zalando.intellij.swagger.completion.level.field;

import com.google.common.collect.ImmutableList;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.zalando.intellij.swagger.completion.level.field.validator.UnknownKeyValidator;
import org.zalando.intellij.swagger.completion.traversal.Traversal;

public class FieldsValidator {

    private final Traversal traversal;

    private final UnknownKeyValidator unknownKeyValidator = new UnknownKeyValidator();

    public FieldsValidator(final Traversal traversal) {
        this.traversal = traversal;
    }

    public void validate(@NotNull final PsiElement psiElement, @NotNull final AnnotationHolder annotationHolder) {
        traversal.getKeyName(psiElement).ifPresent(keyName -> {
            if (traversal.isRoot(psiElement)) {
                unknownKeyValidator.validate(keyName, Fields.root(), psiElement, annotationHolder);
            } else if (traversal.isContact(psiElement)) {
                unknownKeyValidator.validate(keyName, Fields.contact(), psiElement, annotationHolder);
            } else if (traversal.isSchema(psiElement)) {
                unknownKeyValidator.validate(keyName, Fields.schema(), psiElement, annotationHolder);
            } else if (traversal.isExternalDocs(psiElement)) {
                unknownKeyValidator.validate(keyName, Fields.externalDocs(), psiElement, annotationHolder);
            } else if (traversal.isHeader(psiElement)) {
                unknownKeyValidator.validate(keyName, Fields.headers(), psiElement, annotationHolder);
            } else if (traversal.isInfo(psiElement)) {
                unknownKeyValidator.validate(keyName, Fields.info(), psiElement, annotationHolder);
            } else if (traversal.isItems(psiElement)) {
                unknownKeyValidator.validate(keyName, Fields.items(), psiElement, annotationHolder);
            } else if (traversal.isLicense(psiElement)) {
                unknownKeyValidator.validate(keyName, Fields.license(), psiElement, annotationHolder);
            } else if (traversal.isOperation(psiElement)) {
                unknownKeyValidator.validate(keyName, Fields.operation(), psiElement, annotationHolder);
            } else if (traversal.isParameters(psiElement)) {
                unknownKeyValidator.validate(keyName, Fields.parametersWithRef(), psiElement, annotationHolder);
            } else if (traversal.isPath(psiElement)) {
                unknownKeyValidator.validate(keyName, Fields.path(), psiElement, annotationHolder);
            } else if (traversal.isResponse(psiElement)) {
                unknownKeyValidator.validate(keyName, Fields.response(), psiElement, annotationHolder);
            } else if (traversal.isResponses(psiElement)) {
                unknownKeyValidator.validate(keyName, Fields.responses(), psiElement, annotationHolder);
            } else if (traversal.isSecurityDefinition(psiElement)) {
                unknownKeyValidator.validate(keyName, Fields.securityDefinitions(), psiElement, annotationHolder);
            } else if (traversal.isTag(psiElement)) {
                unknownKeyValidator.validate(keyName, Fields.tags(), psiElement, annotationHolder);
            } else if (traversal.isXml(psiElement)) {
                unknownKeyValidator.validate(keyName, Fields.xml(), psiElement, annotationHolder);
            }
        });
    }
}