#prod
android_binary(
  name = "jenkinsapp-prod",
  custom_package = "com.app.jenkinsapp",
  manifest = "src/main/AndroidManifest.xml",
  srcs = glob(["src/main/java/**"]),
  resource_files = glob(["src/main/res/**"]),
  deps = [
    "@androidsdk//com.android.support:appcompat-v7-25.0.0",
    "@androidsdk//com.android.support:design-25.0.0",
    "@androidsdk//com.android.support:recyclerview-v7-25.0.0",
    "@androidsdk//com.android.support:support-annotations-25.0.0",
    "@javax_inject//jar:jar",
    "@otto//jar:jar",
    "@jenkinscommon//:jenkins-common",
    "@dagger//jar:jar",
    "@jsr250api//jar:jar",
    "@timber//:timber",
    "@daggercompiler//jar:jar",
    "@databinding//jar:jar",
    "@databindingcompilercommon//jar:jar",
    "@databindingcompiler//jar:jar",
    ]
)

#debug
android_binary(
  name = "jenkinsapp-debug",
  custom_package = "com.app.jenkinsapp.debug",
  manifest = "src/main/AndroidManifest.xml",
  srcs = glob(["src/main/java/**"]),
  resource_files = glob(["src/main/res/**"]),
  deps = [
      "@androidsdk//com.android.support:appcompat-v7-25.0.0",
      "@androidsdk//com.android.support:design-25.0.0",
      "@androidsdk//com.android.support:recyclerview-v7-25.0.0",
      "@androidsdk//com.android.support:support-annotations-25.0.0",
      "@otto//jar:jar",
      "@jenkinscommon//:jenkins-common",
      "@daggercompiler//jar:jar",
      "@timber//:timber",
    ]
)





