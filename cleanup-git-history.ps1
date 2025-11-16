# 🧹 Git History Cleanup Script
# This script removes sensitive files from Git history

Write-Host "🔒 Starting Git history cleanup..." -ForegroundColor Yellow
Write-Host ""

# Files to remove from history (updated to new backend paths)
$filesToRemove = @(
    "backend/src/main/java/com/fsdm/pfe/delix/util/Constants.java",
    "backend/src/main/resources/firebase/delix-ma-firebase.json"
)

Write-Host "📝 Files to remove from Git history:" -ForegroundColor Cyan
foreach ($file in $filesToRemove) {
    Write-Host "   - $file" -ForegroundColor White
}
Write-Host ""

Write-Host "⚠️  WARNING: This will rewrite Git history!" -ForegroundColor Red
Write-Host "⚠️  Make sure you have pushed the latest commit first!" -ForegroundColor Red
Write-Host ""
Write-Host "📋 Steps to complete:" -ForegroundColor Yellow
Write-Host "1. Backup your current credentials (save Constants.java and firebase json)" -ForegroundColor White
Write-Host "2. Run: git filter-branch --force --index-filter 'git rm --cached --ignore-unmatch backend/src/main/java/com/fsdm/pfe/delix/util/Constants.java backend/src/main/resources/firebase/delix-ma-firebase.json' --prune-empty --tag-name-filter cat -- --all" -ForegroundColor White
Write-Host "3. Run: git push origin --force --all" -ForegroundColor White
Write-Host "4. Run: git push origin --force --tags" -ForegroundColor White
Write-Host "5. Restore your credentials locally (copy from backup)" -ForegroundColor White
Write-Host ""
Write-Host "💡 Alternative using BFG Repo Cleaner (faster):" -ForegroundColor Cyan
Write-Host "1. Download BFG: https://rtyley.github.io/bfg-repo-cleaner/" -ForegroundColor White
Write-Host "2. Run: java -jar bfg.jar --delete-files Constants.java" -ForegroundColor White
Write-Host "3. Run: java -jar bfg.jar --delete-files delix-ma-firebase.json" -ForegroundColor White
Write-Host "4. Run: git reflog expire --expire=now --all" -ForegroundColor White
Write-Host "5. Run: git gc --prune=now --aggressive" -ForegroundColor White
Write-Host "6. Run: git push origin --force --all" -ForegroundColor White
Write-Host ""
Write-Host "✅ After cleanup, notify all team members to:" -ForegroundColor Green
Write-Host "   Clone fresh copy of the repository" -ForegroundColor White
Write-Host ""
