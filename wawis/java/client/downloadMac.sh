wget https://github.com/jcefbuild/jcefbuild/releases/download/v1.0.10-83.4.0%2Bgfd6631b%2Bchromium-83.0.4103.106/macosx64.zip
unzip macosx64.zip
rm -rf macosx64.zip
rm -rf jcef_app.app
mv java-cef-build-bin/bin/jcef_app.app .
rm -r java-cef-build-bin
