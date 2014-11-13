package packaging


abstract class BasePackageManager {

    abstract def getRegistry()

    def use(packageSpec) {
        packageSpec.tokenize(".").inject(registry) { obj, pathComponent ->
            obj = obj[pathComponent]
        }
    }

    abstract def require(packageSpec)
}
