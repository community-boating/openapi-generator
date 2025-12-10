package cbi.generator;

import io.swagger.v3.oas.models.media.Schema;

import java.util.*;

public class RefNormalizer {

    public static void normalizeRefs(Schema<?> schema) {
        normalizeRefs(schema, new IdentityHashMap<>());
    }

    private static void normalizeRefs(Schema<?> schema, Map<Schema<?>, Boolean> visited) {
        if (schema == null || visited.containsKey(schema)) {
            return;
        }
        visited.put(schema, true);

        // --- rewrite $ref if needed
        if (schema.get$ref() != null) {
            String ref = schema.get$ref();
            String simple = ref;

            int idx = ref.lastIndexOf('/');
            if (idx != -1) {
                simple = ref.substring(idx + 1);
            }

            // ends in _1 → rewrite
            if (simple.endsWith("_1")) {
                String newSimple = simple.substring(0, simple.length() - 2);
                String newRef = ref.substring(0, ref.length() - simple.length()) + newSimple;
                schema.set$ref(newRef);
            }
        }

        // --- recursively process children

        // properties
        if (schema.getProperties() != null) {
            for (Schema<?> child : schema.getProperties().values()) {
                normalizeRefs(child, visited);
            }
        }

        // items
        if (schema.getItems() != null) {
            normalizeRefs(schema.getItems(), visited);
        }

        // additionalProperties
        Object ap = schema.getAdditionalProperties();
        if (ap instanceof Schema<?>) {
            normalizeRefs((Schema<?>) ap, visited);
        }

        // allOf / anyOf / oneOf
        if (schema.getAllOf() != null) {
            schema.getAllOf().forEach(s -> normalizeRefs(s, visited));
        }
        if (schema.getAnyOf() != null) {
            schema.getAnyOf().forEach(s -> normalizeRefs(s, visited));
        }
        if (schema.getOneOf() != null) {
            schema.getOneOf().forEach(s -> normalizeRefs(s, visited));
        }

        // not
        if (schema.getNot() != null) {
            normalizeRefs(schema.getNot(), visited);
        }
    }
}
