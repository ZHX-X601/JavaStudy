@echo off
set /p commit_msg=Enter commit message:

if "%commit_msg%"=="" (
    set commit_msg=update
    echo Empty input, using default: update
)

git add .
git commit -m "%commit_msg%"
git push

echo.
echo Done!
pause
