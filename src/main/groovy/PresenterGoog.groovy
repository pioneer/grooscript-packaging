import packaging.PackageManagerFactory
import packaging.GoogPackageManager


def packageManager = PackageManagerFactory.getPackageManager(GoogPackageManager)
packageManager.require('goog.crypt.base64')


class PresenterGoog {
    String name
    def buttonClick() {
        if (name) {
            def encodedName = packageManager.use('goog.crypt.base64.encodeString')(name)
            $('#salutes').append("<p>Hello ${encodedName}!</p>")
        }
    }
}