/**
 * Copyright (C) 2014-2015 The Skfiy Open Association.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.skfiy.maven.plugin.fastconfig.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * &lt;config-file&gt;节点对象.
 *
 * @author Kevin Zou <kevinz@skfiy.org>
 */
public class ConfigFile {

  private final File file;
  private final Mode mode;
  private final List<Replacement> replacements = new ArrayList<>();

  public ConfigFile(File file, Mode mode) {
    this.file = file;
    this.mode = mode;
  }

  public File getFile() {
    return file;
  }

  public Mode getMode() {
    return mode;
  }

  public List<Replacement> getReplacements() {
    return Collections.unmodifiableList(replacements);
  }

  public void setReplacements(List<Replacement> replacements) {
    this.replacements.addAll(replacements);
  }

  public void addReplacement(Replacement replacement) {
    this.replacements.add(replacement);
  }

  @Override
  public String toString() {
    ToStringBuilder tsb = new ToStringBuilder(this);
    return tsb.toString();
  }

  public enum Mode {

    /**
     * Property.
     */
    property,
    /**
     * Regex Expression.
     */
    regex,
    /**
     * XPath.
     */
    xpath,
    /**
     * JSON Path.
     */
    jsonpath;

  }

}
