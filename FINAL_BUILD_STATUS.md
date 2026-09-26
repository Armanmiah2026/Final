# Sensei Tunnel V2 Final Build Status

- Version: 1.0.3 / versionCode 4
- Java/XML static checks: passed
- Missing R.id references: 0
- Duplicate XML id definitions: 0
- GitHub Actions compile fixes included:
  - ViewGroup import
  - favoriteMark variable conflict fix
  - Handler import
  - payloadOld final lambda snapshot
  - PayloadGeneratorDialog instance/static fix
- Gradle wrapper: 9.6.0
- GitHub Actions workflow: assembleDebug + APK artifact upload

## Local build limitation
This environment cannot download the Gradle 9.6.0 distribution from services.gradle.org (DNS/network blocked), so an actual APK binary could not be produced here. The project is prepared for the repository GitHub Actions runner, which can perform the real Android compilation.
