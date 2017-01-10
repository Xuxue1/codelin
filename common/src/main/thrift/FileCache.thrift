namespace java cn.shenjianshou.xuxue.codelin.commen.thrift

service FileCache{
    i32 readyPut(1:string filePath)
    i32 readyDownload(1:string filePath)
    i32 avliable(1:i32 fileId)
    binary read(1:i32 off, 2:i32 len)
    void write(1:i32 off,2:binary data);
    void clean(1:i32 fileId);
}