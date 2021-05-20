curl -L -O https://github.com/CodeBrig/Journey/releases/download/0.4.0-69-assets/jcef-distrib-macintosh64.zip
unzip jcef-distrib-macintosh64.zip
rm -rf macosx64.zip
rm -rf jcef_app.app
mv ./macosx64/bin/jcef_app.app .
rm -rf macosx64
rm -rf jcef-distrib-macintosh64.zip
