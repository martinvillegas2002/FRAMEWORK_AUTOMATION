package com.framework.runners;


import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;


@Suite
@IncludeEngines("cucumber") // Usa el motor de CUCUMBER no el de JAVA ya que no es una clase normal
@SelectClasspathResource("features") // De donde sacamos los test y los agrupamod
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.framework.steps") // Donde esta el glue, es decir, donde se une los step con el gherkin
public class TestRunner {
}
