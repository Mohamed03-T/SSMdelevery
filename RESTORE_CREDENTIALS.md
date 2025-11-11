# 🔑 Restore Credentials Guide - دليل استعادة المفاتيح

## 📝 ملاحظة مهمة

الملفات الحالية تحتوي على placeholders فقط. اتبع هذا الدليل لاستعادة المفاتيح الحقيقية محلياً.

---

## 1️⃣ استعادة Constants.java

### الموقع:
```
src/main/java/com/fsdm/pfe/delix/util/Constants.java
```

### القيم المطلوبة:

```java
// Amazon S3 - استبدل هذه القيم
public final static String BUCKET_NAME = "YOUR_BUCKET_NAME";          // مثال: "delix-document"
public final static String AWS_ACCESS = "YOUR_AWS_ACCESS_KEY";        // من AWS Console
public final static String AWS_SECRET = "YOUR_AWS_SECRET_KEY";        // من AWS Console

// Firebase - استبدل هذه القيم
public final static String FIREBASE_MESSAGING_SENDER_ID = "YOUR_FIREBASE_SENDER_ID";  // من Firebase Console
public final static String FIREBASE_SERVER_KEY = "YOUR_FIREBASE_SERVER_KEY";          // من Firebase Console
```

### 📍 كيفية الحصول على القيم:

#### AWS Credentials:
1. افتح [AWS Console](https://console.aws.amazon.com/)
2. اذهب إلى **IAM** → **Users**
3. اختر المستخدم الخاص بك
4. **Security Credentials** → **Create Access Key**
5. انسخ `Access Key ID` و `Secret Access Key`

#### Firebase Credentials:
1. افتح [Firebase Console](https://console.firebase.google.com/)
2. اختر مشروعك
3. **Project Settings** → **Cloud Messaging**
4. انسخ **Sender ID** و **Server Key**

---

## 2️⃣ استعادة Firebase Service Account

### الموقع:
```
src/main/resources/firebase/delix-ma-firebase.json
```

### كيفية الحصول على الملف:

1. افتح [Firebase Console](https://console.firebase.google.com/)
2. اختر مشروعك (`delix-ma`)
3. ⚙️ **Project Settings** → **Service Accounts**
4. اضغط على **Generate New Private Key**
5. سيتم تحميل ملف JSON
6. **انسخ محتواه كاملاً** واستبدل محتوى `delix-ma-firebase.json`

---

## 3️⃣ التحقق من الإعدادات

بعد استعادة المفاتيح، تحقق من أن كل شيء يعمل:

```powershell
# تأكد أن الملفات غير مضافة لـ Git
git status

# يجب أن ترى رسالة:
# nothing to commit, working tree clean
# (لأن .gitignore يحميها)
```

---

## ⚠️ تحذيرات أمنية

### ✅ افعل:
- ✅ احتفظ بنسخة احتياطية آمنة من المفاتيح
- ✅ استخدم متغيرات البيئة في الإنتاج
- ✅ قم بتدوير المفاتيح المكشوفة

### ❌ لا تفعل:
- ❌ **لا تضف** الملفات الحساسة إلى Git
- ❌ **لا تشارك** المفاتيح عبر البريد الإلكتروني
- ❌ **لا تنشر** screenshots تحتوي على مفاتيح

---

## 🔄 تدوير المفاتيح (Recommended)

نظراً لأن المفاتيح كانت متاحة على GitHub، يُنصح **بشدة** بتدويرها:

### AWS:
```bash
# 1. احذف المفاتيح القديمة من AWS Console
# 2. ولّد مفاتيح جديدة
# 3. حدّث Constants.java
```

### Firebase:
```bash
# 1. احذف Service Account القديم
# 2. ولّد حساب جديد
# 3. حدّث delix-ma-firebase.json
```

---

## 📞 المساعدة

إذا واجهت مشاكل:
1. تحقق من `CONFIGURATION.md`
2. راجع `.gitignore` للتأكد من حماية الملفات
3. اتصل بالفريق للمساعدة

---

**آخر تحديث:** نوفمبر 12، 2025  
**الحالة:** تم تنظيف المستودع بنجاح ✅
