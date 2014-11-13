grooscript-packaging
====================

Implementation of generic packaging management for Grooscript. Currently supports Google Closure Library and Dojo Toolkit. Dojo Toolkit version is mostly an AMD implementation, so it can be used with other AMD systems.

Code is mostly a stuff which `gradle initStaticWeb` generates, with additional classes which maintain loaders.

Usage: clone this repo, and run `gradle convert` task. After that, try to open pages below in your browser:

* for Google Closure Library loader, open `src/main/webapp/index-goog.html`
* for Dojo Toolkit loader, open `src/main/webapp/index-goog.html`

How to use it in Groovy code:

    import packaging.PackageManagerFactory
    import packaging.GoogPackageManager  // import whatever implementation you need


    def packageManager = PackageManagerFactory.getPackageManager(GoogPackageManager) // initialize package manager
    packageManager.require('goog.crypt.base64') // load a module

    ...

    class MyClass {

        def myMethod(data) {
            def encodeString = packageManager.use('goog.crypt.base64.encodeString') // get an object or a function from the module
            def myData = encodeString(data)
            println "Encoded data: $myData"
        }

    }

What's left:

* fix error when requiring packages with just a single names w\o dots, such as `require("mylibrary")`
* probably it's better to use these classes through annotations?
* probably it's better to use static classes instead of singleton factory? (need better Grooscript support for that)
* __asynchronous loading of modules__: currently, the only good way to use stuff from modules is to do `require()` at the beginning of the file, and `use()` within the method, otherwise you'll get an error, due to module is loaded asynchronously and some time is needed for it to load
* more packaging managers, such as from CommonJS, Ext JS
* export objects and modules written in Groovy, to underlying package system, in order for them to be available for importing from Javascript via package system, and from Grooscript via grooscript-packaging
