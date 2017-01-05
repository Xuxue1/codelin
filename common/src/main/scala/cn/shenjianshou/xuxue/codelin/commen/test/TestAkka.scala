package cn.shenjianshou.xuxue.codelin.commen.test

import akka.actor.{Actor, ActorSystem, Props}


/**
  * @author xuxue
  */
class TestAkka extends Actor{
    override def receive = {
        case "hello!" => println("hello");
        case s:String=> println(s)
    }
}


object TestAkka{

    def main(args: Array[String]): Unit = {
        val system = ActorSystem("HelloSystem")
        // create and start the actor
        val helloActor = system.actorOf(Props[TestAkka], name="helloActor")
        helloActor ! "hello!"
        helloActor ! "word!"
        Thread.sleep(Integer.MAX_VALUE)
    }


}
