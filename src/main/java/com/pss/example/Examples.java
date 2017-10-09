package com.pss.example;

import org.broadleafcommerce.common.classloader.release.ThreadLocalManager;

public class Examples {
    private static ThreadLocal<String> THREAD_LOCAL = ThreadLocalManager.createThreadLocal(String.class, true);
    protected String a;
}
