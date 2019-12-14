callExternalScript(Path) function
========

This is a Katalon Studio project for demonstration purpose.

I was inspired by a Katalon Forum discussion and got a question to myself:

> When I have a set of Groovy Scripts located outside a Katalon Studio project, is it possible for a TestCase script in a Katalon Studio to load and execute these external scripts?

I wrote [`Test Cases/reinvent/main`](Scripts/reinvent/main/Script1576288183772.groovy). It worked for me. Guys, please try runing it.

`Test Cases/reinvent/main` implements a function `callExternalScript(Path file)` which can load and execute Groovy script located anywhere, even outside the Katalon Studio project. An instance of `groovy.lang.GroovyShell` does this magic.

The function `callExternalScript(Path)` looks similar to the KS-builtin `WebUI.callTestCase()` keyword. But it is different. This is a re-invention.
