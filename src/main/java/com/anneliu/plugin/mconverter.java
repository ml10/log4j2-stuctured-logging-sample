package com.anneliu.plugin;

import static com.anneliu.plugin.SensitiveInfoEraser.replaceSensitiveInfo;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;

@Plugin(name = "logmask", category = "Converter")
@ConverterKeys({"lm"})
public class mconverter extends LogEventPatternConverter {

  public mconverter(String[] options) {
    super("lm", "lm");
    System.out.println(options.toString());
  }

  public static mconverter newInstance(final String[] options) {
    return new mconverter(options);
  }

  @Override
  public void format(LogEvent logEvent, StringBuilder outputMsg) {
    //String message = logEvent.getMessage().getFormat();
    String message = logEvent.getMessage().getFormattedMessage();
    //System.out.println("========== raw info is " + message);
    outputMsg.append(replaceSensitiveInfo(message.toString()));
    //outputMsg.append(message.toString());
  }


}
