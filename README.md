src --> main --> java --> com.automation.test.api altında rest api test metotları bulunmaktadır
src --> main --> java --> com.automation.rest altında test metotlarında çağrılan servis istek atma metotları bulunmaktadır.
src--> main --> java --> com.automation.test.ui altında ui test metotları bulunmaktadır.
Kullanılan Firefox browser sürüm bilgisi --> 97.0.1 (x64bit)
Selenium testlerinin koşulduğu Chrome browser versiyon bilgisi -->  98.0.4758.109 (Official Build) (x86_64)
Chrome browser la uyumlu olacak şekilde chrome driver indirildi --> 
https://chromedriver.storage.googleapis.com/index.html?path=98.0.4758.102/
Build project(çekiç ikonu) butonun yanında bulunan (İntellij) seçim kutusundan kayıtlı DefaultConfig seçilip,
seçim kutusunun sağında bulunan Run butonuyla testler çalıştırılabilir
Config ayarlarında "class" için "com.automation.test" "VM Options" için "-ea -Dconfig=config/default.properties -Ddriver=chrome"
ayarı girilmiştir. İlgili ayarda -Ddriver=crome diye kaydedildiğinde testler chrome üzerinde, -Ddrive=gecko diye kaydedildiğinde
Firefox üzerinde koşacaktır.
