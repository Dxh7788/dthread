# dThread多线程  
## 1 线程管理
### 1.1 线程的创建和运行

### wait/notify/notifyAll
wait:
使当前线程等待,直至其他线程使用notify和notifyAll唤醒。当前线程必须有一个监控器。调用wait会释放监控锁。