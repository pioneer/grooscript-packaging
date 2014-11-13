import packaging.PackageManagerFactory
import packaging.DojoPackageManager


def packageManager = PackageManagerFactory.getPackageManager(DojoPackageManager)
packageManager.require('dojox.encoding.base64')


class PresenterDojo {
    String name
    def buttonClick() {
        if (name) {
            def encodedName = packageManager.use('dojox.encoding.base64.encode')(name)
            $('#salutes').append("<p>Hello ${encodedName}!</p>")
        }
    }
}