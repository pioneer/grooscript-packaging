package packaging

import org.grooscript.asts.GsNative
import packaging.BasePackageManager


class DojoPackageManager extends BasePackageManager {

    def registry = [:]

    def getRegistry() { registry }

    @GsNative
    def require(packageSpec) {/*
        require([packageSpec.split(".").join("/")], function(module){
            gs.mc(gSobject,"storeModule",[packageSpec, module]); // a bit tricky,
                                                                 // may be incompatible with
                                                                 // future Grooscript versions
        });
    */}

    def storeModule(packageSpec, module) {
        def packageSpecElements = packageSpec.tokenize(".")
        def currentObj = registry
        packageSpecElements[0..-2].each {
            currentObj[it] = [:]
            currentObj = currentObj[it]
        }
        currentObj[packageSpecElements.last()] = module
    }
}
