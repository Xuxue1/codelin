package cn.shenjianshou.xuxue.codelin.commen

/**
  * Created by xuxue on 2017/1/7.
  */
class Test  extends Logging{
    def say():Unit={
        log.info("Hello")
    }
}

object Test{

    def main(args: Array[String]): Unit = {

        new Test().say()

    }

}
