[![Build Status](https://travis-ci.org/Vaznok/greeting_bot.svg?branch=master)](https://travis-ci.org/Vaznok/greeting_bot)

BUILD

    1. mvn clean install
    2. Launch greeting_bot-1.0.jar:
        - command to launch through the console java -jar ${project_path}/target/greeting_bot-1.0.jar
        - if you open project in IDEA use terminal command java -jar target/greeting_bot-1.0.jar

INFO

    1. Project was written using JDK 10. JDK 8 and less will cause issue with UTF-8 encoder of ResourceBundle.
    2. If you want to see UTF-8 message in window's console (launching .jar) you can make a shortcut (name it cmd.unicode.exe
    or whatever you like) and change its Target to 'C:\Windows\System32\cmd.exe /K chcp 65001'. Because by default windows encoder
    doesn't show UTF-8.