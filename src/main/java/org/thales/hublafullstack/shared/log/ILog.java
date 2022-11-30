package org.thales.hublafullstack.shared.log;

public interface ILog {
  void info(String info);
  void info(String message, Object... args);
  void error(String message);
}
