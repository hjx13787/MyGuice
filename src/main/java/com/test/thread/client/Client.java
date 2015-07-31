package com.test.thread.client;

import com.test.thread.ThreadPool;
import com.test.thread.Worker;

/**
 * 客户端测试类
 * @author lifh
 * @mail wslfh2005@163.com
 * @since 2012-6-22 下午03:25:36
 * @name .Client.java
 * @version 1.0
 */
public class Client {
    public static void main(String[] args) {
        ThreadPool queue = new ThreadPool(10);
        for(int i=0;i<100;i++){
            queue.execute(new Worker(i));
        }
    }
}
