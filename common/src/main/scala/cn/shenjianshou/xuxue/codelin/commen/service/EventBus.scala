package cn.shenjianshou.xuxue.codelin.commen.service

/**
  * Created by xuxue on 2016/12/22.
  */
trait EventBus {
    type Event
    type EventHandler

    def handle(event: Event,eventHandler: EventHandler)={

    }
}

class EventBusIm extends EventBus{
    override type Event = this.type
    override type EventHandler = this.type

    override def handle(event: EventBusIm.this.type, eventHandler: EventBusIm.this.type) = ???
}
