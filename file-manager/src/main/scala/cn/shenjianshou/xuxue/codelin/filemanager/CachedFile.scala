package cn.shenjianshou.xuxue.codelin.filemanager

import java.io.{File , IOException}

/**
  * Created by xuxue on 2017/1/10.
  */
@throws (classOf[IOException])
class CachedFile(val path:String) {
    val file=new File(path)
    var timestamp = System.currentTimeMillis()


}
