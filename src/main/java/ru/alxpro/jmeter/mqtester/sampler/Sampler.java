package ru.alxpro.jmeter.mqtester.sampler;

import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.Interruptible;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testelement.TestStateListener;
import org.apache.jmeter.threads.AbstractThreadGroup;
import org.apache.jmeter.threads.JMeterContext;
import org.apache.jmeter.threads.JMeterContextService;
import org.apache.jmeter.threads.JMeterVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.alxpro.jmeter.mqtester.Constants;
import ru.alxpro.jmeter.mqtester.Helper;

public class Sampler extends AbstractSampler implements TestStateListener, Interruptible {

  private final Logger log = LoggerFactory.getLogger(getClass());

  private boolean initialized;

  private String whoAmI() {
    return String.format("%s: %s (%s)", Helper.whoIs(this), Constants.NAME, getName());
  }

  private void initialize(AbstractThreadGroup threadGroup) {
    log.info("{}: Initialize", whoAmI());
  }

  private void doAction(SampleResult result) {
  }

  public Sampler() {
    log.debug("{}: {}()", Helper.whoIs(this), NAME);
  }

  @Override
  public SampleResult sample(Entry entry) {
    JMeterContext ctx = JMeterContextService.getContext();
    JMeterVariables vars = ctx.getVariables();

    SampleResult result = new SampleResult();
    result.setSampleLabel(getName());
    result.sampleStart();

    if (!initialized) {
      initialized = true;
      initialize(ctx.getThreadGroup());
    }

    doAction(result);

    result.sampleEnd();
    return result;
  }

  @Override
  public void testStarted(String host) {
    log.info("{}: Started ({})", whoAmI(), host);
  }

  @Override
  public void testStarted() {
    testStarted(null);
  }

  @Override
  public void testEnded(String host) {
    log.info("{}: Ended ({})", whoAmI(), host);
  }

  @Override
  public void testEnded() {
    testEnded(null);
  }

  @Override
  public boolean interrupt() {
    testEnded(null);

    return true;
  }
}
