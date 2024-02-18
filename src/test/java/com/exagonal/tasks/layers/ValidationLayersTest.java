package com.exagonal.tasks.layers;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

class ValidationLayersTest {

    @Test
    void shouldValidateLayersBottomUp() {
        layeredArchitecture()
                .consideringAllDependencies()
                .layer("application").definedBy("com.exagonal.tasks.application")
                .layer("domain").definedBy("com.exagonal.tasks.domain")
                .layer("infrastructure").definedBy("com.exagonal.tasks.infrastructure")

                .whereLayer("infrastructure").mayNotAccessAnyLayer()
                .whereLayer("domain").mayOnlyAccessLayers("application")
                .whereLayer("application").mayOnlyAccessLayers("infrastructure");
    }

    @Test
    void shouldValidateLayersTopDown() {
        JavaClasses importedClasses = new ClassFileImporter()
                .importPackages("com.exagonal.tasks.infrastructure");
        ArchRule archRule = noClasses()
                .should()
                .accessClassesThat()
                .resideInAPackage("com.exagonal.tasks.domain")
                .andShould()
                .resideInAPackage("com.exagonal.tasks.application");

        archRule.check(importedClasses);
    }
}
