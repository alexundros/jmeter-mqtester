package ru.alxpro.jmeter.mqtester.sampler;

import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;

public class SamplerGui extends AbstractSamplerGui {

  @Override
  public String getLabelResource() {
    return "";
  }

  @Override
  public TestElement createTestElement() {
    return null;
  }

  @Override
  public void modifyTestElement(TestElement testElement) {
  }
}
