package ru.alxpro.jmeter.mqtester;

import java.util.HashMap;

public interface Producer {

  String doAction(HashMap<String, String> headers, String key, String body);

  default void shutdownBase() throws Exception {
  }

  default void shutdown() {
  }
}
