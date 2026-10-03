package com.cbtunnel.plus.view;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class StatisticGraphData {
    private static final StatisticGraphData INSTANCE = new StatisticGraphData();
    private final DataTransferStats stats = new DataTransferStats();

    private StatisticGraphData() {
    }

    public static StatisticGraphData getStatisticData() {
        return INSTANCE;
    }

    public DataTransferStats getDataTransferStats() {
        return this.stats;
    }

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public static final class DataTransferStats {
        public void addBytesReceived(long j) {
        }

        public void addBytesSent(long j) {
        }
    }
}
