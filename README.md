# TUTORIAL SPRING BOOT DASAR
![Img 1](image/judul.png)

### Inversion of Control
* Inversion of Control (IoC) merupakan prinsip dalam pembuatan perangkat lunak, dimana kita melakukan pemindahan kontrol untuk objek atau program ke sebuah container di framework
* Tidak seperti biasanya ketika kita membuat aplikasi, dimana kita selalu melakukannya secara manual, dalam IoC, kita menyerahkan banyak pekerjakan ke container IoC 
* Container IoC memiliki kontrol untuk melakukan eksekusi program kita, memanajemen object pada program kita dan melakukan abstraction terhadap program kita
* Saat menggunakan framework IoC, kita biasanya akan mengikuti cara kerja framework tersebut

Spring Inversion of Control
* Spring bisa dibilang adalah framework IoC, dimana kita akan menyerahkan banyak sekali pekerjaan dalam program kita ke Spring
* * Kode program kita akan mengikuti cara kerja Spring


### Application Context
* ApplicationContext adalah sebuah interface representasi container IoC di Spring
* ApplicationContext adalah inti dari Spring Framework
* ApplicationContext banyak sekali class implementasinya, secara garis besar dibagi menjadi 2 jenis implementasi, XML dan Annotation
* Pada versi Spring 3, XML masih menjadi pilihan utama, namun sekarang sudah banyak orang beralih dari XML ke Annotation, bahkan Spring Boot pun merekomendasikan menggunakan Annotation untuk membuat aplikasi Spring
* [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/]ApplicationContext.html 

Configuration
* Untuk membuat ApplicationContext menggunakan Annotation, pertama kita bisa perlu membuat Configuration class
* Configuration Class adalah sebuah class yang terdapat annotation @Configuration pada class tersebut
* Kode : HelloWorldConfiguration
*![Img 2](image/2.PNG)

Membuat Application Context
* Selanjutnya, setelah membuat Class Configuration, kita bisa menggunakan class AnnotationConfigApplicationContext untuk membuat Application Context
* [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/AnnotationConfigApplicationContext.html] 
* Kode : Membuat Application Context
*![Img 3](image/3.PNG)


### Singleton
* Singleton adalah salah satu Design Patterns untuk pembuatan objek, dimana sebuah object hanya dibuat satu kali saja
* Dan ketika kita membutuhkan object tersebut, kita hanya akan menggunakan object yang sama * [https://refactoring.guru/design-patterns/singleto] 

Membuat Singleton di Java
* Ada banyak cara membuat singleton object di Java
* Cara yang paling sering digunakan adalah membuat class yang berisikan static method untuk membuat object dirinya sendiri
* Selanjutnya constructor nya dibuat private, agar tidak bisa diakses dari luar
* Sehingga user terpaksa menggunakan method static tersebut ketika ingin membuat object nya
* Kode : Singleton Class
*![Img 4](image/4.PNG)
*![image](https://user-images.githubusercontent.com/113462342/211357007-912d44ff-18be-4dd5-895f-99b6619192a1.png)


### Bean
* Saat sebuah object kita masukkan kedalam Spring Container IoC, maka kita sebut object tersebut adalah Bean
* Secara default, bean merupakan singleton, artinya jika kita mengakses bean yang sama, maka dia akan mengembalikan object yang sama. Kita juga bisa mengubahnya jika tidak ingin singleton, nanti akan kita bahas di materi tersendiri

Membuat Bean
* Untuk membuat bean, kita bisa membuat sebuah method di dalam class Configuration
* Selanjutnya nama method tersebut akan menjadi nama bean nya, dan return object nya menjadi object bean nya
* Method tersebut perlu kita tambahkan annotation @Bean, untuk menandakan bahwa itu adalah bean
* Secara otomatis Spring akan mengeksekusi method tersebut, dan return value nya akan dijadikan object bean secara otomatis, dan disimpan di container IoC
* Kode : Membuat Bean
*![image](https://user-images.githubusercontent.com/113462342/211357765-63225f38-3e36-428a-aaf8-b71b8a9a438c.png)


### Mengakses Bean
* Setelah kita membuat bean, secara otomatis semua object akan di-manage oleh Application Context
* Untuk mengakses bean, kita bisa menggunakan method getBean milik Application Context
* Kode : Mengakses Bean
*![image](https://user-images.githubusercontent.com/113462342/211358229-fdc1bfc5-7ff8-44fb-b00a-93dc2afcf25b.png)


### Duplicate Bean
* Di Spring, kita bisa mendaftarkan beberapa bean dengan tipe yang sama
* Namun perlu diperhatikan, jika kita membuat bean dengan tipe data yang sama, maka kita harus menggunakan nama bean yang berbeda
* Selain itu, saat kita mengakses bean nya, kita wajib menyebutkan nama bean nya, karena jika tidak, Spring akan bingung harus mengakses bean yang mana
* Kode : Duplicate Bean
*![image](https://user-images.githubusercontent.com/113462342/211358604-e4b2ab4f-7e7d-4a07-9efd-b852aa65caea.png)
 
* Kode : Mengakses Duplicate Bean
*![image](https://user-images.githubusercontent.com/113462342/211359005-911ffb4e-2f35-47e0-be28-4540898aebe4.png)


### Primary Bean
* Jika terjadi duplicate bean, selain kita sebSecarautkan nama bean nya ketika ingin mengakses bean nya, kita  juga bisa pilih salah satu bean menjadi primary
* Dengan memilih salah satunya menjadi primary, secara otomatis jika kita mengakses bean tanpa menyebutkan nama bean nya, secara otomatis primary nya yang akan dipilih
* Untuk memilih primary bean, kita bisa tambahkan annotaiton @Primary
* Kode : Primary Bean
*![image](https://user-images.githubusercontent.com/113462342/211359460-c8216f0e-850d-431d-82e5-c4cb3dea738d.png)
 
* Kode : Mengakses Primary Bean
*![image](https://user-images.githubusercontent.com/113462342/211359830-b10ed9ca-358a-4179-8fae-9b19f4471710.png)


### Mengubah Nama Bean
* Secara default, nama bean diambil dari nama method
* Namun kadang-kadang kita tidak ingin menggunakan nama method untuk nama bean
* Saat project kita sudah besar, kadang bisa jadi nama method sama, walaupun isi bean nya berbeda, dan di Spring, nama bean itu unik, tidak boleh sama
* Jika kita ingin mengubah nama bean, kita bisa menggunakan method value() milik annotation @Bean
* Kode : Mengubah Nama Bean
*![image](https://user-images.githubusercontent.com/113462342/211360287-bc0400fc-cb1a-44c7-81c1-105465f729aa.png)

* Kode : Mengakses Bean
*![image](https://user-images.githubusercontent.com/113462342/211360392-88445e79-022d-431f-8c54-fd70ad55a398.png)


### Dependency Injection
* Saat kita membuat object, sudah pasti kita sering membuat object yang tergantung dengan object lain
* Dependency Injection (DI) adalah teknik dimana kita bisa mengotomatisasi proses pembuatan object yang tergantung dengan object lain, atau kita sebut dependencies
* Dependencies akan secara otomatis di-inject (dimasukkan) kedalam object yang membutuhkannya
* Spring Framework sejak awal dibilang sebuah framework IoC yang memang cara kerjanya menggunakan 


#### Tanpa Dependency Injection
* Sebenarnya tanpa Dependency Injection pun, kita tetap bisa membuat aplikasi
* Namun ketika relasi antar dependencies sangat kompleks, agak ribet untuk kita melakukannya jika harus manual
* Oleh karena itu, penggunaan Dependency Injection framework seperti Spring sangat membantu sekali
* Kode : Class FoorBar
*![image](https://user-images.githubusercontent.com/113462342/211361175-bc1ff322-0a1a-438b-8309-5eb478b554c8.png)

* Kode : Tanpa Dependency Injection
*![image](https://user-images.githubusercontent.com/113462342/211361303-553da7fe-8ace-4699-82d1-8d51f4a4ef16.png)


#### Spring Dependency Injection
* Spring sejak awal dikenal dengan framework untuk Dependency Injection
* Ketika kita membuat method untuk bean di Spring, kita bisa menambahkan parameter 
* Secara otomatis Spring akan mencarikan bean lain yang sesuai dengan tipe parameter tersebut
* Jika ternyata tidak ada bean yang cocok, maka secara otomatis akan terjadi error
* Dan jika ternyata terdapat bean lebih dari satu, secara otomatis akan terjadi error, kecuali terdapat primary bean
* Kode : Bean Dependency Injection
 *![image](https://user-images.githubusercontent.com/113462342/211361915-0712a030-5696-4c42-839a-6651cca52c3c.png)

* Kode : Menggunakan Dependency Injectio
























