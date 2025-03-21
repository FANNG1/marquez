/*
 * Copyright 2018-2023 contributors to the Marquez project
 * SPDX-License-Identifier: Apache-2.0
 */
package marquez.common.gravitino;

import java.util.Map;
import marquez.common.models.DatasetType;
import marquez.service.models.LineageEvent;


public class GravitinoUtils {

  private static final String DATASET_TYPE_FACET_NAME = "datasetType";
  private static final String DATASET_TYPE_KEY_NAME = "datasetType";

  public static DatasetType getDatasetType(LineageEvent.Dataset dataset) throws Exception {
    Map<String, Object> facets = dataset.getFacets().getAdditionalFacets();
    if (facets == null || !facets.containsKey(DATASET_TYPE_FACET_NAME)) {
      return DatasetType.DB_TABLE;
    }

    Object object = facets.get(DATASET_TYPE_FACET_NAME);
    if (!(object instanceof Map)) {
      return DatasetType.DB_TABLE;
    }

    Map<String, String> datatypeFacets = (Map<String, String>) object;
    String type = datatypeFacets.getOrDefault(DATASET_TYPE_KEY_NAME, DatasetType.DB_TABLE.toString());
    return DatasetType.valueOf(type.toUpperCase());
  }
}
