/*
 * Copyright 2018-2023 contributors to the Marquez project
 * SPDX-License-Identifier: Apache-2.0
 */

package marquez.common.models;

public enum DatasetType {
  DB_TABLE,
  STREAM,
  FILESET,
  MODEL_VERSION;

  // Marquez only support DBTable and Stream for the dataset, we place FILESET and MODEL_VERSION to
  // DBTable too.
  public boolean isNotStream() {
    return !this.equals(STREAM);
  }
}
