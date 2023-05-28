# Base image with OpenJDK
FROM openjdk

# src'yi belirttiğimiz paket adı olacak şekilde kopyalıyoruz
COPY src /pkt

# vermiş olduğumuz paket adını çalışma yolu olarak seçiyoruz
WORKDIR /pkt

# seleniumserver adında bir klasör yapısı oluşturuyor
RUN mkdir -p seleniumserver

# var olan dosyamızı/klasör yapımızı Docker imajına kopyalıyoruz
COPY seleniumserver seleniumserver

# bin klasörü oluşturuyoruz
RUN mkdir -p bin

# kullanmış olduğumuz jar dosyalarını build ediyoruz ve paket içindeki tüm .java dosyalarını .class haline getirerek bin klasörüne yerleştiriyoruz
RUN javac -cp .:seleniumserver/seleniumserver-4.8.3.jar -d bin ./pkt/*.java

# seleniumserver'ı Docker imajına kopyalıyoruz
COPY seleniumserver seleniumserver

# çalışma yolunu bin olarak değiştiriyoruz
WORKDIR bin

# çalıştırılacak dosyayı belirtiyoruz
CMD ["java", "-cp", ".:seleniumserver/seleniumserver-4.8.3.jar:Program.jar", "pkt.Program"]