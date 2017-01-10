package cn.shenjianshou.xuxue.codelin.commen

import org.slf4j.{Logger, LoggerFactory}

/**
  * Created by xuxue on 2017/1/7.
  */
trait Logging {
    @transient private var log_ : Logger = null

    protected def logName = {
        this.getClass.getName.stripSuffix("$")
    }

    protected def log:Logger={
        if (log_ == null) {
            initializeIfNecessary()
            log_ = LoggerFactory.getLogger(logName)
        }
        log_
    }

    private def initializeIfNecessary() {
        if (!Logging.initialized) {
            Logging.initLock.synchronized {
                if (!Logging.initialized) {
                    initializeLogging()
                }
            }
        }
    }

    private def initializeLogging():Logger=LoggerFactory.getLogger(logName)

}

object Logging{
    @volatile private var initialized = false
    val initLock = new Object()
    try {
        // We use reflection here to handle the case where users remove the
        // slf4j-to-jul bridge order to route their logs to JUL.
        val bridgeClass = Class.forName("org.slf4j.bridge.SLF4JBridgeHandler")
        bridgeClass.getMethod("removeHandlersForRootLogger").invoke(null)
        val installed = bridgeClass.getMethod("isInstalled").invoke(null).asInstanceOf[Boolean]
        if (!installed) {
            bridgeClass.getMethod("install").invoke(null)
        }
    } catch {
        case e: ClassNotFoundException => // can't log anything yet so just fail silently
    }
}




