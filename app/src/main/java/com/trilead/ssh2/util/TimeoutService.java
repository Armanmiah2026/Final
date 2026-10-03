package com.trilead.ssh2.util;

import com.trilead.ssh2.log.Logger;
import java.util.Collections;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class TimeoutService {
    private static final Logger log = Logger.getLogger(TimeoutService.class);
    private static final LinkedList todolist = new LinkedList();
    private static Thread timeoutThread = null;

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public static class TimeoutThread extends Thread {
        public /* synthetic */ TimeoutThread(int i) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (TimeoutService.todolist) {
                while (TimeoutService.todolist.size() != 0) {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        TimeoutToken timeoutToken = (TimeoutToken) TimeoutService.todolist.getFirst();
                        if (timeoutToken.runTime > jCurrentTimeMillis) {
                            try {
                                TimeoutService.todolist.wait(timeoutToken.runTime - jCurrentTimeMillis);
                            } catch (InterruptedException unused) {
                            }
                        } else {
                            TimeoutService.todolist.removeFirst();
                            try {
                                timeoutToken.handler.run();
                            } catch (Exception e) {
                                TimeoutService.log.log(20, "Exception in Timeout handler", e);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                TimeoutService.timeoutThread = null;
            }
        }

        private TimeoutThread() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public static class TimeoutToken implements Comparable {
        private final Runnable handler;
        private final long runTime;

        public /* synthetic */ TimeoutToken(long j, Runnable runnable, int i) {
            this(j, runnable);
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            long j = this.runTime;
            long j2 = ((TimeoutToken) obj).runTime;
            if (j > j2) {
                return 1;
            }
            return j == j2 ? 0 : -1;
        }

        private TimeoutToken(long j, Runnable runnable) {
            this.runTime = j;
            this.handler = runnable;
        }
    }

    public static final TimeoutToken addTimeoutHandler(long j, Runnable runnable) {
        int i = 0;
        TimeoutToken timeoutToken = new TimeoutToken(j, runnable, i);
        LinkedList linkedList = todolist;
        synchronized (linkedList) {
            try {
                linkedList.add(timeoutToken);
                Collections.sort(linkedList);
                Thread thread = timeoutThread;
                if (thread != null) {
                    thread.interrupt();
                } else {
                    TimeoutThread timeoutThread2 = new TimeoutThread(i);
                    timeoutThread = timeoutThread2;
                    timeoutThread2.setDaemon(true);
                    timeoutThread.start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return timeoutToken;
    }

    public static final void cancelTimeoutHandler(TimeoutToken timeoutToken) {
        LinkedList linkedList = todolist;
        synchronized (linkedList) {
            try {
                linkedList.remove(timeoutToken);
                Thread thread = timeoutThread;
                if (thread != null) {
                    thread.interrupt();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
