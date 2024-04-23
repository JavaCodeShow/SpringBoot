package com.jf.disruptor.log;

import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogEventHandler implements EventHandler<LogEvent> {
    @Override
    public void onEvent(LogEvent logEvent, long sequence, boolean endOfBatch) throws Exception {
        log.info(logEvent.getMessage());
    }

}