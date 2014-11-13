package packaging


class PackageManagerFactory {

    private static INSTANCE = null

    static def getPackageManager(managerClass) {
        if(!PackageManagerFactory.INSTANCE) {
            PackageManagerFactory.INSTANCE = managerClass.newInstance()
        }
        PackageManagerFactory.INSTANCE
    }

}