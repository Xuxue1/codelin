package cn.shenjianshou.xuxue.codelin.commen.test

import scala.reflect.ClassTag

object Test{
  def main(args: Array[String]): Unit = {

  }
  def hello():Unit={
    println("Hello")
  }
}

class Test[A:ClassTag]{

}