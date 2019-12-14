A practice in Katalon Studio: callExternalScript()
========

This is a Katalon Studio project for demonstration purpose.

This project was inspired by a eposes a Forum discussion:
[Executing a method from an array](https://forum.katalon.com/t/executing-a-method-from-an-array/37473/)

I was interested in this discussion, and got a question:

> Let me assume that I have a set of Groovy Script files located outside a Katalon Studio project. Is it possible for a TestCase script in a Katalon Studio to load and execute these external scripts?

Having this question in mind, I wrote [`Test Cases/reinvent/main`](Scripts/GroovyShell/main/Script1576283878899.groovy).
It implements a function `callExternalScript(Path file)`. I think that `callExternalScript` looks similar to the built-in `WebUI.callTestCase()` keyword. Have I reinvented Katalon Studio here? :smile_cat:
