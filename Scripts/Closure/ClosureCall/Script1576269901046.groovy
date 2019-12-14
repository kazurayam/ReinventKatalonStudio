import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
def gafa = [
	{
		WebUI.openBrowser("https://www.google.com/")
		WebUI.delay(1)
		WebUI.closeBrowser()
	},
	{
		WebUI.openBrowser("https://www.amazon.com/")
		WebUI.delay(1)
		WebUI.closeBrowser()
	},
	{
		WebUI.openBrowser("https://www.facebook.com/")
		WebUI.delay(1)
		WebUI.closeBrowser()
	},
	{
		WebUI.openBrowser("https://www.apple.com/")
		WebUI.delay(1)
		WebUI.closeBrowser()
	}
]
gafa.each { closure ->
	closure.call()
}
