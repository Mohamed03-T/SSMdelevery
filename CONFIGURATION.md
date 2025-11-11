# 🔐 Configuration Guide - دليل الإعداد

## ⚠️ Important - مهم

هذا المشروع يحتاج إلى إعدادات خاصة قبل التشغيل. يرجى اتباع الخطوات التالية:

## 📋 Required Steps - الخطوات المطلوبة

### 1️⃣ Constants Configuration

انسخ الملف القالب وقم بتعديله:

```bash
# Windows PowerShell
copy src\main\java\com\fsdm\pfe\delix\util\Constants.java.example src\main\java\com\fsdm\pfe\delix\util\Constants.java

# Linux/Mac
cp src/main/java/com/fsdm/pfe/delix/util/Constants.java.example src/main/java/com/fsdm/pfe/delix/util/Constants.java
```

ثم قم بتعديل القيم التالية في `Constants.java`:

```java
// Amazon S3
public final static String BUCKET_NAME = "YOUR_BUCKET_NAME";  // اسم الـ bucket الخاص بك
public final static String AWS_ACCESS = "YOUR_AWS_ACCESS_KEY";  // مفتاح الوصول AWS
public final static String AWS_SECRET = "YOUR_AWS_SECRET_KEY";  // المفتاح السري AWS

// Firebase
public final static String FIREBASE_MESSAGING_SENDER_ID = "YOUR_FIREBASE_SENDER_ID";
public final static String FIREBASE_SERVER_KEY = "YOUR_FIREBASE_SERVER_KEY";
```

### 2️⃣ Firebase Configuration

انسخ الملف القالب وقم بتعديله:

```bash
# Windows PowerShell
copy src\main\resources\firebase\delix-ma-firebase.json.example src\main\resources\firebase\delix-ma-firebase.json

# Linux/Mac
cp src/main/resources/firebase/delix-ma-firebase.json.example src/main/resources/firebase/delix-ma-firebase.json
```

ثم ضع بيانات حساب الخدمة الخاص بك من Firebase Console:

1. اذهب إلى Firebase Console
2. اختر مشروعك
3. Project Settings → Service Accounts
4. Generate New Private Key
5. انسخ محتوى الملف المُحمّل إلى `delix-ma-firebase.json`

### 3️⃣ Application Properties

انسخ ملف الإعدادات (إذا كان موجودًا كـ example):

```bash
# Windows PowerShell
copy src\main\resources\application.properties.example src\main\resources\application.properties

# Linux/Mac
cp src/main/resources/application.properties.example src/main/resources/application.properties
```

## 🚨 Security Notes - ملاحظات أمنية

- ⛔ **لا تشارك** هذه الملفات بعد تعبئتها
- 🔒 الملفات محمية بواسطة `.gitignore`
- 📝 استخدم ملفات `.example` كمرجع فقط
- 🔐 احتفظ بنسخة احتياطية آمنة من المفاتيح

## 📚 Additional Resources

- [AWS Credentials](https://docs.aws.amazon.com/general/latest/gr/aws-sec-cred-types.html)
- [Firebase Admin SDK Setup](https://firebase.google.com/docs/admin/setup)

---

Made with ❤️ for secure development
