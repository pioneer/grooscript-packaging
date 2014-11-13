package packaging

import org.grooscript.asts.GsNative
import packaging.BasePackageManager


class GoogPackageManager extends BasePackageManager {

    @GsNative
    def getRegistry() {/*
        return window; // goog.require appends objects to window,
                       // so then no need to maintain our own registry
    */}

    @GsNative
    def require(packageSpec) {/*
        goog.require(packageSpec);
    */}
}
