/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.developer_cloud.visual_recognition.v3.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.model.GenericModel;
import com.ibm.watson.developer_cloud.util.Validator;

/**
 * The classify options.
 */
public class ClassifyOptions extends GenericModel {

  /**
   * The language of the output class names. The full set of languages is supported for the built-in classifier IDs:
   * `default`, `food`, and `explicit`. The class names of custom classifiers are not translated.
   *
   * The response might not be in the specified language when the requested language is not supported or when there is
   * no translation for the class name.
   */
  public interface AcceptLanguage {
    /** en. */
    String EN = "en";
    /** ar. */
    String AR = "ar";
    /** de. */
    String DE = "de";
    /** es. */
    String ES = "es";
    /** fr. */
    String FR = "fr";
    /** it. */
    String IT = "it";
    /** ja. */
    String JA = "ja";
    /** ko. */
    String KO = "ko";
    /** pt-br. */
    String PT_BR = "pt-br";
    /** zh-cn. */
    String ZH_CN = "zh-cn";
    /** zh-tw. */
    String ZH_TW = "zh-tw";
  }

  private InputStream imagesFile;
  private String imagesFilename;
  private String acceptLanguage;
  private String url;
  private Float threshold;
  private List<String> owners;
  private List<String> classifierIds;
  private String imagesFileContentType;
  @Deprecated
  private String parameters;

  /**
   * Builder.
   */
  public static class Builder {
    private InputStream imagesFile;
    private String imagesFilename;
    private String acceptLanguage;
    private String url;
    private Float threshold;
    private List<String> owners;
    private List<String> classifierIds;
    private String imagesFileContentType;
    @Deprecated
    private String parameters;

    private Builder(ClassifyOptions classifyOptions) {
      imagesFile = classifyOptions.imagesFile;
      imagesFilename = classifyOptions.imagesFilename;
      acceptLanguage = classifyOptions.acceptLanguage;
      url = classifyOptions.url;
      threshold = classifyOptions.threshold;
      owners = classifyOptions.owners;
      classifierIds = classifyOptions.classifierIds;
      imagesFileContentType = classifyOptions.imagesFileContentType;
      parameters = classifyOptions.parameters;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ClassifyOptions.
     *
     * @return the classifyOptions
     */
    public ClassifyOptions build() {
      return new ClassifyOptions(this);
    }

    /**
     * Adds an owner to owners.
     *
     * @param owner the new owner
     * @return the ClassifyOptions builder
     */
    public Builder addOwner(String owner) {
      Validator.notNull(owner, "owner cannot be null");
      if (this.owners == null) {
        this.owners = new ArrayList<String>();
      }
      this.owners.add(owner);
      return this;
    }

    /**
     * Adds an classifierId to classifierIds.
     *
     * @param classifierId the new classifierId
     * @return the ClassifyOptions builder
     */
    public Builder addClassifierId(String classifierId) {
      Validator.notNull(classifierId, "classifierId cannot be null");
      if (this.classifierIds == null) {
        this.classifierIds = new ArrayList<String>();
      }
      this.classifierIds.add(classifierId);
      return this;
    }

    /**
     * Set the imagesFile.
     *
     * @param imagesFile the imagesFile
     * @return the ClassifyOptions builder
     */
    public Builder imagesFile(InputStream imagesFile) {
      this.imagesFile = imagesFile;
      return this;
    }

    /**
     * Set the imagesFilename.
     *
     * @param imagesFilename the imagesFilename
     * @return the ClassifyOptions builder
     */
    public Builder imagesFilename(String imagesFilename) {
      this.imagesFilename = imagesFilename;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the ClassifyOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the ClassifyOptions builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the threshold.
     *
     * @param threshold the threshold
     * @return the ClassifyOptions builder
     */
    public Builder threshold(Float threshold) {
      this.threshold = threshold;
      return this;
    }

    /**
     * Set the owners.
     * Existing owners will be replaced.
     *
     * @param owners the owners
     * @return the ClassifyOptions builder
     */
    public Builder owners(List<String> owners) {
      this.owners = owners;
      return this;
    }

    /**
     * Set the classifierIds.
     * Existing classifierIds will be replaced.
     *
     * @param classifierIds the classifierIds
     * @return the ClassifyOptions builder
     */
    public Builder classifierIds(List<String> classifierIds) {
      this.classifierIds = classifierIds;
      return this;
    }

    /**
     * Set the imagesFileContentType.
     *
     * @param imagesFileContentType the imagesFileContentType
     * @return the ClassifyOptions builder
     */
    public Builder imagesFileContentType(String imagesFileContentType) {
      this.imagesFileContentType = imagesFileContentType;
      return this;
    }

    /**
     * Set the imagesFile.
     *
     * @param imagesFile the imagesFile
     * @return the ClassifyOptions builder
     *
     * @throws FileNotFoundException if the file could not be found
     */
    public Builder imagesFile(File imagesFile) throws FileNotFoundException {
      this.imagesFile = new FileInputStream(imagesFile);
      this.imagesFilename = imagesFile.getName();
      return this;
    }

    /**
     * Set the parameters.
     *
     * @param parameters the parameters
     * @return the ClassifyOptions builder
     * @deprecated replaced by the top-level parameters url, threshold, owners, and classifierIds
     */
    public Builder parameters(String parameters) {
      this.parameters = parameters;
      return this;
    }
  }

  private ClassifyOptions(Builder builder) {
    imagesFile = builder.imagesFile;
    imagesFilename = builder.imagesFilename;
    acceptLanguage = builder.acceptLanguage;
    url = builder.url;
    threshold = builder.threshold;
    owners = builder.owners;
    classifierIds = builder.classifierIds;
    imagesFileContentType = builder.imagesFileContentType;
    parameters = builder.parameters;
  }

  /**
   * New builder.
   *
   * @return a ClassifyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the imagesFile.
   *
   * An image file (.jpg, .png) or .zip file with images. Maximum image size is 10 MB. Include no more than 20 images
   * and limit the .zip file to 100 MB. Encode the image and .zip file names in UTF-8 if they contain non-ASCII
   * characters. The service assumes UTF-8 encoding if it encounters non-ASCII characters.
   *
   * You can also include an image with the **url** parameter.
   *
   * @return the imagesFile
   */
  public InputStream imagesFile() {
    return imagesFile;
  }

  /**
   * Gets the imagesFilename.
   *
   * The filename for imagesFile.
   *
   * @return the imagesFilename
   */
  public String imagesFilename() {
    return imagesFilename;
  }

  /**
   * Gets the acceptLanguage.
   *
   * The language of the output class names. The full set of languages is supported for the built-in classifier IDs:
   * `default`, `food`, and `explicit`. The class names of custom classifiers are not translated.
   *
   * The response might not be in the specified language when the requested language is not supported or when there is
   * no translation for the class name.
   *
   * @return the acceptLanguage
   */
  public String acceptLanguage() {
    return acceptLanguage;
  }

  /**
   * Gets the url.
   *
   * The URL of an image to analyze. Must be in .jpg, or .png format. The minimum recommended pixel density is 32X32
   * pixels per inch, and the maximum image size is 10 MB.
   *
   * You can also include images with the **images_file** parameter.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the threshold.
   *
   * The minimum score a class must have to be displayed in the response. Set the threshold to `0.0` to ignore the
   * classification score and return all values.
   *
   * @return the threshold
   */
  public Float threshold() {
    return threshold;
  }

  /**
   * Gets the owners.
   *
   * The categories of classifiers to apply. Use `IBM` to classify against the `default` general classifier, and use
   * `me` to classify against your custom classifiers. To analyze the image against both classifier categories, set the
   * value to both `IBM` and `me`.
   *
   * The built-in `default` classifier is used if both **classifier_ids** and **owners** parameters are empty.
   *
   * The **classifier_ids** parameter overrides **owners**, so make sure that **classifier_ids** is empty.
   *
   * @return the owners
   */
  public List<String> owners() {
    return owners;
  }

  /**
   * Gets the classifierIds.
   *
   * Which classifiers to apply. Overrides the **owners** parameter. You can specify both custom and built-in classifier
   * IDs. The built-in `default` classifier is used if both **classifier_ids** and **owners** parameters are empty.
   *
   * The following built-in classifier IDs require no training:
   * - `default`: Returns classes from thousands of general tags.
   * - `food`: (Beta) Enhances specificity and accuracy for images of food items.
   * - `explicit`: (Beta) Evaluates whether the image might be pornographic.
   *
   * @return the classifierIds
   */
  public List<String> classifierIds() {
    return classifierIds;
  }

  /**
   * Gets the imagesFileContentType.
   *
   * The content type of imagesFile. Values for this parameter can be obtained from the HttpMediaType class.
   *
   * @return the imagesFileContentType
   */
  public String imagesFileContentType() {
    return imagesFileContentType;
  }

  /**
   * Gets the parameters.
   *
   * @return the parameters
   * @deprecated replaced by the top-level parameters url, threshold, owners, and classifierIds
   */
  public String parameters() {
    return parameters;
  }
}
