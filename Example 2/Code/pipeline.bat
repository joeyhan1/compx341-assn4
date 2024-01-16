@echo off

echo:
echo (0) Preparing pipeline

echo:
echo (1) Build (Compiling the application)

REM Compile all the java files
javac -cp "gs-core-2.0.jar;gs-ui-swing-2.0.jar;junit-platform-console-standalone-1.8.2.jar;" *.java
REM Checking for errors and if the compiling is successful or not
IF %ERRORLEVEL% NEQ 0 (
    echo Build failed, exiting pipeline
    set /p DUMMY=Hit ENTER to finish....
    EXIT
) ELSE (
    echo Build succeeded
)

echo:
echo (2) Test (Running the test suite)

REM Running AccountLoginTests file
java -jar junit-platform-console-standalone-1.8.2.jar -cp ".;gs-core-2.0.jar;gs-ui-swing-2.0.jar" -c AccountLoginTests
REM Checking for errors and if the test was successful or not
IF %ERRORLEVEL% NEQ 0 (
    echo Test failed, exiting pipeline
    set /p DUMMY=Hit ENTER to finish....
    EXIT
) ELSE (
    echo Test succeeded
)

REM Running BuildingGraphTests file
java -jar junit-platform-console-standalone-1.8.2.jar -cp ".;gs-core-2.0.jar;gs-ui-swing-2.0.jar" -c BuildingGraphTests
REM Checking for errors and if the test was successful or not
IF %ERRORLEVEL% NEQ 0 (
    echo Test failed, exiting pipeline
    set /p DUMMY=Hit ENTER to finish....
    EXIT
) ELSE (
    echo Test succeeded
)

REM Running CategorisingDevicesTests file
java -jar junit-platform-console-standalone-1.8.2.jar -cp ".;gs-core-2.0.jar;gs-ui-swing-2.0.jar" -c CategorisingDevicesTests
REM Checking for errors and if the test was successful or not
IF %ERRORLEVEL% NEQ 0 (
    echo Test failed, exiting pipeline
    set /p DUMMY=Hit ENTER to finish....
    EXIT
) ELSE (
    echo Test succeeded
)

REM Running CategorisingUsersTests file
java -jar junit-platform-console-standalone-1.8.2.jar -cp ".;gs-core-2.0.jar;gs-ui-swing-2.0.jar" -c CategorisingUsersTests
REM Checking for errors and if the test was successful or not
IF %ERRORLEVEL% NEQ 0 (
    echo Test failed, exiting pipeline
    set /p DUMMY=Hit ENTER to finish....
    EXIT
) ELSE (
    echo Test succeeded
)

REM Running FeatureOptionsTests file
java -jar junit-platform-console-standalone-1.8.2.jar -cp ".;gs-core-2.0.jar;gs-ui-swing-2.0.jar" -c FeatureOptionsTests
REM Checking for errors and if the test was successful or not
IF %ERRORLEVEL% NEQ 0 (
    echo Test failed, exiting pipeline
    set /p DUMMY=Hit ENTER to finish....
    EXIT
) ELSE (
    echo Test succeeded
)

REM Running LoadingDatasetTests file
java -jar junit-platform-console-standalone-1.8.2.jar -cp ".;gs-core-2.0.jar;gs-ui-swing-2.0.jar" -c LoadingDatasetTests
REM Checking for errors and if the test was successful or not
IF %ERRORLEVEL% NEQ 0 (
    echo Test failed, exiting pipeline
    set /p DUMMY=Hit ENTER to finish....
    EXIT
) ELSE (
    echo Test succeeded
)

echo:
echo (3) Release (Committing to repo)

REM Checking for untracked and changes not staged for commit files
git status --porcelain --untracked-files=all | findstr "^??" > "%TEMP%\untracked_files.tmp"
git status --porcelain | findstr "^[AM]" > "%TEMP%\changes_not_staged.tmp"

REM Checking if untracked files are not empty
if exist "%TEMP%\untracked_files.tmp" (
    echo.
    echo Staging untracked files...
    git add .
)

REM Checking if changes not staged for commit are not empty
if exist "%TEMP%\changes_not_staged.tmp" (
    echo.
    echo Staging changes not staged for commit...
    git add .
)

REM Cleaning up temporary files
del "%TEMP%\untracked_files.tmp" 2>nul
del "%TEMP%\changes_not_staged.tmp" 2>nul

REM Checking for changes to be committed
git diff --cached --exit-code > nul 2>&1
if %errorlevel% equ 0 (
    echo No changes to be committed.
    goto :end
)

REM Prompt for commit message
set /p "message=Enter the commit message: "

REM Commit the changes with the specified message and push it to the gitlab
git commit -m "%message%"
git push https://courses-git.cms.waikato.ac.nz/jh433/compx341-assignment-4.git main

REM end is used to skip over the commit message prompting, committing and pushing
:end

echo:
echo (4) Deploy (Run application)

REM Message to show that we are running the application
echo Running Application:

REM Running the ConsoleApp java file
java -cp ".;gs-core-2.0.jar;gs-ui-swing-2.0.jar" ConsoleApp
REM Checking for errors and if the console app was successful or not
IF %ERRORLEVEL% NEQ 0 (
    echo Application failed, exiting pipeline
    set /p DUMMY=Hit ENTER to finish....
    EXIT
) ELSE (
    echo Application succeeded
)

REM Used to end the batch file
echo:
set /p DUMMY=Hit ENTER to finish....