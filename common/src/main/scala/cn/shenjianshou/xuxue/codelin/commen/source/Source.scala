package cn.shenjianshou.xuxue.codelin.commen.source

/**
  * 资源的抽象
  * Created by xuxue on 2017/1/5.
  */

abstract class Source

case class MemorySource(val size:Int,val used:Int) extends Source

case class CPUSource(val kernel:Int,val used:Double) extends Source
