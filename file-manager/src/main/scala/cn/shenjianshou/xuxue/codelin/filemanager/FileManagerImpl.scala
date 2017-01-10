import java.nio.ByteBuffer

import cn.shenjianshou.xuxue.codelin.filemanager.FileCache

class FileManagerImpl extends FileCache.Iface{


    override def readyPut(filePath: String) = ???

    override def readyDownload(filePath: String) = ???

    override def avliable(fileId: Int) = ???

    override def read(off: Int, len: Int) = ???

    override def write(off: Int, data: ByteBuffer) = ???
}