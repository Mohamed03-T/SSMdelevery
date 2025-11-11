# Quick Credential Check Script
# سكريبت للتحقق السريع من المفاتيح

Write-Host "`n🔍 Checking credential files...`n" -ForegroundColor Cyan

# Check Constants.java
$constantsPath = "src\main\java\com\fsdm\pfe\delix\util\Constants.java"
if (Test-Path $constantsPath) {
    $content = Get-Content $constantsPath -Raw
    
    Write-Host "📄 Constants.java:" -ForegroundColor Yellow
    
    if ($content -match "YOUR_BUCKET_NAME") {
        Write-Host "   ⚠️  Still contains placeholders - NEEDS UPDATE" -ForegroundColor Red
    } else {
        Write-Host "   ✅ Contains actual values" -ForegroundColor Green
    }
    
    if ($content -match "YOUR_AWS_ACCESS_KEY") {
        Write-Host "   ⚠️  AWS credentials missing - NEEDS UPDATE" -ForegroundColor Red
    } else {
        Write-Host "   ✅ AWS credentials set" -ForegroundColor Green
    }
    
    if ($content -match "YOUR_FIREBASE_SENDER_ID") {
        Write-Host "   ⚠️  Firebase credentials missing - NEEDS UPDATE" -ForegroundColor Red
    } else {
        Write-Host "   ✅ Firebase credentials set" -ForegroundColor Green
    }
} else {
    Write-Host "   ❌ File not found!" -ForegroundColor Red
}

Write-Host ""

# Check Firebase JSON
$firebasePath = "src\main\resources\firebase\delix-ma-firebase.json"
if (Test-Path $firebasePath) {
    $fbContent = Get-Content $firebasePath -Raw
    
    Write-Host "📄 delix-ma-firebase.json:" -ForegroundColor Yellow
    
    if ($fbContent -match "YOUR_PROJECT_ID" -or $fbContent -match "YOUR_PRIVATE_KEY") {
        Write-Host "   ⚠️  Still contains placeholders - NEEDS UPDATE" -ForegroundColor Red
    } else {
        Write-Host "   ✅ Contains actual service account" -ForegroundColor Green
    }
} else {
    Write-Host "   ❌ File not found!" -ForegroundColor Red
}

Write-Host ""

# Check git status
Write-Host "📊 Git Status:" -ForegroundColor Yellow
$gitStatus = git status --porcelain | Where-Object { $_ -match "Constants.java|firebase.json" }
if ($gitStatus) {
    Write-Host "   ⚠️  Credential files appear in git status - Check .gitignore!" -ForegroundColor Red
    Write-Host "   Files:" -ForegroundColor White
    $gitStatus | ForEach-Object { Write-Host "   $_" -ForegroundColor Gray }
} else {
    Write-Host "   ✅ Credential files are ignored by git (protected)" -ForegroundColor Green
}

Write-Host "`n✨ Check complete!`n" -ForegroundColor Cyan
