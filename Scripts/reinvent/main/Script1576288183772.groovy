import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.charset.StandardCharsets
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

def callExternalScript(Reader reader) {
	def shell = new GroovyShell()
	return shell.evaluate(reader)
}

def callExternalScript(Path path) {
	WebUI.comment(">>> callin up ${path}")
	Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)
	return callExternalScript(reader)
}
def callExternalScript(File file) {
	WebUI.comment(">>> callin up ${file}")
	Reader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)
	return callExternalScript(reader)
}
def callExternalScript(String string) {
	Reader reader = new StringReader(string)
	return callExternalScript(reader)
}

Path findExternalScript(String scriptName) {
	Path project = Paths.get(RunConfiguration.getProjectDir())
	return findExternalScript(project, scriptName)
}
Path findExternalScript(Path basedir, String scriptName) {
	Path scripts = basedir.resolve('Include/externalScripts')
	Path script = scripts.resolve(scriptName)
	if (!Files.exists(script))
		throw new FileNotFoundException(script.toString())
	return script
}
List<Path> findExternalScripts() {
	Path project = Paths.get(RunConfiguration.getProjectDir())
	return findExternalScripts(project)
}
List<Path> findExternalScripts(Path basedir) {
	Path scripts = basedir.resolve('Include/externalScripts')
	return Files.walk(scripts)
		.filter { item -> Files.isRegularFile(item) && item.toString().endsWith('.groovy') }
		.collect();
}
//println findExternalScripts()

WebUI.comment(">>> activating a single script")
callExternalScript(findExternalScript('FB.groovy'))

//
WebUI.comment(">>> activating all scrits")
for (Path f in findExternalScripts()) {
	callExternalScript(f)
}

// Execute scripts outside the project
WebUI.comment("download a script from GitHub and immediately run it")
String url = "https://raw.githubusercontent.com/kazurayam/ReinventTestCaseInvocation/master/Include/externalScripts/AMZN.groovy"
callExternalScript(new URL(url).getText())
