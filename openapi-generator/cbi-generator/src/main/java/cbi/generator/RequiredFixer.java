package cbi.generator;

import io.swagger.v3.oas.models.media.Schema;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;
import org.openapitools.codegen.utils.ModelUtils;

import java.util.*;

public class RequiredFixer {

    /**
     * Updates a CodegenModel’s properties so isOptional / isRequired reflect
     * inherited required fields from all parent allOf schemas (including interfaces).
     *
     * @param model   CodegenModel being updated
     * @param schemas components.schemas map
     */
    public static void applyRequiredToCodegenModel(
            CodegenModel model,
            Map<String, Schema> schemas
    ) {
        if (model == null || schemas == null) {
            return;
        }

        // Resolve the backing OpenAPI schema

        Set<String> requiredFields = collectAllRequiredFields(model, schemas, new TreeSet<>());

        // Apply the required/optional logic
        for (CodegenProperty prop : model.allVars) {
            boolean required = requiredFields.contains(prop.baseName);

            prop.required = required;
            prop.isOptional = !required;

            // Nullable doesn't mean optional for Kotlin generators.
            if (required) {
                prop.isNullable = false;
            }
        }
    }


    /**
     * Recursively collects all required fields across allOf parents.
     */
    private static Set<String> collectAllRequiredFields(
            CodegenModel model,
            Map<String, Schema> schemas,
            Set<String> visited
    ) {

        Schema<?> schema = findSchema(model, schemas);

        if (schema == null || visited.contains(model.name)) {
            return Collections.emptySet();
        }

        visited.add(model.name);

        Set<String> result = new TreeSet<>();

        // Add direct required fields
        if (schema.getRequired() != null) {
            result.addAll(schema.getRequired());
        }

        if(model.interfaceModels != null) {
            for (CodegenModel parent : model.interfaceModels) {
                result.addAll(collectAllRequiredFields(parent, schemas, visited));
            }
        }

        return result;
    }


    /**
     * Finds the underlying OpenAPI Schema for a CodegenModel.
     */
    private static Schema<?> findSchema(CodegenModel model, Map<String, Schema> schemas) {
        return schemas.get(model.getName());
    }
}
