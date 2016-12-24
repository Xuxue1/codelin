package cn.shenjianshou.xuxue.codelin.commen.util

import java.net.InetAddress

import scala.reflect.ClassTag


/**
  * Created by xuxue on 2016/12/21.
  */
final class IpRange(val start:Long,val end:Long) {

    val zero:Long=0

    val max:Long=0xffffffff

    def this(start:String,end:String)={
        this(IpRange.toLong(start), IpRange.toLong(end))
    }

    def map[A:ClassTag](function: Array[Byte]=>A):Array[A]=(start to end).map((ip)=>IpRange.toByte(ip)).map(function).toArray[A]

    def size :Long = end-start

}

object IpRange{

    private def toLong(ipString:String):Long={
        val ipArray=ipString.split("\\.").map(_.toLong)
        (ipArray(0) <<24)+(ipArray(1)<<16)+(ipArray(2)<<8)+ipArray(3)
    }

    private def toByte(ipLong:Long):Array[Byte]={
        Array((ipLong >> 24).toByte , ((ipLong & 0xff0000)>> 16).toByte, ((ipLong & 0xff00)>>8).toByte , (ipLong & 0xff).toByte)
    }

    def main(args: Array[String]): Unit = {
        new IpRange("192.168.0.81","192.168.1.0").map(InetAddress.getByAddress(_).getHostName).map(println)
    }
}


