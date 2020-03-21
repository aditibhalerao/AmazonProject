set projectLocation=E:\Workspace\AmazonProject
 
cd %projectLocation%
 
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
 
java org.testng.TestNG %projectLocation%\testng.xml
 
pause