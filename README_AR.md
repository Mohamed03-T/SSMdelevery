# وثيقة توضيحية للمشروع (DeliX)

ملخص: هذا ملف README يشرح هيكل المشروع، وظيفة كل مجلد/ملف رئيسي، ووصف جداول قاعدة البيانات وأعمدتها (مستمدة من كائنات الـ JPA - الـ entity).

## نظرة عامة على المجلدات الرئيسية

- `src/main/java/com/fsdm/pfe/delix`  
  حزمة التطبيق الأساسية. تحتوي على المجلدات الفرعية التالية (وصف عام لكلٍ):

  - `entity` — يحتوي على كائنات الـ JPA التي تمثل جداول قاعدة البيانات. كل ملف يمثل جدولاً (أو كياناً) مع الحقول (الأعمدة) والعلاقات.
  - `controller` — طبقة التحكم (MVC / REST). تحتوي على نقاط النهاية (endpoints) للتعامل مع الويب / الـ API. أمثلة: `AuthenticationController`, `HomeController`, `CustomerParcelController`, `AdminController`, `AgencyController`, وغيرهم.
  - `service` — طبقة الخدمات التي تحتوي على واجهات الخدمات (Business logic) مثل `UserService`, `ParcelService`, `PaymentService`.
  - `service/Impl` — تطبيقات واجهات الخدمات.
  - `repository` — واجهات الوصول للبيانات (Spring Data JPA Repositories) مثل `UserRepo`, `ParcelRepo`, `PaymentRepo`.
  - `dto` — كائنات نقل البيانات (Requests/Responses) المستخدمة بين الطبقات وواجهة المستخدم/الـ API.
  - `model` — نماذج مساعدة (مثل enums، value objects) مثل `ParcelStatus`, `PaymentMethod`, `MapsLocationPoint`.
  - `config` — ملفات ضبط وإعدادات الـ Spring (Security, Swagger, Jwt, AppConfig ...).
  - `exception` — تعريفات Exception handlers و Exceptions مخصصة.
  - `util`، `converters`, `validation` — أدوات مساعدة، محولات لقيم معينة، والـ Validators.
  - ملفات أخرى: `DeliXApplication.java` (نقطة الانطلاق - main), خدمات الـ JWT، Email، S3، Firebase initializer...

- `src/main/resources`  
  - `application.properties` — إعدادات Spring / DB / سلوك التطبيق.
  - `data.sql` — بيانات تحميل افتراضية (إن وُجدت).
  - `templates` — صفحات Thymeleaf (واجهات html) المستخدمة في جزء الويب: `home/`, `admin/`, `error/`, ...
  - `static` — ملفات ثابتة (css, js, img, vendor).
  - `firebase/delix-ma-firebase.json` — مفاتيح/إعدادات Firebase.
  - `lang` — ملفات ترجمة الرسائل.

- ملفات جذرية: `pom.xml`, `Dockerfile`, `readme.md`(الإنجليزي), سكربتات maven (`mvnw`, `mvnw.cmd`).

## وصف سريع لبعض المجلدات والملفات المهمة (وظيفة كل ملف رئيسي)

- `DeliXApplication.java` — ملف البداية (SpringBootApplication). يشغل التطبيق.
- `config/SecurityConfig.java` — تهيئة سياسات الأمن، جلب الـ filters، قواعد الوصول.
- `config/SwaggerConfig.java` — تهيئة الواجهات التوثيقية (Swagger/OpenAPI).
- `controller/AuthenticationController.java` — نقاط نهاية لتسجيل/تسجيل دخول المستخدمين وإصدار التوكنات.
- `controller/HomeController.java` — صفحات الويب العامة (index, login, register ...).
- `repository/*Repo.java` — واجهات Spring Data للوصول إلى الجداول (CRUD).
- `service/*Service.java` و `service/Impl/*` — المنطق التجاري.
- `converters/*` — محولات تُستخدم لتحويل أنواع مركبة إلى صفوف في الجدول والعكس.

> ملاحظة: إذا أردت وصفًا تفصيليًا لكل ملف (الـ 400+ ملف)، أستطيع توليد صفحة تفصيلية إضافية، لكني قمت هنا بتغطية الملفات والمجلدات الجوهرية. أخبرني إذا تريد تفصيلاً لملفات معينة أو مجلدات محددة.

## جداول قاعدة البيانات ووصف أعمدتها (مستخرج من الـ entities)

سأعرض كل كيان (Entity) كجدول مقترح مع الأعمدة ونوعها وشرح مختصر للعلاقة إن وُجدت.

1) Address
- id (PK) : Long
- area_id (FK -> Area) : ManyToOne
- address : String (العنوان النصي)
- creationDate : Date (timestamp, updatable=false)
- lastUpdateDate : Date

2) Admin (يرث من Employee -> من User)
- (يرث أعمدة User و Employee)
- adminEmployeeNumber : String
- privilegesGroup_id (FK -> PrivilegesGroup) : ManyToOne

3) Agency
- id (PK) : Long
- agencyName : String
- address_id (FK -> Address) : OneToOne
- agencyEstablishedDate : Date
- createdBy_id (FK -> Admin) : ManyToOne
- agencyContactNumber : String
- agencyEmail : String (unique)
- creationDate : Date
- lastUpdateDate : Date
- locationPoint : MapsLocationPoint (نوع مركب، محول/Validator)

4) AgencyEmployee (يرث Employee)
- associatedAgency_id : ManyToOne
- managerLevel : Integer
- agencyEmployeeRole : Enum (AgencyEmployeeRole)

5) Area
- id (PK) : Long
- createdAt : Date
- updatedAt : Date
- code : String (غير null)
- name : String
- city_code (FK -> City.code) : ManyToOne (مفتاح مرجعي على حقل code في City)
- postCode : String

6) City
- id (PK) : Long
- code : String
- name : String
- countryCode : String
- postalCode : String
- province_code (FK -> Province.code) : ManyToOne
- createdAt : Date
- updatedAt : Date

7) Customer (يرث User)
- customerNumber : String (unique)
- (parcels) : OneToMany -> Parcel

8) DeliveryAddress
- id (PK) : Long
- address : String
- area_id (FK -> Area)
- contactFirstName : String
- contactLastName : String
- contactNumber : String
- contactEmail : String
- creationDate : Date
- lastUpdateDate : Date

9) DeliveryArea
- id (PK) : Long
- areas : ManyToMany -> Area (مجموعة مناطق)
- areaName : String
- areaCode : String (unique)
- areaVertices : List<MapsLocationPoint> (محوّل لتخزين نقاط الخريطة)
- createdBy_id (FK -> Admin)
- creationDate : Date
- lastUpdateDate : Date

10) DeliveryMan
- locationPoint : MapsLocationPoint
- deliveryArea_id : ManyToOne -> DeliveryArea
- associatedAgency_id : ManyToOne -> Agency

11) Employee (يرث User)
- employeeNumber : String (unique)
- salary : double
- assignedBy_id : Admin (ManyToOne)

12) FirebaseUser
- id (PK) : Long
- messagingKey : String (مفتاح الرسائل)

13) Journey
- id (PK)
- transporter_id : ManyToOne -> Transporter
- jumpPaths : OneToMany -> JourneyPath
- startTime : Date
- endTime : Date
- departureAgency_id : ManyToOne -> Agency
- arrivalAgency_id : ManyToOne -> Agency
- journeyPath_id : ManyToOne -> JourneyPath
- journeyPlanPath_id : OneToOne -> JourneyPlanPath
- creationDate : Date
- lastUpdateDate : Date

14) JourneyPath
- id
- steps : OneToMany -> JourneyStep
- creationDate
- lastUpdateDate
- parcels : OneToMany -> Parcel

15) JourneyPlanPath
- id
- steps : OneToMany -> JourneyStep
- creationDate
- lastUpdateDate

16) JourneyStep
- id
- name : String
- description : String
- address : String
- stepStatus : Enum (StepStatus)
- area_id : ManyToOne -> Area

17) LoginLog
- id
- loginDate : Date
- user_id : ManyToOne -> User
- userAgent : String
- ipAddress : String
- loginStatus : boolean
- loginMethod : String

18) Notification
- id
- title : String
- message : String
- user : String (حقل نصي يُخزن المستخدم المستهدف أو معرفه)
- date : Date

19) Parcel
- id
- codeBar : String (unique, updatable = false)
- appointmentTime : int
- height, width, length, weight : floats
- status : Enum (ParcelStatus)
- Type : Enum (ParcelType)
- creationDate : Date
- lastUpdateDate : Date
- estimatedDeliveryDate : Date
- deleveryDate : Date
- parcelHistories : OneToMany -> ParcelHistory
- senderCustomer_id : ManyToOne -> Customer (sender)
- payment_id : OneToOne -> Payment
- pickupAddress_id : ManyToOne -> DeliveryAddress
- receiverAddress_id : ManyToOne -> DeliveryAddress
- departedAgency_id : ManyToOne -> Agency
- destinationAgency_id : ManyToOne -> Agency

20) ParcelHistory
- id (PK) : Long (محدد يدوياً في الكود)
- status : String
- ParcelTracking : Date
- currentLocation : ParcelLocation (محول)

21) PasswordResetToken
- id
- token : String
- user_id : OneToOne -> User
- expiryDate : Date
- createdDate : Date

22) Payment
- id
- paymentMethod : Enum (PaymentMethod)
- totalCost : float
- insuranceCost : float
- deliveryFees : float

23) Pricing
- id
- basePrice : double
- densityFactor : double
- distanceFactor : double
- insuranceCostFactor : double

24) PrivilegesGroup
- id
- name : String (unique)
- privileges : Set<Privilege> (محول لتخزين قائمة الصلاحيات)
- creationDate : Date
- lastUpdateDate : Date

25) Province
- id
- code : String (unique, not null)
- name : String
- countryCode : String
- postalCode : String
- createdAt : Date
- updatedAt : Date
- cities : OneToMany -> City

26) Transaction
- id
- user_id : ManyToOne -> User
- idempotencyKey : String (unique, updatable=false)
- amount : double (not null, min 0)
- transactionType : Enum (TransactionType) (DEBIT/CREDIT)
- description : String
- transactionDate : Date

27) Transporter
- (يرث VehicleOperatorEmployee)
- registrationNumber : String

28) TransporterTracking
- id
- currentLocation : String
- status : String
- updatedTime : Date
- latitude, longitude : double
- asigned_transporter_id : ManyToOne -> Transporter

29) User
- id
- firstName : String (not null)
- lastName : String
- email : String (unique, not null, updatable=false)
- password : String (write-only)
- role : String (discriminator column)
- phoneNumber : String
- address_id : ManyToOne -> Address
- registeredAt : ZonedDateTime
- lastUpdateDate : ZonedDateTime
- status : Enum (UserStatus)
- token : String (write-only, unique)
- refreshToken : String (write-only, unique)
- cin : String (pattern)
- dateOfBirth : Date
- balance : double
- image : String (URL)
- loginLogs : OneToMany -> LoginLog
- verifiedAt : Date
- firebaseUser : OneToOne -> FirebaseUser
- notifications : OneToMany -> Notification

30) VehicleOperatorEmployee (يرث Employee)
- licenseNumber : String
- vihiculeMtricule : String
- vehicleType : Enum (VehicleType)

31) VerificationToken
- id
- token : String (unique, not null)
- user_id : OneToOne -> User
- creationDate : Date

---

## ملاحظات عامة وEdge cases
- أسماء الجداول الافتراضية تتبع أسماء الكيانات (Entity) ما لم يتم تعريف @Table(name=...). مثال: `City` لديه @Table(name="city"). `User` لديه @Table(name="user").
- بعض الحقول عبارة عن أنواع مركبة (MapsLocationPoint, ParcelLocation, Set/Lists من enums) ويتم تحويلها بواسطة converters مخصصة عند التخزين.
- علاقات ManyToOne / OneToMany قد تخلق أعمدة FK (الاسم حسب @JoinColumn أو الحقل الافتراضي). بعض العلاقات تستخدم `referencedColumnName = "code"` بدلًا من PK (انظر Area -> City).

## كيف أستطيع مساعدتك أكثر؟
- أستطيع توليد README أكثر تفصيلاً: شرح لكل ملف داخل `controller` و`service` و`repository` (قائمة بجميع الملفات ووصف سطر واحد لكل ملف).
- أو أستطيع استخراج ملفات SQL (CREATE TABLE) تلقائياً اعتمادًا على الـ entities.

إن رغبت بتفصيل كامل لكل ملف داخل كل مجلد، قل لي أي مجلد تريده أولاً (مثلاً: `controller` أو `service` أو `repository`) وسأولّد قسمًا مفصلاً له.
