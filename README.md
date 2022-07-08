## Smoke Project Structure

### Modules

Naming Schema: `{plugin}{targets}{type}`

**plugin**:
One of:

- `multiplatform` -> `kotlin("multiplatform")`
- `jvm` -> `kotlin("jvm")`
- `android` -> `kotlin("android")`

**targets**
Flat list of all targets supported by the module.
e.g. a project supporting android, jvm and ios:
`AndroidJvmIos`

**type**
One of:

- `Library`
- `App`

Library modules can be depended on!

### multiplatformAndroidJvmIosLibrary

- Multiplatform with targets: `android, jvm, iosX64`
- dependencies: []

## multiplatformAndroidJvmIosLibrary2

- Multiplatform with targets:  `android, jvm, iosX64`
- dependencies: [`multiplatformAndroidJvmIosLibrary`, `multiplatformAndroidLibrary`, `multiplatformJvmLibrary`, `jvmLibrary`]
- 
## multiplatformJvmLibrary

- Multiplatform with targets:  `jvm`
- dependencies: [`multiplatformAndroidJvmIosLibrary`, `okio`]

## multiplatformAndroidLibrary

- Multiplatform with targets: `android`
- dependencies: [`multiplatformAndroidJvmIosLibrary`, `okio`]

## jvmLibrary

- jvm project
- dependencies: [`multiplatformAndroidJvmIosLibrary`, `multiplatformJvmLibrary`]

## androidApp

- android application project
- dependencies: [`multiplatformAndroidJvmIosLibrary`, `multiplatformJvmLibrary`, `multiplatformAndroidLibrary`, `jvmLibrary`]

## multiplatformAndroidApp

- Multiplatform with targets: `android`
- dependencies: [`multiplatformAndroidJvmIosLibrary`, `multiplatformJvmLibrary`, `multiplatformAndroidLibrary`, `jvmLibrary`, `okio`]
