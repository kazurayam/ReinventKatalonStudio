import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

def boringStuff(String url) {
	WebUI.openBrowser(url)
	WebUI.delay(1)
	WebUI.closeBrowser()
}
def gafa = [
	{ boringStuff("https://www.google.com/") },
	{ boringStuff("https://www.amazon.com/") },
	{ boringStuff("https://www.facebook.com/") },
	{ boringStuff("https://www.apple.com/") }
]
gafa.each { closure ->
	closure.call()
}
