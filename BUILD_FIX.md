Build fix applied for GitHub Actions Java compilation.

Fixed:
1. MainActivity.java: probeProfileAsync() had malformed nested braces/parentheses around the Xray outbound probe, causing `catch without try` and cascading parser errors.
2. V2RayService.java: removed the extra closing class brace at the end of the file.

Validation performed:
- Java parser/brace/parenthesis lexical checks passed for all app Java sources.
- javac parse stage produced no Java syntax errors before Android dependency resolution; missing Android/Gradle dependencies are environment-related.
- ZIP integrity verified with unzip -t.

The project still needs a normal Android/Gradle environment (or GitHub Actions) to perform the full APK build.
