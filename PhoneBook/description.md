هدف از این سوال این است که یک دفترچه تلفن در *command-line* طراحی کنید. در این دفترچه تلفن برای هر مخاطب نام، نام خانوادگی، شماره تلفن همراه، آدرس ایمیل و تاریخ تولد نگهداری می‌شود.  هر مخاطب موجود در دفترچه تلفن یک شناسه یا `id` دارد که عددی طبیعی است. چند عمل برای این دفترچه تلفن تعریف می‌شود:

### اضافه کردن مخاطب
اطلاعات مخاطب به ترتیب اشاره شده وارد می‌شود و شناسه‌ی این مخاطب بازگردانده می‌شود.
**مثال:**
```
enter your command: add
	first name: James
	last name: Holden
	phone number: +989123456789
	email: someone@somemail.com
	birthdate: 2010/22/9
####
id: 3
```

### لیست کردن مخاطبین
اطلاعات تمامی کاربران موجود به ترتیب وارد شده چاپ می‌شود.

**مثال:**
```
enter your command: list
####
id: 3
first name: James
last name: Holden
phone number: +989123456789
email: someone@somemail.com
birthdate: 2010/22/9
####
id: 5
first name: Bernard
last name: Lowe
phone number: +989123498765
email: bernard@wwc.com
birthdate: 2000/12/9
```


### جستجوی مخاطب بر اساس شماره‌ی همراه
شناسه‌ و اطلاعات یک مخاطب که این شماره‌ی همراه را دارد چاپ می‌شود. در صورتی که هیچ مخاطبی با این شماره یافت نشد، `no contacts found` چاپ شود.

```
enter your command: search-by-phone
phone number: +989123498765
####
id: 5
first name: Bernard
last name: Lowe
phone number: +989123498765
email: bernard@wwc.com
birthdate: 2000/12/9
```


### جستجوی مخاطب بر اساس پست ایمیل
شناسه‌ و اطلاعات مخاطب که ایمیل وارد شده را دارد چاپ می‌شود. در صورتی که هیچ مخاطبی با این ایمیل یافت نشد، `no contacts found` چاپ شود.

- دقت داشته باشید که ایمیل‌ها، حساس به حروف کوچک و بزرگ (*case sensitive*) نیستند.

**مثال:**
```
enter your command: search-by-email
email: dolores@gmail.com
####
no contacts found
```

### پایان برنامه
با وارد شدن `exit` برنامه‌ی شما پایان می‌یابد.

**مثال:**
```
enter your command: exit
```
