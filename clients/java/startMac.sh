JAVA_PATH="./jcef_app.app/Contents/Java"
FRAMEWORKS_PATH="./jcef_app.app/Contents/Frameworks"
RESOURCES_DIR_PATH="$(pwd)/jcef_app.app/Contents/Frameworks/Chromium Embedded Framework.framework/Resources"
which java
java -cp "build/classes:$JAVA_PATH:$JAVA_PATH/*" -Djava.library.path=$JAVA_PATH tests.detailed.MainFrame --main-bundle-path=./jcef_app.app/Contents/Frameworks/jcef\ Helper.app --framework-dir-path=$FRAMEWORKS_PATH/Chromium\ Embedded\ Framework.framework --browser-subprocess-path=$FRAMEWORKS_PATH/jcef\ Helper.app/Contents/MacOS/jcef\ Helper --resources-dir-path="$RESOURCES_DIR_PATH" --disable-gpu
