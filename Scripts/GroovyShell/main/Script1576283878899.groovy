import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Path findExternalScript(String scriptName) {
	Path project = Paths.get(RunConfiguration.getProjectDir())
	Path scripts = project.resolve('Include/externalScripts')
	Path script = scripts.resolve(scriptName)
	if (!Files.exists(script))
		throw new FileNotFoundException(script.toString())
	return script
}

List<Path> findExternalScripts() {
	Path project = Paths.get(RunConfiguration.getProjectDir())
	Path scripts = project.resolve('Include/externalScripts')
	return Files.walk(scripts)
		.filter { item -> Files.isRegularFile(item) && item.toString().endsWith('.groovy') }
		.collect();
}
//println findExternalScripts()

void callExternalScript(Path file) {
	WebUI.comment(">>> callin up ${file}")
	def shell = new GroovyShell()
	shell.evaluate(file.toFile())
}

WebUI.comment(">>> activating a single script")
callExternalScript(findExternalScript('FB.groovy'))

//
WebUI.comment(">>> activating all scrits")
for (Path f in findExternalScripts()) {
	callExternalScript(f)
}
