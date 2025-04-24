package ru.alxpro.jmeter.mqtester.sampler;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static ru.alxpro.jmeter.mqtester.Constants.NAME;

import java.awt.BorderLayout;
import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;

public class SamplerGui extends AbstractSamplerGui {

  private static boolean initialized;

  private final SamplerMainForm form;

  public SamplerGui() {
    form = new SamplerMainForm();
  }

  @Override
  public String getStaticLabel() {
    return NAME;
  }

  @Override
  public String getLabelResource() {
    return getStaticLabel();
  }

  @Override
  public void clearGui() {
    super.clearGui();

    if (!initialized) {
      initialized = true;

      setLayout(new BorderLayout(5, 5));
      setBorder(makeBorder());
      add(makeTitlePanel(), NORTH);
      add(form.mainPanel, CENTER);
    }
  }

  @Override
  public void configure(TestElement te) {
    super.configure(te);
  }

  @Override
  public TestElement createTestElement() {
    Sampler sampler = new Sampler();
    modifyTestElement(sampler);

    return sampler;
  }

  @Override
  public void modifyTestElement(TestElement testElement) {
  }
}
