اعتبارسنجی رشته‌های ورودی همیشه بخشی دردسرساز از طراحی‌سیستم‌هایی بوده است که با کاربر انسانی سر و کار دارند. در این سوال سعی می‌کنیم با طراحی شی‌گرا این قسمت‌ را راحت‌تر کنیم. در واقع به جای اینکه برای هر ورودی یک تابع بنویسیم تا ببینیم شرایط آن مورد قبول هست یا نه، مورد قبول بودن را به صورت مجموعه‌ای از قانون‌ها تعریف می‌کنیم. و اگر ورودی همه‌ی قانون‌ها را رعایت کرده بود، مورد قبول است. مثلا فرض کنید ورودی باید از ۲ قانون *ایمیل بودن* و *کمتر از ۱۲ کاراکتر بودن* طبعیت کند، یا ورودی دیگری نام کاربری است و صرفا باید بین ۳ تا ۱۰ کاراکتر باشد، حالا بدون اینکه برای هرکدام از ورودی‌ها یک تابع بنویسم. ۲ قانون *ایمیل بودن* و *محدودیت طول* را برای رشته‌ها تعریف می‌کنیم و آنها را به ورودی‌های رشته نسبت می‌دهیم.

حالا چطور باید این را با برنامه‌نویسی شی‌گرا پیاده‌سازی کنیم؟ از یک کلاس `StringValidator` استفاده می‌کنیم که نشان دهنده‌ی یک قانون به طور کلی است و قالب اعتبارسنجی توسط قانون‌ها را مشخص می‌کند. و دو کلاس فرزند `LengthValidator` (برای قانون محدودیت طول) و `EmailValidator` (برای ایمیل بودن)
تعریف می‌کنیم که از همان چهارچوب قانون کلی پیروی می‌کنند ولی پیاده‌سازی‌های مربوط به خودشان را دارند.

کلاس `FormField` برای نشان دادن ورودی‌های یک فرم طراحی شده است (کد این کلاس در زیر موجود است) و هر شی از این کلاس مختص یک ورودی است. در هنگام ساخت هر شی، تعدادی قانون دریافت می‌کنیم، و وقتی خواستیم ورودی را در `setValue` بدهیم، ابتدا چک می‌کند که آیا رشته‌ی ورودی در همه‌ی قوانین داده شده صدق می‌کند یا نه. در صورتی که در همه‌ی آنها صدق می‌کرد. مقدار فرم به این ورودی نسبت داده می‌شود.

![UML diagram](https://drive.google.com/uc?id=1EQXkCrTeMY92fDAwZG02y1Mj4lck1yqv)

برای این کار می‌توانیم از یک کلاس `StringValidator` استفاده کنیم که هدف آن به طور کلی اعتبارسنجی یک رشته است و با ساختن‌ کلاس‌های فرزند از آن و پیاده‌سازی آنها به اشکال مختلف محدودیت‌های متفاوت برای یک رشته را توضیح می‌دهیم.


همانطور که در نمودار `UML` بالا مشاهده می‌کنید، کلاس `StringValidator` دو متد با پیاده‌سازی پیشفرض دارد. متد `validate` که یک رشته را گرفته و مورد قبول بودن آن را به صورت یک متغیر `boolean` برمی‌گرند. و متد `getMessage` که پیغام خطا مربوطه را برمی‌گرداند.

یک کلاس فرزند به نام `LengthValidator` داریم که رشته را بر اساس طول آن اعتبارسنجی می‌کند. در constructor آن دو پارامتر وجود دارد که مینیمم و ماکسیمم طول رشته را به ترتیب مشخص می‌کند. اگر هر یک از این پارامترها برابر -1 داده‌ شود، به این معنی است که از آن سمت محدودیتی وجود ندارد.

یک کلاس فرزند دیگر نیز به نام `EmailValidator` وجود دارد که تعیین می‌کند آیا این رشته یک ایمیل هست یا نه.

- برای هر دو کلاس `LengthValidator` و `EmailValidator` باید متد `getMessage()` به طور مناسب، نسبت به متد کلاس پدر متغییر داده شود.
 
 - جواب را به صورت یک فایل  `zip` آپلود کنید که در آن یک پوشه‌ی `validation` وجود دارد و کلاس‌های خواسته شده در آن پوشه هستند.

برای نمونه‌ی استفاده از این کلاس ما یک کلاس `FormField` تعریف کرده‌ایم که یک ورودی در یک فرم را مدل‌سازی می‌کند و `costructor` این کلاس، یک `ArrayList` از `StringValidator`ها دریافت می‌شود که محدودیت‌های مربوط به این ورودی فرم را مشخص می‌کند و در هنگام مقداردهی این ورودی فرم در متد `setValue` اگر هیچ کدام از `StringValidator`ها خطا نداد، این فیلد مقداردهی می‌شود و در غیر این صورت یک `ArrayList` از `String` که خطاهای مربوطه هستند بازگردانی می‌شود. می‌توانید کد این کلاس را در زیر مشاهده کنید.

```java
import validation.EmailValidator;
import validation.LengthValidator;
import validation.StringValidator;
public class FormField {
    public ArrayList<StringValidator> validators;
    public String name;
    private String value;

    public FormField(String fieldName, ArrayList<StringValidator> validators) {
        this.validators = validators;
        this.name = fieldName;
        this.value = null;
    }

    /**
     * @param value if no,error happens value is set;
     * @return errros
     */
    public ArrayList<String> setValue(String value) {
        ArrayList<String> errors = new ArrayList<>();
        for (StringValidator validator : this.validators) {
            if (!validator.validate(value))
                errors.add(validator.getMessage());
        }
        if (errors.isEmpty())
            this.value = value;
        return errors;
    }

    public String getValue() {
        return value;
    }
}

```

برای تست کردن برنامه‌ی خود می‌توانید یک تابع `main` به این شکل بسازید و با استفاده از کلاس‌هایی که ساختید و کلاس `FormField` ، برنامه‌ی خود را امتحان کنید.

**نمونه‌:**

```java
    public static void main(String[] args) {
        // we collect errors in this ArrayList
        ArrayList<String> errors;
        // name should be at least 3 and at most 20 characters
        ArrayList<StringValidator> nameValidators = new ArrayList<>();
        nameValidators.add(new LengthValidator(3, 10));
        FormField nameField = new FormField("name", nameValidators);

        errors = nameField.setValue("ab");
        System.out.println("errors for string \"ab\"");
        System.out.println(errors.toString());

        errors = nameField.setValue("12345678901");
        System.out.println("errors for string \"12345678901\"");
        System.out.println(errors.toString());

        errors = nameField.setValue("majid");
        if (errors.isEmpty()) {
            System.out.printf("no errors, field value is \"%s\"\n", nameField.getValue());
        }

        //email should be an email address and at most 12 characters
        ArrayList<StringValidator> emailValidators = new ArrayList<>();
        emailValidators.add(new EmailValidator());
        emailValidators.add(new LengthValidator(-1, 11));
        FormField emailField = new FormField("email", emailValidators);

        System.out.println("Testing emailField:");

        errors = emailField.setValue("lorem@gmail");
        System.out.println("errors for string \"loremipsum@gmail.com\"");
        System.out.println(errors.toString());

        errors = emailField.setValue("b@gmail.com");

        if (errors.isEmpty()) {
            System.out.printf("no errors, field value is \"%s\"\n", emailField.getValue());
        }

    }
```

**خروجی نمونه:**

```text
errors for string "ab"
[String length is not between [3,10]]
errors for string "12345678901"
[String length is not between [3,10]]
no errors, field value is "majid"
Testing emailField:
errors for string "loremipsum@gmail.com"
[Input is not a valid Email]
no errors, field value is "b@gmail.com"
```
