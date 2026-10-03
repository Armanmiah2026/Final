package org.chromium.support_lib_boundary;

import java.lang.reflect.InvocationHandler;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public interface WebViewNavigationBoundaryInterface extends IsomorphicObjectBoundaryInterface {
    boolean didCommit();

    boolean didCommitErrorPage();

    InvocationHandler getPage();

    int getStatusCode();

    String getUrl();

    boolean isBack();

    boolean isForward();

    boolean isHistory();

    boolean isReload();

    boolean isRestore();

    boolean isSameDocument();

    boolean wasInitiatedByPage();
}
