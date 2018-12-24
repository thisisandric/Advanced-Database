if not "%1"=="" goto genkey echo.
echo off
echo. Usage:
echo. %0 user-name echo.
goto :EOF
:genkey
set keytool="c:\Program Files\Java\jre6\bin\keytool"

%keytool% -v -genkey -keyalg RSA -validity 3650 -keystore %1.jks -storepass %1 -alias %1 -keypass %1 -dname "cn=%1"
%keytool% -export -keystore %1.jks -alias %1 -storepass %1 -file user.cert
%keytool% -import -noprompt -file user.cert -keystore trustedUsers.jks -alias %1 -storepass sealpass
