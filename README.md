grooscript-packaging
====================

Implementation of generic packaging management for Grooscript. Currently supports Google Closure Library and Dojo Toolkit. Dojo Toolkit version is mostly an AMD implementation, so it can be used with other AMD systems.

What's left:

* fix error when requiring packages with just a single names w\o dots, such as `require("mylibrary")`
* probably it's better to use these classes through annotations?
* probably it's better to use static classes instead of singleton factory? (need better Grooscript support for that)
* currently, the only good way to use stuff from modules is to do `require()` at the beginning of the file, and `use()` within the method, otherwise you'll get an error, due to module is loaded asynchronously and some time is needed for it to load
