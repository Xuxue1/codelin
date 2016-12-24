package cn.shenjianshou.xuxue.codelin.commen.event

/**
  * Created by xuxue on 2016/12/22.
  */
abstract class Event{
    val timestamp=System.currentTimeMillis();
}

trait EventHandler[EVENT <: Event]{
    def handler(event: EVENT)
}



case class HelloEvent(element:String) extends Event;

class HelloEventHandler extends EventHandler[HelloEvent]{

    override def handler(event: HelloEvent) ={
        println(event.element+event.timestamp)
    }
}




object HelloEventHandler{

    def main(args: Array[String]): Unit = {
        var x=new HelloEvent("haha")
        var hander=new HelloEventHandler
        hander.handler(x)
    }

}