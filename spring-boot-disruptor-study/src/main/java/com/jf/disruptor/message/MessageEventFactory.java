package com.jf.disruptor.message;

import com.lmax.disruptor.EventFactory;

public class MessageEventFactory implements EventFactory<MessageModel> {

    @Override
    public MessageModel newInstance() {
        return new MessageModel();
    }
}